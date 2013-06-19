/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.cassandra.thrift;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.antlr.runtime.RecognitionException;
import org.apache.cassandra.auth.Permission;
import org.apache.cassandra.concurrent.Stage;
import org.apache.cassandra.concurrent.StageManager;
import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.config.ConfigurationException;
import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.config.FTMetaData;
import org.apache.cassandra.config.KSMetaData;
import org.apache.cassandra.config.Schema;
import org.apache.cassandra.cql.QueryProcessor;
import org.apache.cassandra.db.ColumnFamily;
import org.apache.cassandra.db.ColumnFamilyStore;
import org.apache.cassandra.db.ColumnFamilyType;
import org.apache.cassandra.db.CounterMutation;
import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.db.ExpiringColumn;
import org.apache.cassandra.db.IColumn;
import org.apache.cassandra.db.IMutation;
import org.apache.cassandra.db.RangeSliceCommand;
import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.db.Row;
import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.db.SliceByNamesReadCommand;
import org.apache.cassandra.db.SliceFromReadCommand;
import org.apache.cassandra.db.Table;
import org.apache.cassandra.db.context.CounterContext;
import org.apache.cassandra.db.filter.QueryPath;
import org.apache.cassandra.db.marshal.MarshalException;
import org.apache.cassandra.db.migration.AddColumnFamily;
import org.apache.cassandra.db.migration.AddKeyspace;
import org.apache.cassandra.db.migration.DropColumnFamily;
import org.apache.cassandra.db.migration.DropKeyspace;
import org.apache.cassandra.db.migration.Migration;
import org.apache.cassandra.db.migration.UpdateColumnFamily;
import org.apache.cassandra.db.migration.UpdateKeyspace;
import org.apache.cassandra.delta.DeltaFunction;
import org.apache.cassandra.delta.DeltaFunctionStore;
import org.apache.cassandra.delta.LargeValue;
import org.apache.cassandra.delta.LargeValueWrapper;
import org.apache.cassandra.delta.DeltaFunctionStore.FunctionType;
import org.apache.cassandra.dht.AbstractBounds;
import org.apache.cassandra.dht.Bounds;
import org.apache.cassandra.dht.IPartitioner;
import org.apache.cassandra.dht.Range;
import org.apache.cassandra.dht.Token;
import org.apache.cassandra.io.util.FastByteArrayOutputStream;
import org.apache.cassandra.locator.DynamicEndpointSnitch;
import org.apache.cassandra.scheduler.IRequestScheduler;
import org.apache.cassandra.service.ClientState;
import org.apache.cassandra.service.SocketSessionManagementService;
import org.apache.cassandra.service.StorageProxy;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.Pair;
import org.apache.cassandra.utils.app.AppCase;
import org.apache.cassandra.utils.app.ConvertData;
import org.apache.cassandra.utils.app.DeltaData;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;

public class CassandraServer implements Cassandra.Iface {
	private static Logger logger = LoggerFactory
			.getLogger(CassandraServer.class);

	private final static int COUNT_PAGE_SIZE = 1024;

	private final static List<ColumnOrSuperColumn> EMPTY_COLUMNS = Collections
			.emptyList();
	private final static List<Column> EMPTY_SUBCOLUMNS = Collections
			.emptyList();
	private final static List<CounterColumn> EMPTY_COUNTER_SUBCOLUMNS = Collections
			.emptyList();

	// thread local state containing session information
	public final ThreadLocal<ClientState> clientState = new ThreadLocal<ClientState>() {
		@Override
		public ClientState initialValue() {
			return new ClientState();
		}
	};

	/*
	 * RequestScheduler to perform the scheduling of incoming requests
	 */
	private final IRequestScheduler requestScheduler;

	public CassandraServer() {
		requestScheduler = DatabaseDescriptor.getRequestScheduler();
	}

	public ClientState state() {
		SocketAddress remoteSocket = SocketSessionManagementService.remoteSocket
				.get();
		ClientState retval = null;
		if (null != remoteSocket) {
			retval = SocketSessionManagementService.instance.get(remoteSocket);
			if (null == retval) {
				retval = new ClientState();
				SocketSessionManagementService.instance.put(remoteSocket,
						retval);
			}
		} else {
			retval = clientState.get();
		}
		return retval;
	}

