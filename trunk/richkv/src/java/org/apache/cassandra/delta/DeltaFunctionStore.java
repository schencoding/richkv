package org.apache.cassandra.delta;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.cassandra.config.ConfigurationException;
import org.apache.cassandra.config.FTMetaData;
import org.apache.cassandra.config.KSMetaData;
import org.apache.cassandra.config.Schema;
import org.apache.cassandra.db.Column;
import org.apache.cassandra.db.ColumnFamily;
import org.apache.cassandra.db.ColumnFamilyStore;
import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.db.DefsTable;
import org.apache.cassandra.db.IColumn;
import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.db.Table;
import org.apache.cassandra.db.filter.QueryFilter;
import org.apache.cassandra.db.filter.QueryPath;
import org.apache.cassandra.db.migration.Migration;
import org.apache.cassandra.io.SerDeUtils;
import org.apache.cassandra.io.util.DataOutputBuffer;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.MigrationManager;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.thrift.FtDef;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.cassandra.utils.UUIDGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeltaFunctionStore {
	private static final Logger logger = LoggerFactory
			.getLogger(DeltaFunctionStore.class);

	public static final String FUNCTION_CF = "FunctionInfo";
	public static final ByteBuffer DELTA_FUNCTION_ALL_KEY = ByteBufferUtil
			.bytes("functionAll");
	// public static final ByteBuffer DELTA_FUNCTION_DESCRIPTION_KEY =
	// ByteBufferUtil
	// .bytes("Description");
	public static final ByteBuffer DELTA_FUNCTION_VERSION_KEY = ByteBufferUtil
			.bytes("LastVersion");

	private final DeltaFunction deltaFunction = DeltaFunction.instance;

	private IColumn column;
	private RowMutation rm;
	private UUID lastVersion;
	private FTMetaData ftm;
	private short flag;

	public enum FunctionType {
		ADD, REMOVE
	}

	public DeltaFunctionStore(FTMetaData ftm, FunctionType functionType,
			UUID lastVersion) throws ConfigurationException, IOException {
		if (lastVersion != null) {
			this.lastVersion = lastVersion;
		} else {
			this.lastVersion = UUIDGen.makeType1UUIDFromHost(FBUtilities
					.getBroadcastAddress());
		}
		this.ftm = ftm;
		this.flag = (short) functionType.ordinal();
		init();
	}

	private void init() throws ConfigurationException, IOException {

		if (flag == FunctionType.ADD.ordinal()) {
			if (deltaFunction.getFTMetaData(ftm.name) != null)
				throw new ConfigurationException(
						"Delta Function already exists.");
			rm = makeDefinitionDelFunction(ftm, null);
		} else {

			if (deltaFunction.getFTMetaData(ftm.name) == null)
				throw new ConfigurationException(
						"Delta Function does not exist.");
			rm = makeDefinitionDelFunction(null, ftm);
		}
	}

	private RowMutation makeDefinitionDelFunction(FTMetaData add,
			FTMetaData remove) throws IOException {

		// collect all functions, while removing 'remove' and adding 'add'
		List<FTMetaData> ftms = new ArrayList<FTMetaData>();
		for (String function : deltaFunction.getFucntions()) {
			if (remove != null && remove.name.equals(function) || add != null
					&& add.name.equals(function))
				continue;
			ftms.add(deltaFunction.getFTMetaData(function));
		}
		if (add != null)
			ftms.add(add);

		// wrap in mutation
		RowMutation rm = new RowMutation(Table.SYSTEM_TABLE,
				toUTF8Bytes(lastVersion));
		long now = System.currentTimeMillis();
		// add a column for each function
		for (FTMetaData ftm : ftms)
			rm.add(new QueryPath(FUNCTION_CF, null, ByteBufferUtil
					.bytes(ftm.name)), ftm.toByteBuffer(), now);
		return rm;

	}

	/**
	 * Write a delta function to the system table.
	 * 
	 * @throws IOException
	 * @throws ConfigurationException
	 * 
	 */
	public void writeDeltaFunction() throws IOException, ConfigurationException {

		// write to functionInfo
		assert rm != null;
		if (!StorageService.instance.isClientMode()) {
			rm.apply();
			long now = System.currentTimeMillis();
			ByteBuffer buf = serialize();
			RowMutation migration = new RowMutation(Table.SYSTEM_TABLE,
					DELTA_FUNCTION_ALL_KEY);
			ColumnFamily cf = ColumnFamily.create(Table.SYSTEM_TABLE,
					FUNCTION_CF);
			column = new Column(
					ByteBuffer.wrap(UUIDGen.decompose(lastVersion)), buf, now);
			cf.addColumn(column);
			migration.add(cf);
			migration.apply();

			logger.info("Applying new delta_function {} {}", lastVersion
					.toString(), toString());
			migration = new RowMutation(Table.SYSTEM_TABLE,
					DELTA_FUNCTION_VERSION_KEY);
			migration.add(new QueryPath(FUNCTION_CF, null,
					DELTA_FUNCTION_VERSION_KEY), ByteBuffer.wrap(UUIDGen
					.decompose(lastVersion)), now);
			migration.apply();

			ColumnFamilyStore cfs = Table.open(Table.SYSTEM_TABLE)
					.getColumnFamilyStore(FUNCTION_CF);
			Future<?> f = cfs.forceFlush();
			if (f == null)
				return;
			try {
				f.get();
			} catch (ExecutionException e) {
				throw new IOException(e);
			} catch (InterruptedException e) {
				throw new IOException(e);
			}
		}
		if (flag == FunctionType.ADD.ordinal()) {
			deltaFunction.setFunctionDefinition(ftm);
		} else {
			deltaFunction.purge(ftm);
		}
		deltaFunction.setVersion(lastVersion);

	}

	/**
	 * send this function immediately to existing nodes in the cluster. apply()
	 * must be called first.
	 */
	public final void announce() {
		assert !StorageService.instance.isClientMode();
		assert column != null;
		DeltaFunctionManager.announce(column);
		passiveAnnounce(); // keeps gossip in sync w/ what we just told everyone
	}

	public final void passiveAnnounce() {
		DeltaFunctionManager.passiveAnnounce(lastVersion);
	}

	public static UUID getLastVersionId() {
		DecoratedKey<?> dkey = StorageService.getPartitioner().decorateKey(
				DELTA_FUNCTION_VERSION_KEY);
		Table defs = Table.open(Table.SYSTEM_TABLE);
		ColumnFamilyStore cfStore = defs.getColumnFamilyStore(FUNCTION_CF);
		QueryFilter filter = QueryFilter.getNamesFilter(dkey, new QueryPath(
				FUNCTION_CF), DELTA_FUNCTION_VERSION_KEY);
		ColumnFamily cf = cfStore.getColumnFamily(filter);
		if (cf == null || cf.getColumnNames().size() == 0)
			return null;
		else
			return UUIDGen.getUUID(cf.getColumn(DELTA_FUNCTION_VERSION_KEY)
					.value());
	}

	public ByteBuffer serialize() throws IOException {
		FunctionBean fb = new FunctionBean();
		fb.setName(ftm.name);
		fb.setPath(ftm.strategyClass);
		fb.setDetail(ftm.description);
		fb.setFlag(flag);
		return ByteBufferUtil.getByteBuffer(fb);
	}

	public static DeltaFunctionStore deserialize(ByteBuffer bytes, UUID version)
			throws IOException {
		// deserialize
		FunctionBean fb = null;
		DeltaFunctionStore dfs = null;

		try {
			fb = (FunctionBean) ByteBufferUtil.getObject(bytes);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FtDef ftd = new FtDef(fb.getName(), fb.getPath());
		ftd.setDescription(fb.getDetail());
		try {
			dfs = new DeltaFunctionStore(FTMetaData.fromThrift(ftd),
					FunctionType.values()[fb.getFlag()], version);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dfs;

	}

	/** load serialized functions. */
	public static Collection<IColumn> getLocalFunctions(UUID start, UUID end) {
		DecoratedKey<?> dkey = StorageService.getPartitioner().decorateKey(
				DELTA_FUNCTION_ALL_KEY);
		Table defs = Table.open(Table.SYSTEM_TABLE);
		ColumnFamilyStore cfStore = defs.getColumnFamilyStore(FUNCTION_CF);
		QueryFilter filter = QueryFilter.getSliceFilter(dkey, new QueryPath(
				FUNCTION_CF), ByteBuffer.wrap(UUIDGen.decompose(start)),
				ByteBuffer.wrap(UUIDGen.decompose(end)), false, 100);
		ColumnFamily cf = cfStore.getColumnFamily(filter);
		return cf.getSortedColumns();
	}

	public static ByteBuffer toUTF8Bytes(UUID version) {
		return ByteBufferUtil.bytes(version.toString());
	}

}
