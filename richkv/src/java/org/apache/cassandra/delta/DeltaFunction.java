package org.apache.cassandra.delta;

import java.io.IOError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.config.FTMetaData;
import org.apache.cassandra.config.KSMetaData;
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
import org.apache.cassandra.io.SerDeUtils;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.cassandra.utils.NodeId;
import org.apache.cassandra.utils.Pair;
import org.apache.cassandra.utils.UUIDGen;
import org.cliffc.high_scale_lib.NonBlockingHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeltaFunction {
	private static final Logger logger = LoggerFactory
			.getLogger(DeltaFunction.class);
	public static final UUID INITIAL_VERSION = new UUID(4096, 0); // has type

	public static final DeltaFunction instance = new DeltaFunction(
			INITIAL_VERSION);

	/* metadata map for faster table lookup */
	private final Map<String, FTMetaData> functions = new NonBlockingHashMap<String, FTMetaData>();
	private volatile UUID version;

	protected RowMutation rm;

	private IColumn column;

	public DeltaFunction(UUID initialVersion) {
		version = initialVersion;
	}

	public FTMetaData getFTMetaData(String function) {
		assert function != null;
		return functions.get(function);
	}

	public Set<String> getFucntions() {
		return functions.keySet();
	}

	public Collection<FTMetaData> getFunctionDefinitions() {
		return functions.values();
	}

	public void setFunctionDefinition(FTMetaData ftm) {
		if (ftm != null)
			functions.put(ftm.name, ftm);
	}

	public void purge(FTMetaData ftm) {
		functions.remove(ftm.name);
	}

	public DeltaFunction load(Collection<FTMetaData> tableDefs, UUID version) {

		for (FTMetaData def : tableDefs) {

			setFunctionDefinition(def);
		}

		setVersion(version);

		return this;
	}

	// /**
	// * Read the current delta function from the system table or null if no
	// such
	// * delta function is recorded.
	// */
	// public static NodeId getDeltaFunction() {
	// ByteBuffer id = null;
	// Table table = Table.open(Table.SYSTEM_TABLE);
	// QueryFilter filter = QueryFilter.getIdentityFilter(
	// decorate(DELTA_FUNCTION_PATH_KEY), new QueryPath(FUNCTION_CF));
	// ColumnFamily cf = table.getColumnFamilyStore(FUNCTION_CF)
	// .getColumnFamily(filter);
	//
	// if (cf != null) {
	// cf = ColumnFamilyStore.removeDeleted(cf, 0);
	// assert cf.getColumnCount() <= 1;
	// if (cf.getColumnCount() > 0)
	// id = cf.iterator().next().name();
	// }
	// if (id != null) {
	// return NodeId.wrap(id);
	// } else {
	// return null;
	// }
	// }

	// private static DecoratedKey decorate(ByteBuffer key) {
	// return StorageService.getPartitioner().decorateKey(key);
	// }

	public UUID getVersion() {
		return version;
	}

	public void setVersion(UUID version) {
		this.version = version;
	}

}