	protected Map<DecoratedKey, ColumnFamily> readColumnFamily(
			List<ReadCommand> commands, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException {
		// TODO - Support multiple column families per row, right now row only
		// contains 1 column family
		Map<DecoratedKey, ColumnFamily> columnFamilyKeyMap = new HashMap<DecoratedKey, ColumnFamily>();

		if (consistency_level == ConsistencyLevel.ANY) {
			throw new InvalidRequestException(
					"Consistency level any may not be applied to read operations");
		}

		List<Row> rows;
		try {
			schedule(DatabaseDescriptor.getRpcTimeout());
			try {
				rows = StorageProxy.read(commands, consistency_level);
			} finally {
				release();
			}
		} catch (TimeoutException e) {
			throw new TimedOutException();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		for (Row row : rows) {
			columnFamilyKeyMap.put(row.key, row.cf);
		}
		return columnFamilyKeyMap;
	}

	public List<Column> thriftifySubColumns(Collection<IColumn> columns) {
		if (columns == null || columns.isEmpty()) {
			return EMPTY_SUBCOLUMNS;
		}

		ArrayList<Column> thriftColumns = new ArrayList<Column>(columns.size());
		for (IColumn column : columns) {
			if (column.isMarkedForDelete()) {
				continue;
			}
			Column thrift_column = new Column(column.name()).setValue(
					column.value()).setTimestamp(column.timestamp());
			if (column instanceof ExpiringColumn) {
				thrift_column.setTtl(((ExpiringColumn) column).getTimeToLive());
			}
			thriftColumns.add(thrift_column);
		}

		return thriftColumns;
	}

	public List<CounterColumn> thriftifyCounterSubColumns(
			Collection<IColumn> columns) {
		if (columns == null || columns.isEmpty()) {
			return EMPTY_COUNTER_SUBCOLUMNS;
		}

		ArrayList<CounterColumn> thriftColumns = new ArrayList<CounterColumn>(
				columns.size());
		for (IColumn column : columns) {
			if (column.isMarkedForDelete()) {
				continue;
			}
			assert column instanceof org.apache.cassandra.db.CounterColumn;
			CounterColumn thrift_column = new CounterColumn(column.name(),
					CounterContext.instance().total(column.value()));
			thriftColumns.add(thrift_column);
		}

		return thriftColumns;
	}

	public List<ColumnOrSuperColumn> thriftifyColumns(
			Collection<IColumn> columns, boolean reverseOrder) {
		ArrayList<ColumnOrSuperColumn> thriftColumns = new ArrayList<ColumnOrSuperColumn>(
				columns.size());
		for (IColumn column : columns) {
			if (column.isMarkedForDelete()) {
				continue;
			}
			if (column instanceof org.apache.cassandra.db.CounterColumn) {
				CounterColumn thrift_column = new CounterColumn(column.name(),
						CounterContext.instance().total(column.value()));
				thriftColumns.add(new ColumnOrSuperColumn()
						.setCounter_column(thrift_column));
			} else {

				Column thrift_column = new Column(column.name()).setValue(
						column.value() != null ? column.value() : AppCase
								.write(column.getObjValue(), column
										.getDeltaData())).setTimestamp(
						column.timestamp()).setVersion(column.version());
				if (column instanceof ExpiringColumn) {
					thrift_column.setTtl(((ExpiringColumn) column)
							.getTimeToLive());
				}
				thriftColumns.add(new ColumnOrSuperColumn()
						.setColumn(thrift_column));
			}
		}

		// we have to do the reversing here, since internally we pass results
		// around in ColumnFamily
		// objects, which always sort their columns in the "natural" order
		// TODO this is inconvenient for direct users of StorageProxy
		if (reverseOrder)
			Collections.reverse(thriftColumns);
		return thriftColumns;
	}

	private List<ColumnOrSuperColumn> thriftifySuperColumns(
			Collection<IColumn> columns, boolean reverseOrder,
			boolean isCounterCF) {
		if (isCounterCF)
			return thriftifyCounterSuperColumns(columns, reverseOrder);
		else
			return thriftifySuperColumns(columns, reverseOrder);
	}

	private List<ColumnOrSuperColumn> thriftifySuperColumns(
			Collection<IColumn> columns, boolean reverseOrder) {
		ArrayList<ColumnOrSuperColumn> thriftSuperColumns = new ArrayList<ColumnOrSuperColumn>(
				columns.size());
		for (IColumn column : columns) {
			List<Column> subcolumns = thriftifySubColumns(column
					.getSubColumns());
			if (subcolumns.isEmpty()) {
				continue;
			}
			SuperColumn superColumn = new SuperColumn(column.name(), subcolumns);
			thriftSuperColumns.add(new ColumnOrSuperColumn()
					.setSuper_column(superColumn));
		}

		if (reverseOrder)
			Collections.reverse(thriftSuperColumns);

		return thriftSuperColumns;
	}

	private List<ColumnOrSuperColumn> thriftifyCounterSuperColumns(
			Collection<IColumn> columns, boolean reverseOrder) {
		ArrayList<ColumnOrSuperColumn> thriftSuperColumns = new ArrayList<ColumnOrSuperColumn>(
				columns.size());
		for (IColumn column : columns) {
			List<CounterColumn> subcolumns = thriftifyCounterSubColumns(column
					.getSubColumns());
			if (subcolumns.isEmpty()) {
				continue;
			}
			CounterSuperColumn superColumn = new CounterSuperColumn(column
					.name(), subcolumns);
			thriftSuperColumns.add(new ColumnOrSuperColumn()
					.setCounter_super_column(superColumn));
		}

		if (reverseOrder)
			Collections.reverse(thriftSuperColumns);

		return thriftSuperColumns;
	}

	private Map<ByteBuffer, List<ColumnOrSuperColumn>> getSlice(
			List<ReadCommand> commands, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException {
		Map<DecoratedKey, ColumnFamily> columnFamilies = readColumnFamily(
				commands, consistency_level);
		Map<ByteBuffer, List<ColumnOrSuperColumn>> columnFamiliesMap = new HashMap<ByteBuffer, List<ColumnOrSuperColumn>>();
		for (ReadCommand command : commands) {
			ColumnFamily cf = columnFamilies.get(StorageService
					.getPartitioner().decorateKey(command.key));
			boolean reverseOrder = command instanceof SliceFromReadCommand
					&& ((SliceFromReadCommand) command).reversed;
			List<ColumnOrSuperColumn> thriftifiedColumns = thriftifyColumnFamily(
					cf, command.queryPath.superColumnName != null, reverseOrder);
			columnFamiliesMap.put(command.key, thriftifiedColumns);
		}

		return columnFamiliesMap;
	}

	private List<ColumnOrSuperColumn> thriftifyColumnFamily(ColumnFamily cf,
			boolean subcolumnsOnly, boolean reverseOrder) {
		if (cf == null || cf.isEmpty())
			return EMPTY_COLUMNS;
		if (subcolumnsOnly) {
			IColumn column = cf.iterator().next();
			Collection<IColumn> subcolumns = column.getSubColumns();
			if (subcolumns == null || subcolumns.isEmpty())
				return EMPTY_COLUMNS;
			else
				return thriftifyColumns(subcolumns, reverseOrder);
		}
		if (cf.isSuper()) {
			boolean isCounterCF = cf.metadata().getDefaultValidator()
					.isCommutative();
			return thriftifySuperColumns(cf.getSortedColumns(), reverseOrder,
					isCounterCF);
		} else {
			return thriftifyColumns(cf.getSortedColumns(), reverseOrder);
		}
	}

	public List<ColumnOrSuperColumn> get_slice(ByteBuffer key,
			ColumnParent column_parent, SlicePredicate predicate,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			UnavailableException, TimedOutException {
		logger.debug("get_slice");

		state().hasColumnFamilyAccess(column_parent.column_family,
				Permission.READ);
		return multigetSliceInternal(state().getKeyspace(),
				Collections.singletonList(key), column_parent, predicate,
				consistency_level).get(key);
	}

	public Map<ByteBuffer, List<ColumnOrSuperColumn>> multiget_slice(
			List<ByteBuffer> keys, ColumnParent column_parent,
			SlicePredicate predicate, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException {
		logger.debug("multiget_slice");

		state().hasColumnFamilyAccess(column_parent.column_family,
				Permission.READ);
		return multigetSliceInternal(state().getKeyspace(), keys,
				column_parent, predicate, consistency_level);
	}

	private Map<ByteBuffer, List<ColumnOrSuperColumn>> multigetSliceInternal(
			String keyspace, List<ByteBuffer> keys, ColumnParent column_parent,
			SlicePredicate predicate, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException {
		CFMetaData metadata = ThriftValidation.validateColumnFamily(keyspace,
				column_parent.column_family);
		ThriftValidation.validateColumnParent(metadata, column_parent);
		ThriftValidation.validatePredicate(metadata, column_parent, predicate);
		ThriftValidation.validateConsistencyLevel(keyspace, consistency_level);

		List<ReadCommand> commands = new ArrayList<ReadCommand>();
		if (predicate.column_names != null) {
			for (ByteBuffer key : keys) {
				ThriftValidation.validateKey(metadata, key);
				commands.add(new SliceByNamesReadCommand(keyspace, key,
						column_parent, predicate.column_names));
			}
		} else {
			SliceRange range = predicate.slice_range;
			for (ByteBuffer key : keys) {
				ThriftValidation.validateKey(metadata, key);
				commands.add(new SliceFromReadCommand(keyspace, key,
						column_parent, range.start, range.finish,
						range.reversed, range.count));
			}
		}

		return getSlice(commands, consistency_level);
	}

	private ColumnOrSuperColumn internal_get(ByteBuffer key,
			ColumnPath column_path, ConsistencyLevel consistency_level)
			throws InvalidRequestException, NotFoundException,
			UnavailableException, TimedOutException {
		state().hasColumnFamilyAccess(column_path.column_family,
				Permission.READ);
		String keyspace = state().getKeyspace();

		CFMetaData metadata = ThriftValidation.validateColumnFamily(keyspace,
				column_path.column_family);
		ThriftValidation.validateColumnPath(metadata, column_path);
		ThriftValidation.validateConsistencyLevel(keyspace, consistency_level);

		QueryPath path = new QueryPath(column_path.column_family,
				column_path.column == null ? null : column_path.super_column);
		List<ByteBuffer> nameAsList = Arrays
				.asList(column_path.column == null ? column_path.super_column
						: column_path.column);
		ThriftValidation.validateKey(metadata, key);
		ReadCommand command = new SliceByNamesReadCommand(keyspace, key, path,
				nameAsList);

		Map<DecoratedKey, ColumnFamily> cfamilies = readColumnFamily(Arrays
				.asList(command), consistency_level);

		ColumnFamily cf = cfamilies.get(StorageService.getPartitioner()
				.decorateKey(command.key));

		if (cf == null)
			throw new NotFoundException();
		List<ColumnOrSuperColumn> tcolumns = thriftifyColumnFamily(cf,
				command.queryPath.superColumnName != null, false);
		if (tcolumns.isEmpty())
			throw new NotFoundException();
		assert tcolumns.size() == 1;
		return tcolumns.get(0);
	}

	public ColumnOrSuperColumn get(ByteBuffer key, ColumnPath column_path,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			NotFoundException, UnavailableException, TimedOutException {
		logger.debug("get");

		return internal_get(key, column_path, consistency_level);
	}

	public int get_count(ByteBuffer key, ColumnParent column_parent,
			SlicePredicate predicate, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException {
		logger.debug("get_count");

		state().hasColumnFamilyAccess(column_parent.column_family,
				Permission.READ);
		Table table = Table.open(state().getKeyspace());
		ColumnFamilyStore cfs = table
				.getColumnFamilyStore(column_parent.column_family);

		if (predicate.column_names != null)
			return get_slice(key, column_parent, predicate, consistency_level)
					.size();

		int pageSize;
		// request by page if this is a large row
		if (cfs.getMeanColumns() > 0) {
			int averageColumnSize = (int) (cfs.getMeanRowSize() / cfs
					.getMeanColumns());
			pageSize = Math.min(COUNT_PAGE_SIZE, DatabaseDescriptor
					.getInMemoryCompactionLimit()
					/ averageColumnSize);
			pageSize = Math.max(2, pageSize);
			logger.debug("average row column size is {}; using pageSize of {}",
					averageColumnSize, pageSize);
		} else {
			pageSize = COUNT_PAGE_SIZE;
		}

		int totalCount = 0;
		List<ColumnOrSuperColumn> columns;

		if (predicate.slice_range == null) {
			predicate.slice_range = new SliceRange(
					ByteBufferUtil.EMPTY_BYTE_BUFFER,
					ByteBufferUtil.EMPTY_BYTE_BUFFER, false, Integer.MAX_VALUE);
		}

		int requestedCount = predicate.slice_range.count;
		while (true) {
			predicate.slice_range.count = Math.min(pageSize, requestedCount);
			columns = get_slice(key, column_parent, predicate,
					consistency_level);
			if (columns.isEmpty())
				break;

			totalCount += columns.size();
			requestedCount -= columns.size();
			ColumnOrSuperColumn lastColumn = columns.get(columns.size() - 1);
			ByteBuffer lastName = lastColumn.isSetSuper_column() ? lastColumn.super_column.name
					: (lastColumn.isSetColumn() ? lastColumn.column.name
							: (lastColumn.isSetCounter_column() ? lastColumn.counter_column.name
									: lastColumn.counter_super_column.name));
			if ((requestedCount == 0)
					|| ((columns.size() == 1) && (lastName
							.equals(predicate.slice_range.start)))) {
				break;
			} else {
				predicate.slice_range.start = lastName;
				// remove the count for the column that starts the next slice
				totalCount--;
				requestedCount++;
			}
		}

		return totalCount;
	}

	public Map<ByteBuffer, Integer> multiget_count(List<ByteBuffer> keys,
			ColumnParent column_parent, SlicePredicate predicate,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			UnavailableException, TimedOutException {
		logger.debug("multiget_count");

		state().hasColumnFamilyAccess(column_parent.column_family,
				Permission.READ);
		String keyspace = state().getKeyspace();

		Map<ByteBuffer, Integer> counts = new HashMap<ByteBuffer, Integer>();
		Map<ByteBuffer, List<ColumnOrSuperColumn>> columnFamiliesMap = multigetSliceInternal(
				keyspace, keys, column_parent, predicate, consistency_level);

		for (Map.Entry<ByteBuffer, List<ColumnOrSuperColumn>> cf : columnFamiliesMap
				.entrySet()) {
			counts.put(cf.getKey(), cf.getValue().size());
		}
		return counts;
	}

	private void internal_insert(ByteBuffer key, ColumnParent column_parent,
			Column column, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException {
		state().hasColumnFamilyAccess(column_parent.column_family,
				Permission.WRITE);

		CFMetaData metadata = ThriftValidation.validateColumnFamily(state()
				.getKeyspace(), column_parent.column_family, false);
		ThriftValidation.validateKey(metadata, key);
		ThriftValidation.validateColumnParent(metadata, column_parent);
		// SuperColumn field is usually optional, but not when we're inserting
		if (metadata.cfType == ColumnFamilyType.Super
				&& column_parent.super_column == null) {
			throw new InvalidRequestException(
					"missing mandatory super column name for super CF "
							+ column_parent.column_family);
		}
		ThriftValidation.validateColumnNames(metadata, column_parent, Arrays
				.asList(column.name));
		ThriftValidation.validateColumnData(metadata, column,
				column_parent.super_column != null);
		RowMutation rm = new RowMutation(state().getKeyspace(), key);
		try {
			rm.add(new QueryPath(column_parent.column_family,
					column_parent.super_column, column.name), column.value,
					column.timestamp, column.ttl, column.version);
		} catch (MarshalException e) {
			throw new InvalidRequestException(e.getMessage());
		}
		doInsert(consistency_level, Arrays.asList(rm));
	}

	private void split_insert(ByteBuffer key, ColumnParent column_parent,
			Column column, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException {

		CFMetaData metadata = Schema.instance.getCFMetaData(state()
				.getKeyspace(), column_parent.column_family);
		ByteBuffer oldValue = column.value;
		ByteBuffer columnkey = null;
		columnkey = column.name;
		Map<Integer, ByteBuffer> map = (Map<Integer, ByteBuffer>) AppCase
				.spiltValue(oldValue, ByteBufferUtil.bytes(DatabaseDescriptor.getEachSplitSize()), metadata.deltadata);
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		String newColumnkey = null;
		for (int i : map.keySet()) {
			newColumnkey = LargeValue.getStringName(columnkey, i);
			column.setName(ByteBufferUtil.bytes(newColumnkey));
			column.setValue(map.get(i));
			this.insert(key, column_parent, column, consistency_level);
			map1.put(i, newColumnkey);
		}
		map.clear();
		column.setName(columnkey);
		try {
			column.setValue(ByteBufferUtil.getByteBuffer(new LargeValueWrapper(
					map1)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.insert(key, column_parent, column, consistency_level);
		// LargeValue.addLargeMark(Pair.create(state().getKeyspace(),
		// column_parent.column_family), Pair.create(key, column.name));
	}

	public void insert(ByteBuffer key, ColumnParent column_parent,
			Column column, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException {
		logger.debug("insert");
		if (column.value.capacity() >= DatabaseDescriptor.getLimitSplitSize()) {
			split_insert(key, column_parent, column, consistency_level);
		} else {
			internal_insert(key, column_parent, column, consistency_level);
		}
	}

	private void internal_batch_mutate(
			Map<ByteBuffer, Map<String, List<Mutation>>> mutation_map,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			UnavailableException, TimedOutException {
		List<String> cfamsSeen = new ArrayList<String>();
		List<IMutation> rowMutations = new ArrayList<IMutation>();
		String keyspace = state().getKeyspace();

		for (Map.Entry<ByteBuffer, Map<String, List<Mutation>>> mutationEntry : mutation_map
				.entrySet()) {
			ByteBuffer key = mutationEntry.getKey();

			// We need to separate row mutation for standard cf and counter cf
			// (that will be encapsulated in a
			// CounterMutation) because it doesn't follow the same code path
			RowMutation rmStandard = null;
			RowMutation rmCounter = null;

			Map<String, List<Mutation>> columnFamilyToMutations = mutationEntry
					.getValue();
			for (Map.Entry<String, List<Mutation>> columnFamilyMutations : columnFamilyToMutations
					.entrySet()) {
				String cfName = columnFamilyMutations.getKey();

				// Avoid unneeded authorizations
				if (!(cfamsSeen.contains(cfName))) {
					state().hasColumnFamilyAccess(cfName, Permission.WRITE);
					cfamsSeen.add(cfName);
				}

				CFMetaData metadata = ThriftValidation.validateColumnFamily(
						keyspace, cfName);
				ThriftValidation.validateKey(metadata, key);

				RowMutation rm;
				if (metadata.getDefaultValidator().isCommutative()) {
					ThriftValidation.validateCommutativeForWrite(metadata,
							consistency_level);
					rmCounter = rmCounter == null ? new RowMutation(keyspace,
							key) : rmCounter;
					rm = rmCounter;
				} else {
					rmStandard = rmStandard == null ? new RowMutation(keyspace,
							key) : rmStandard;
					rm = rmStandard;
				}

				for (Mutation mutation : columnFamilyMutations.getValue()) {
					ThriftValidation.validateMutation(metadata, mutation);

					if (mutation.deletion != null) {
						rm.deleteColumnOrSuperColumn(cfName, mutation.deletion);
					}
					if (mutation.column_or_supercolumn != null) {
						rm.addColumnOrSuperColumn(cfName,
								mutation.column_or_supercolumn);
					}
				}
			}
			if (rmStandard != null && !rmStandard.isEmpty())
				rowMutations.add(rmStandard);
			if (rmCounter != null && !rmCounter.isEmpty())
				rowMutations.add(new org.apache.cassandra.db.CounterMutation(
						rmCounter, consistency_level));
		}

		doInsert(consistency_level, rowMutations);
	}

	public void batch_mutate(
			Map<ByteBuffer, Map<String, List<Mutation>>> mutation_map,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			UnavailableException, TimedOutException {
		logger.debug("batch_mutate");

		internal_batch_mutate(mutation_map, consistency_level);
	}

	private void internal_remove(ByteBuffer key, ColumnPath column_path,
			long timestamp, ConsistencyLevel consistency_level,
			boolean isCommutativeOp) throws InvalidRequestException,
			UnavailableException, TimedOutException {
		state().hasColumnFamilyAccess(column_path.column_family,
				Permission.WRITE);

		CFMetaData metadata = ThriftValidation.validateColumnFamily(state()
				.getKeyspace(), column_path.column_family, isCommutativeOp);
		ThriftValidation.validateKey(metadata, key);
		ThriftValidation.validateColumnPathOrParent(metadata, column_path);
		if (isCommutativeOp)
			ThriftValidation.validateCommutativeForWrite(metadata,
					consistency_level);

		RowMutation rm = new RowMutation(state().getKeyspace(), key);
		rm.delete(new QueryPath(column_path), timestamp);

		if (isCommutativeOp)
			doInsert(consistency_level, Arrays.asList(new CounterMutation(rm,
					consistency_level)));
		else
			doInsert(consistency_level, Arrays.asList(rm));
	}

	public void remove(ByteBuffer key, ColumnPath column_path, long timestamp,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			UnavailableException, TimedOutException {
		logger.debug("remove");

		internal_remove(key, column_path, timestamp, consistency_level, false);
	}

	private void doInsert(ConsistencyLevel consistency_level,
			List<? extends IMutation> mutations) throws UnavailableException,
			TimedOutException, InvalidRequestException {
		ThriftValidation.validateConsistencyLevel(state().getKeyspace(),
				consistency_level);
		if (mutations.isEmpty())
			return;
		try {
			schedule(DatabaseDescriptor.getRpcTimeout());
			try {
				StorageProxy.mutate(mutations, consistency_level);
			} finally {
				release();
			}
		} catch (TimeoutException e) {
			throw new TimedOutException();
		}
	}

	public KsDef describe_keyspace(String table) throws NotFoundException,
			InvalidRequestException {
		state().hasKeyspaceSchemaAccess(Permission.READ);

		KSMetaData ksm = Schema.instance.getTableDefinition(table);
		if (ksm == null)
			throw new NotFoundException();

		return ksm.toThrift();
	}

	public List<KeySlice> get_range_slices(ColumnParent column_parent,
			SlicePredicate predicate, KeyRange range,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			UnavailableException, TException, TimedOutException {
		logger.debug("range_slice");

		String keyspace = state().getKeyspace();
		state().hasColumnFamilyAccess(column_parent.column_family,
				Permission.READ);

		CFMetaData metadata = ThriftValidation.validateColumnFamily(keyspace,
				column_parent.column_family);
		ThriftValidation.validateColumnParent(metadata, column_parent);
		ThriftValidation.validatePredicate(metadata, column_parent, predicate);
		ThriftValidation.validateKeyRange(range);
		ThriftValidation.validateConsistencyLevel(keyspace, consistency_level);

		List<Row> rows;
		try {
			IPartitioner p = StorageService.getPartitioner();
			AbstractBounds bounds;
			if (range.start_key == null) {
				Token.TokenFactory tokenFactory = p.getTokenFactory();
				Token left = tokenFactory.fromString(range.start_token);
				Token right = tokenFactory.fromString(range.end_token);
				bounds = new Range(left, right);
			} else {
				bounds = new Bounds(p.getToken(range.start_key), p
						.getToken(range.end_key));
			}
			schedule(DatabaseDescriptor.getRpcTimeout());
			try {
				rows = StorageProxy.getRangeSlice(
						new RangeSliceCommand(keyspace, column_parent,
								predicate, bounds, range.count),
						consistency_level);
			} finally {
				release();
			}
			assert rows != null;
		} catch (TimeoutException e) {
			throw new TimedOutException();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return thriftifyKeySlices(rows, column_parent, predicate);
	}

	private List<KeySlice> thriftifyKeySlices(List<Row> rows,
			ColumnParent column_parent, SlicePredicate predicate) {
		List<KeySlice> keySlices = new ArrayList<KeySlice>(rows.size());
		boolean reversed = predicate.slice_range != null
				&& predicate.slice_range.reversed;
		for (Row row : rows) {
			List<ColumnOrSuperColumn> thriftifiedColumns = thriftifyColumnFamily(
					row.cf, column_parent.super_column != null, reversed);
			keySlices.add(new KeySlice(row.key.key, thriftifiedColumns));
		}

		return keySlices;
	}

	public List<KeySlice> get_indexed_slices(ColumnParent column_parent,
			IndexClause index_clause, SlicePredicate column_predicate,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			UnavailableException, TimedOutException, TException {
		logger.debug("scan");

		state().hasColumnFamilyAccess(column_parent.column_family,
				Permission.READ);
		String keyspace = state().getKeyspace();
		CFMetaData metadata = ThriftValidation.validateColumnFamily(keyspace,
				column_parent.column_family, false);
		ThriftValidation.validateColumnParent(metadata, column_parent);
		ThriftValidation.validatePredicate(metadata, column_parent,
				column_predicate);
		ThriftValidation.validateIndexClauses(metadata, index_clause);
		ThriftValidation.validateConsistencyLevel(keyspace, consistency_level);

		List<Row> rows;
		try {
			rows = StorageProxy.scan(keyspace, column_parent.column_family,
					index_clause, column_predicate, consistency_level);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (TimeoutException e) {
			throw new TimedOutException();
		}
		return thriftifyKeySlices(rows, column_parent, column_predicate);
	}

	public List<KsDef> describe_keyspaces() throws TException,
			InvalidRequestException {
		state().hasKeyspaceSchemaAccess(Permission.READ);

		Set<String> keyspaces = Schema.instance.getTables();
		List<KsDef> ksset = new ArrayList<KsDef>();
		for (String ks : keyspaces) {
			try {
				ksset.add(describe_keyspace(ks));
			} catch (NotFoundException nfe) {
				logger.info("Failed to find metadata for keyspace '" + ks
						+ "'. Continuing... ");
			}
		}
		return ksset;
	}

	public String describe_cluster_name() throws TException {
		return DatabaseDescriptor.getClusterName();
	}

	public String describe_version() throws TException {
		return Constants.VERSION;
	}

	public List<TokenRange> describe_ring(String keyspace)
			throws InvalidRequestException {
		return StorageService.instance.describeRing(keyspace);
	}

	public String describe_partitioner() throws TException {
		return StorageService.getPartitioner().getClass().getName();
	}

	public String describe_snitch() throws TException {
		if (DatabaseDescriptor.getEndpointSnitch() instanceof DynamicEndpointSnitch)
			return ((DynamicEndpointSnitch) DatabaseDescriptor
					.getEndpointSnitch()).subsnitch.getClass().getName();
		return DatabaseDescriptor.getEndpointSnitch().getClass().getName();
	}

	public List<String> describe_splits(String cfName, String start_token,
			String end_token, int keys_per_split) throws TException,
			InvalidRequestException {
		// TODO: add keyspace authorization call post CASSANDRA-1425
		Token.TokenFactory tf = StorageService.getPartitioner()
				.getTokenFactory();
		List<Token> tokens = StorageService.instance.getSplits(state()
				.getKeyspace(), cfName, new Range(tf.fromString(start_token),
				tf.fromString(end_token)), keys_per_split);
		List<String> splits = new ArrayList<String>(tokens.size());
		for (Token token : tokens) {
			splits.add(tf.toString(token));
		}
		return splits;
	}

	public void login(AuthenticationRequest auth_request)
			throws AuthenticationException, AuthorizationException, TException {
		state().login(auth_request.getCredentials());
	}

	/**
	 * Schedule the current thread for access to the required services
	 */
	private void schedule(long timeoutMS) throws TimeoutException {
		requestScheduler.queue(Thread.currentThread(), state()
				.getSchedulingValue(), timeoutMS);
	}

	/**
	 * Release count for the used up resources
	 */
	private void release() {
		requestScheduler.release();
	}

	// helper method to apply migration on the migration stage. typical
	// migration failures will throw an
	// InvalidRequestException. atypical failures will throw a RuntimeException.
	private static void applyMigrationOnStage(final Migration m) {
		Future f = StageManager.getStage(Stage.MIGRATION).submit(
				new Callable() {
					public Object call() throws Exception {
						m.apply();
						m.announce();
						return null;
					}
				});
		try {
			f.get();
		} catch (InterruptedException e) {
			throw new AssertionError(e);
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	private static void applyDeltaFunctionOnStage(final DeltaFunctionStore dfs) {
		Future f = StageManager.getStage(Stage.DELTAFUNCTION).submit(
				new Callable() {
					public Object call() throws Exception {
						dfs.writeDeltaFunction();
						dfs.announce();
						return null;
					}
				});
		try {
			f.get();
		} catch (InterruptedException e) {
			throw new AssertionError(e);
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	public synchronized String system_add_column_family(CfDef cf_def)
			throws InvalidRequestException, SchemaDisagreementException,
			TException {
		logger.debug("add_column_family");
		state().hasColumnFamilySchemaAccess(Permission.WRITE);
		CFMetaData.addDefaultIndexNames(cf_def);
		ThriftValidation.validateCfDef(cf_def, null);
		validateSchemaAgreement();

		try {
			cf_def.unsetId(); // explicitly ignore any id set by client (Hector
			// likes to set zero)
			applyMigrationOnStage(new AddColumnFamily(CFMetaData
					.fromThrift(cf_def)));
			return Schema.instance.getVersion().toString();
		} catch (ConfigurationException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		} catch (IOException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		}
	}

	public synchronized String system_drop_column_family(String column_family)
			throws InvalidRequestException, SchemaDisagreementException,
			TException {
		logger.debug("drop_column_family");
		state().hasColumnFamilySchemaAccess(Permission.WRITE);
		validateSchemaAgreement();

		try {
			applyMigrationOnStage(new DropColumnFamily(state().getKeyspace(),
					column_family));
			return Schema.instance.getVersion().toString();
		} catch (ConfigurationException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		} catch (IOException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		}
	}

	public synchronized String system_add_keyspace(KsDef ks_def)
			throws InvalidRequestException, SchemaDisagreementException,
			TException {
		logger.debug("add_keyspace");
		state().hasKeyspaceSchemaAccess(Permission.WRITE);
		validateSchemaAgreement();
		ThriftValidation.validateKeyspaceNotYetExisting(ks_def.name);

		// generate a meaningful error if the user setup keyspace and/or column
		// definition incorrectly
		for (CfDef cf : ks_def.cf_defs) {
			if (!cf.getKeyspace().equals(ks_def.getName())) {
				throw new InvalidRequestException(
						"CfDef ("
								+ cf.getName()
								+ ") had a keyspace definition that did not match KsDef");
			}
		}

		try {
			Collection<CFMetaData> cfDefs = new ArrayList<CFMetaData>(
					ks_def.cf_defs.size());
			for (CfDef cf_def : ks_def.cf_defs) {
				cf_def.unsetId(); // explicitly ignore any id set by client
				// (same as system_add_column_family)
				CFMetaData.addDefaultIndexNames(cf_def);
				ThriftValidation.validateCfDef(cf_def, null);
				cfDefs.add(CFMetaData.fromThrift(cf_def));
			}

			ThriftValidation.validateKsDef(ks_def);
			applyMigrationOnStage(new AddKeyspace(KSMetaData.fromThrift(ks_def,
					cfDefs.toArray(new CFMetaData[cfDefs.size()]))));
			return Schema.instance.getVersion().toString();
		} catch (ConfigurationException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		} catch (IOException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		}
	}

	public synchronized String system_drop_keyspace(String keyspace)
			throws InvalidRequestException, SchemaDisagreementException,
			TException {
		logger.debug("drop_keyspace");
		state().hasKeyspaceSchemaAccess(Permission.WRITE);
		validateSchemaAgreement();

		try {
			applyMigrationOnStage(new DropKeyspace(keyspace));
			return Schema.instance.getVersion().toString();
		} catch (ConfigurationException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		} catch (IOException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		}
	}

	/**
	 * update an existing keyspace, but do not allow column family
	 * modifications.
	 * 
	 * @throws SchemaDisagreementException
	 */
	public synchronized String system_update_keyspace(KsDef ks_def)
			throws InvalidRequestException, SchemaDisagreementException,
			TException {
		logger.debug("update_keyspace");
		state().hasKeyspaceSchemaAccess(Permission.WRITE);
		ThriftValidation.validateTable(ks_def.name);
		if (ks_def.getCf_defs() != null && ks_def.getCf_defs().size() > 0)
			throw new InvalidRequestException(
					"Keyspace update must not contain any column family definitions.");
		validateSchemaAgreement();

		try {
			ThriftValidation.validateKsDef(ks_def);
			applyMigrationOnStage(new UpdateKeyspace(KSMetaData
					.fromThrift(ks_def)));
			return Schema.instance.getVersion().toString();
		} catch (ConfigurationException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		} catch (IOException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		}
	}

	public synchronized String system_update_column_family(CfDef cf_def)
			throws InvalidRequestException, SchemaDisagreementException,
			TException {
		logger.debug("update_column_family");
		state().hasColumnFamilySchemaAccess(Permission.WRITE);
		if (cf_def.keyspace == null || cf_def.name == null)
			throw new InvalidRequestException(
					"Keyspace and CF name must be set.");
		CFMetaData oldCfm = Schema.instance.getCFMetaData(cf_def.keyspace,
				cf_def.name);
		if (oldCfm == null)
			throw new InvalidRequestException(
					"Could not find column family definition to modify.");
		CFMetaData.addDefaultIndexNames(cf_def);
		ThriftValidation.validateCfDef(cf_def, oldCfm);
		validateSchemaAgreement();

		try {
			// ideally, apply() would happen on the stage with the
			CFMetaData.applyImplicitDefaults(cf_def);
			org.apache.cassandra.db.migration.avro.CfDef result;
			try {
				result = CFMetaData.fromThrift(cf_def).toAvro();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			UpdateColumnFamily update = new UpdateColumnFamily(result);
			applyMigrationOnStage(update);
			return Schema.instance.getVersion().toString();
		} catch (ConfigurationException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		} catch (IOException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		}
	}

	private void validateSchemaAgreement() throws SchemaDisagreementException {
		// unreachable hosts don't count towards disagreement
		Map<String, List<String>> versions = Maps.filterKeys(StorageProxy
				.describeSchemaVersions(), Predicates.not(Predicates
				.equalTo(StorageProxy.UNREACHABLE)));
		if (versions.size() > 1)
			throw new SchemaDisagreementException();
	}

	public void truncate(String cfname) throws InvalidRequestException,
			UnavailableException, TException {
		logger.debug("truncating {} in {}", cfname, state().getKeyspace());
		state().hasColumnFamilyAccess(cfname, Permission.WRITE);
		try {
			schedule(DatabaseDescriptor.getRpcTimeout());
			try {
				StorageProxy.truncateBlocking(state().getKeyspace(), cfname);
			} finally {
				release();
			}
		} catch (TimeoutException e) {
			throw (UnavailableException) new UnavailableException()
					.initCause(e);
		} catch (IOException e) {
			throw (UnavailableException) new UnavailableException()
					.initCause(e);
		}
	}

	public void set_keyspace(String keyspace) throws InvalidRequestException,
			TException {
		ThriftValidation.validateTable(keyspace);

		state().setKeyspace(keyspace);
	}

	public Map<String, List<String>> describe_schema_versions()
			throws TException, InvalidRequestException {
		logger.debug("checking schema agreement");
		return StorageProxy.describeSchemaVersions();
	}

	public Map<String, List<String>> describe_function_versions()
			throws TException, InvalidRequestException {
		logger.debug("checking function agreement");
		return StorageProxy.describeFunctionVersions();
	}

	// counter methods

	public void add(ByteBuffer key, ColumnParent column_parent,
			CounterColumn column, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException, TException {
		logger.debug("add");

		state().hasColumnFamilyAccess(column_parent.column_family,
				Permission.WRITE);
		String keyspace = state().getKeyspace();

		CFMetaData metadata = ThriftValidation.validateColumnFamily(keyspace,
				column_parent.column_family, true);
		ThriftValidation.validateKey(metadata, key);
		ThriftValidation.validateCommutativeForWrite(metadata,
				consistency_level);
		ThriftValidation.validateColumnParent(metadata, column_parent);
		// SuperColumn field is usually optional, but not when we're adding
		if (metadata.cfType == ColumnFamilyType.Super
				&& column_parent.super_column == null) {
			throw new InvalidRequestException(
					"missing mandatory super column name for super CF "
							+ column_parent.column_family);
		}
		ThriftValidation.validateColumnNames(metadata, column_parent, Arrays
				.asList(column.name));

		RowMutation rm = new RowMutation(keyspace, key);
		try {
			rm.addCounter(new QueryPath(column_parent.column_family,
					column_parent.super_column, column.name), column.value);
		} catch (MarshalException e) {
			throw new InvalidRequestException(e.getMessage());
		}
		doInsert(consistency_level, Arrays.asList(new CounterMutation(rm,
				consistency_level)));
	}

	public void remove_counter(ByteBuffer key, ColumnPath path,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			UnavailableException, TimedOutException, TException {
		logger.debug("remove_counter");

		internal_remove(key, path, System.currentTimeMillis(),
				consistency_level, true);
	}

	public CqlResult execute_cql_query(ByteBuffer query, Compression compression)
			throws InvalidRequestException, UnavailableException,
			TimedOutException, SchemaDisagreementException, TException {
		String queryString = null;

		// Decompress the query string.
		try {
			switch (compression) {
			case GZIP:
				FastByteArrayOutputStream byteArray = new FastByteArrayOutputStream();
				byte[] outBuffer = new byte[1024],
				inBuffer = new byte[1024];

				Inflater decompressor = new Inflater();

				int lenRead = 0;
				while (true) {
					if (decompressor.needsInput())
						lenRead = query.remaining() < 1024 ? query.remaining()
								: 1024;
					query.get(inBuffer, 0, lenRead);
					decompressor.setInput(inBuffer, 0, lenRead);

					int lenWrite = 0;
					while ((lenWrite = decompressor.inflate(outBuffer)) != 0)
						byteArray.write(outBuffer, 0, lenWrite);

					if (decompressor.finished())
						break;
				}

				decompressor.end();

				queryString = new String(byteArray.toByteArray(), 0, byteArray
						.size(), "UTF-8");
				break;
			case NONE:
				try {
					queryString = ByteBufferUtil.string(query);
				} catch (CharacterCodingException ex) {
					throw new InvalidRequestException(ex.getMessage());
				}
				break;
			}
		} catch (DataFormatException e) {
			throw new InvalidRequestException("Error deflating query string.");
		} catch (UnsupportedEncodingException e) {
			throw new InvalidRequestException("Unknown query string encoding.");
		}

		try {
			return QueryProcessor.process(queryString, state());
		} catch (RecognitionException e) {
			InvalidRequestException ire = new InvalidRequestException(
					"Invalid or malformed CQL query string");
			ire.initCause(e);
			throw ire;
		}
	}

	// insert a delta column.
	private void internal_insert_delta(ByteBuffer key,
			ColumnParent column_parent, UpdateColumn column,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			UnavailableException, TimedOutException {
		state().hasColumnFamilyAccess(column_parent.column_family,
				Permission.WRITE);

		CFMetaData metadata = ThriftValidation.validateColumnFamily(state()
				.getKeyspace(), column_parent.column_family, false);
		ThriftValidation.validateKey(metadata, key);
		ThriftValidation.validateColumnParent(metadata, column_parent);
		// SuperColumn field is usually optional, but not when we're inserting
		if (metadata.cfType == ColumnFamilyType.Super
				&& column_parent.super_column == null) {
			throw new InvalidRequestException(
					"missing mandatory super column name for super CF "
							+ column_parent.column_family);
		}
		ThriftValidation.validateColumnNames(metadata, column_parent, Arrays
				.asList(column.name));
		ThriftValidation.validateUpdateColumnData(metadata, column,
				column_parent.super_column != null);
		RowMutation rm = new RowMutation(state().getKeyspace(), key);
		try {
			rm.update(new QueryPath(column_parent.column_family,
					column_parent.super_column, column.name), column.value,
					column.timestamp, column.version);
		} catch (MarshalException e) {
			throw new InvalidRequestException(e.getMessage());
		}
		doInsert(consistency_level, Arrays.asList(rm));
	}

	private void split_insert_delta(ByteBuffer key, ColumnParent column_parent,
			UpdateColumn update_column, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException, TException {

		Map<Integer, ByteBuffer> map = AppCase.spiltValue(null,
				update_column.value, null);

		try {
			for (int j : map.keySet()) {
				update_column.setName(ByteBufferUtil.bytes(ByteBufferUtil
						.string(update_column.name)
						+ "-" + j));
				update_column.setValue(map.get(j));
				this.insert_delta(key, column_parent, update_column,
						consistency_level);
			}
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insert_delta(ByteBuffer key, ColumnParent column_parent,
			UpdateColumn update_column, ConsistencyLevel consistency_level)
			throws InvalidRequestException, UnavailableException,
			TimedOutException, TException {
		logger.debug("insert_delta");
		// if (LargeValue.isLarge(Pair.create(state().getKeyspace(),
		// column_parent.column_family), Pair.create(key,
		// update_column.name))) {
		// logger.info("split_insert_delta");
		// split_insert_delta(key, column_parent, update_column,
		// consistency_level);
		// }
		internal_insert_delta(key, column_parent, update_column,
				consistency_level);

	}

	private ColumnOrSuperColumn internal_get_delta(ByteBuffer key,
			ByteBuffer deltakey, ColumnPath column_path,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			NotFoundException, UnavailableException, TimedOutException,
			TException {
		state().hasColumnFamilyAccess(column_path.column_family,
				Permission.READ);
		String keyspace = state().getKeyspace();

		CFMetaData metadata = ThriftValidation.validateColumnFamily(keyspace,
				column_path.column_family);
		ThriftValidation.validateColumnPath(metadata, column_path);
		ThriftValidation.validateConsistencyLevel(keyspace, consistency_level);

		QueryPath path = new QueryPath(column_path.column_family,
				column_path.column == null ? null : column_path.super_column);
		List<ByteBuffer> nameAsList = Arrays
				.asList(column_path.column == null ? column_path.super_column
						: column_path.column);
		ThriftValidation.validateKey(metadata, key);
		ReadCommand command = new SliceByNamesReadCommand(keyspace, key, path,
				nameAsList);

		Map<DecoratedKey, ColumnFamily> cfamilies = readColumnFamily(Arrays
				.asList(command), consistency_level);

		ColumnFamily cf = cfamilies.get(StorageService.getPartitioner()
				.decorateKey(command.key));

		if (cf == null)
			throw new NotFoundException();
		List<ColumnOrSuperColumn> tcolumns = thriftifyColumnFamily(cf,
				command.queryPath.superColumnName != null, false);
		if (tcolumns.isEmpty())
			throw new NotFoundException();
		assert tcolumns.size() == 1;
		try {
			if ("all".equals(ByteBufferUtil.string(deltakey))) {
				return tcolumns.get(0);
			}
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return thriftDeltaColumn(cf.metadata().deltadata, tcolumns.get(0),
				deltakey);
	}

	public ColumnOrSuperColumn thriftDeltaColumn(DeltaData deltadata,
			ColumnOrSuperColumn column, ByteBuffer deltaKey)
			throws InvalidRequestException, NotFoundException,
			UnavailableException, TimedOutException, TException {

		if (column.isSetColumn()) {
			ByteBuffer oldValue = column.getColumn().value;
			ByteBuffer deltaValue = AppCase.deltaValue(oldValue, deltaKey,
					deltadata);
			column.getColumn().setValue(deltaValue);
		}
		return column;
	}

	private ColumnOrSuperColumn split_get_delta(ByteBuffer key,
			ByteBuffer deltakey, ColumnPath column_path,
			ConsistencyLevel consistency_level) throws InvalidRequestException,
			NotFoundException, UnavailableException, TimedOutException,
			TException {
		ByteBuffer name = column_path.column;
		Map<Integer, ByteBuffer> map = AppCase.spiltValue(null, deltakey, null);
		try {
			for (int i : map.keySet()) {
				column_path.setColumn(ByteBufferUtil.bytes(ByteBufferUtil
						.string(column_path.column)
						+ "_" + i));
				ColumnOrSuperColumn columnOrSuperColumn = this
						.internal_get_delta(key, (ByteBuffer) map.get(i),
								column_path, consistency_level);
				columnOrSuperColumn.getColumn().setName(name);
				return columnOrSuperColumn;
			}
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ColumnOrSuperColumn get_delta(ByteBuffer key, ByteBuffer deltaKey,
			ColumnPath columnPath, ConsistencyLevel consistencyLevel)
			throws InvalidRequestException, NotFoundException,
			UnavailableException, TimedOutException, TException {
		logger.info("get_delta");
		if (LargeValue.isLarge(Pair.create(state().getKeyspace(),
				columnPath.column_family), Pair.create(key, columnPath.column))) {
			logger.info("split_get_delta");
			return split_get_delta(key, deltaKey, columnPath, consistencyLevel);
		}
		return internal_get_delta(key, deltaKey, columnPath, consistencyLevel);
	}

	@Override
	public List<FtDef> describe_functions() throws InvalidRequestException,
			TException {
		logger.debug("describe_functions");
		state().hasKeyspaceSchemaAccess(Permission.READ);

		Set<String> functions = DeltaFunction.instance.getFucntions();
		List<FtDef> ftset = new ArrayList<FtDef>();
		for (String ft : functions) {
			try {
				ftset.add(describe_function(ft));
			} catch (NotFoundException nfe) {
				logger.info("Failed to find metadata for function '" + ft
						+ "'. Continuing... ");
			}
		}
		return ftset;
	}

	public FtDef describe_function(String function) throws NotFoundException,
			InvalidRequestException {
		state().hasKeyspaceSchemaAccess(Permission.READ);

		FTMetaData ftm = DeltaFunction.instance.getFTMetaData(function);
		if (ftm == null)
			throw new NotFoundException();

		return ftm.toThrift();
	}

	@Override
	public synchronized String system_add_function(FtDef ft_Def)
			throws InvalidRequestException, SchemaDisagreementException,
			TException {
		logger.debug("add_function");
		state().hasKeyspaceSchemaAccess(Permission.WRITE);
		// validateSchemaAgreement();
		ThriftValidation.validateFunctionNotYetExisting(ft_Def.name);

		try {

			applyDeltaFunctionOnStage(new DeltaFunctionStore(FTMetaData
					.fromThrift(ft_Def), FunctionType.ADD, null));

		} catch (ConfigurationException e) {
			InvalidRequestException ex = new InvalidRequestException(e
					.getMessage());
			ex.initCause(e);
			throw ex;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DeltaFunction.instance.getVersion().toString();
	}

	@Override
	public ColumnOrSuperColumn delta_chunk(int id, ByteBuffer key,
			ByteBuffer deltaKey, ColumnPath columnPath,
			ConsistencyLevel consistencyLevel) throws InvalidRequestException,
			NotFoundException, UnavailableException, TimedOutException,
			TException {
		logger.debug("delta_chunk");
		ColumnOrSuperColumn cosc;
		ByteBuffer columnkey = columnPath.column;
		LargeValueWrapper lvw = isExistLargeValue(key, columnkey,
				columnPath.column_family);

		if (lvw != null) {
			String chunkcolumnkey = lvw.getChunkName(id);
			if (chunkcolumnkey != null) {
				columnPath.setColumn(ByteBufferUtil.bytes(chunkcolumnkey));
				cosc = this.get_delta(key, deltaKey, columnPath,
						consistencyLevel);
				cosc.getColumn().setName(columnkey);
				return cosc;
			} else {
				throw new InvalidRequestException("The chunk does not exist.");
			}

		} else {
			throw new InvalidRequestException(
					"The column storage is not big value");
		}
	}

	@Override
	public ColumnOrSuperColumn read_chunk(int id, ByteBuffer key,
			ColumnPath columnPath, ConsistencyLevel consistencyLevel)
			throws InvalidRequestException, NotFoundException,
			UnavailableException, TimedOutException, TException {
		logger.debug("read_chunk");
		ColumnOrSuperColumn cosc;
		ByteBuffer columnkey = columnPath.column;
		LargeValueWrapper lvw = isExistLargeValue(key, columnkey,
				columnPath.column_family);
		if (lvw != null) {
			String chunkcolumnkey = lvw.getChunkName(id);
			if (chunkcolumnkey != null) {
				columnPath.setColumn(ByteBufferUtil.bytes(chunkcolumnkey));
				cosc = this.get(key, columnPath, consistencyLevel);
				cosc.getColumn().setName(columnkey);
				return cosc;
			} else {
				throw new InvalidRequestException("The chunk does not exist.");
			}

		} else {
			throw new InvalidRequestException(
					"The column storage is not big value");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void rename_chunk(int oldId, int newId, ByteBuffer key,
			ColumnPath columnPath, ConsistencyLevel consistencyLevel)
			throws InvalidRequestException, NotFoundException,
			UnavailableException, TimedOutException, TException {
		logger.debug("rename_chunk");
		ColumnOrSuperColumn cosc;
		Column column = new Column();
		ByteBuffer columnkey = columnPath.column;
		LargeValueWrapper lvw = isExistLargeValue(key, columnkey,
				columnPath.column_family);
		if (lvw != null) {
			String chunkcolumnkey = lvw.getChunkName(oldId);
			if (chunkcolumnkey != null) {
				ColumnParent cp = new ColumnParent(columnPath.column_family);
				String newchunkcolumnkey = LargeValue.getStringName(
						columnPath.column, newId);
				// get old chunk
				columnPath.setColumn(ByteBufferUtil.bytes(chunkcolumnkey));
				cosc = this.get(key, columnPath, consistencyLevel);
				// put new chunk
				cosc.getColumn().setName(
						ByteBufferUtil.bytes(newchunkcolumnkey));
				cosc.getColumn().setTimestamp(System.currentTimeMillis());
				this.insert(key, cp, cosc.getColumn(), consistencyLevel);
				// remove old chunk
				columnPath.setColumn(ByteBufferUtil.bytes(chunkcolumnkey));
				this.remove(key, columnPath, System.currentTimeMillis(),
						consistencyLevel);
				// update map
				lvw.removeChunk(oldId);
				lvw.putChunkName(newId, newchunkcolumnkey);
				column.setName(columnkey);
				column.setValue(lvw.toByteBuffer());
				column.setTimestamp(System.currentTimeMillis());
				this.insert(key, cp, column, consistencyLevel);

			} else {
				throw new InvalidRequestException("ID is '" + oldId
						+ "' block does not exist");
			}
		} else {
			throw new InvalidRequestException(
					"The column storage is not big value");
		}

	}

	@Override
	public void write_chunk(int id, ByteBuffer key, ColumnParent columnParent,
			Column column, ConsistencyLevel consistencyLevel)
			throws InvalidRequestException, UnavailableException,
			TimedOutException, TException {
		logger.debug("write_chunk");
		ByteBuffer columnkey = column.name;
		Column newColumn = new Column();
		LargeValueWrapper lvw = isExistLargeValue(key, columnkey,
				columnParent.column_family);
		if (lvw != null) {
			String newColumnkey = lvw.getChunkName(id);
			long now = System.currentTimeMillis();
			if (newColumnkey == null) {
				newColumnkey = LargeValue.getStringName(column.name, id);
				lvw.putChunkName(id, newColumnkey);
				newColumn.setName(columnkey);
				newColumn.setValue(lvw.toByteBuffer());
				newColumn.setTimestamp(now);
				this.insert(key, columnParent, newColumn, consistencyLevel);
			}
			column.setName(ByteBufferUtil.bytes(newColumnkey));
			column.setTimestamp(now);
			this.insert(key, columnParent, column, consistencyLevel);
		} else {
			throw new InvalidRequestException(
					"The column storage is not big value");
		}

	}

	@Override
	public void write_chunk_delta(int id, ByteBuffer key,
			ColumnParent columnParent, UpdateColumn updatecolumn,
			ConsistencyLevel consistencyLevel) throws InvalidRequestException,
			UnavailableException, TimedOutException, TException {
		logger.debug("write_chunk_delta");
		ByteBuffer columnkey = updatecolumn.name;
		LargeValueWrapper lvw = isExistLargeValue(key, columnkey,
				columnParent.column_family);
		if (lvw != null) {
			String newColumnkey = lvw.getChunkName(id);
			if (newColumnkey != null) {
				updatecolumn.setName(ByteBufferUtil.bytes(newColumnkey));
				this.insert_delta(key, columnParent, updatecolumn,
						consistencyLevel);
			} else {
				throw new InvalidRequestException("The chunk does not exist.");
			}
		} else {
			throw new InvalidRequestException(
					"The column storage is not big value");
		}

	}

	public LargeValueWrapper isExistLargeValue(ByteBuffer key,
			ByteBuffer column, String cf) throws InvalidRequestException,
			UnavailableException, TimedOutException {
		logger.debug("Check large value");
		Object obj = null;
		ColumnOrSuperColumn cosc = null;
		ColumnPath cp = new ColumnPath(cf);
		cp.setColumn(column);
		if (LargeValue.isLarge(Pair.create(state().getKeyspace(), cf), Pair
				.create(key, column))) {
			try {
				cosc = this.get(key, cp, ConsistencyLevel.ONE);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return LargeValueWrapper.create(cosc.getColumn().value);

		} else {
			try {
				cosc = this.get(key, cp, ConsistencyLevel.ONE);
				ByteBuffer bf = cosc.getColumn().value;
				obj = ByteBufferUtil.getObject(bf);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return null;
			}
			if (obj instanceof LargeValueWrapper) {
				LargeValue.addLargeMark(Pair.create(state().getKeyspace(), cf),
						Pair.create(key, column));
				return (LargeValueWrapper) obj;
			}
		}
		return null;

	}

	// main method moved to CassandraDaemon
}
