package conn;

import java.util.ArrayList;
import java.util.List;

import org.apache.cassandra.locator.NetworkTopologyStrategy;
import org.apache.cassandra.thrift.AuthenticationException;
import org.apache.cassandra.thrift.AuthorizationException;
import org.apache.cassandra.thrift.Cassandra;
import org.apache.cassandra.thrift.CfDef;
import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.cassandra.thrift.KsDef;
import org.apache.cassandra.thrift.SchemaDisagreementException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class Connector {

	private static Cassandra.Client client;
	private static TTransport tr;
	public static String  str;

	public Connector(String str){
		this.str = str;
	}
	public static Cassandra.Client getConn() throws AuthenticationException,
			AuthorizationException, TException, InvalidRequestException {
		if (tr != null) {
			return client;
		}
		TSocket socket = new TSocket("localhost", 9160);
		tr = new TFramedTransport(socket);
		TBinaryProtocol binaryProtocol = new TBinaryProtocol(tr, true, true);
		client = new Cassandra.Client(binaryProtocol);
		try {
			tr.open();
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	public static void createKeyspace(String keyspace, String columnFamily)
			throws InvalidRequestException, SchemaDisagreementException,
			TException {

		CfDef cf_def = new CfDef().setKeyspace(keyspace).setName(columnFamily);
		// .setDefault_validation_class("UTF8Type");

		List<CfDef> cf_defs = new ArrayList<CfDef>();
		cf_defs.add(cf_def);
		KsDef ks_def = new KsDef().setName(keyspace).setStrategy_class(
				NetworkTopologyStrategy.class.getSimpleName()).setCf_defs(
				cf_defs);

		client.system_add_keyspace(ks_def);
	}


	public static void dropKeyspace(String keyspace)
			throws InvalidRequestException, SchemaDisagreementException,
			TException {
		client.system_drop_keyspace(keyspace);
	}

	public static void useKeyspace(String keyspace)
			throws InvalidRequestException, TException {
		client.set_keyspace(keyspace);
	}

	public static void createColumnFamily(String keyspace, String columnFamily)
			throws InvalidRequestException, TException,
			SchemaDisagreementException {
		CfDef cf_def = new CfDef().setKeyspace(keyspace).setName(columnFamily).setDelta_function_name("DeltaMap").setCompaction_strategy("LeveledCompactionStrategy");

		client.system_add_column_family(cf_def);
	}

	public static void dropColumnFamily(String columnfamily)
			throws InvalidRequestException, SchemaDisagreementException,
			TException {
		client.system_drop_column_family(columnfamily);
	}

	public static void close() {
		try {
			if (tr != null) {
				tr.flush();
				tr.close();
			}
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
