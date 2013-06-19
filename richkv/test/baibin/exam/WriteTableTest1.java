package exam;

import java.awt.Stroke;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.dht.CollatingOrderPreservingPartitioner;
import org.apache.cassandra.dht.LocalPartitioner;
import org.apache.cassandra.dht.OrderPreservingPartitioner;
import org.apache.cassandra.dht.RandomPartitioner;
import org.apache.cassandra.locator.NetworkTopologyStrategy;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.thrift.AuthenticationException;
import org.apache.cassandra.thrift.AuthorizationException;
import org.apache.cassandra.thrift.Cassandra;
import org.apache.cassandra.thrift.CfDef;
import org.apache.cassandra.thrift.Column;
import org.apache.cassandra.thrift.ColumnOrSuperColumn;
import org.apache.cassandra.thrift.ColumnParent;
import org.apache.cassandra.thrift.ColumnPath;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.thrift.CounterColumn;
import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.cassandra.thrift.KsDef;
import org.apache.cassandra.thrift.NotFoundException;
import org.apache.cassandra.thrift.SchemaDisagreementException;
import org.apache.cassandra.thrift.SlicePredicate;
import org.apache.cassandra.thrift.SliceRange;
import org.apache.cassandra.thrift.TokenRange;
import org.apache.cassandra.thrift.UpdateColumn;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class WriteTableTest1 {

	private Cassandra.Client client;
	private TTransport tr;
	private String keyspace = "demo";
	private String columnFamily = "test";
	private String columnFamily1 = "test1";

	public WriteTableTest1() throws AuthenticationException,
			AuthorizationException, TException, InvalidRequestException,
			SchemaDisagreementException {
		TSocket socket = new TSocket("localhost", 9160);
		tr = new TFramedTransport(socket);
		TBinaryProtocol binaryProtocol = new TBinaryProtocol(tr, true, true);
		client = new Cassandra.Client(binaryProtocol);
		try {
			tr.open();
			// client.system_drop_keyspace(this.keyspace);
			CfDef cf_def = new CfDef().setKeyspace(this.keyspace).setName(
					this.columnFamily).setDefault_validation_class("UTF8Type");
			List<CfDef> cf_defs = new ArrayList<CfDef>();
			cf_defs.add(cf_def);

			KsDef ks_def = new KsDef().setName(this.keyspace)
					.setStrategy_class(
							NetworkTopologyStrategy.class.getSimpleName())
					.setCf_defs(cf_defs);

			// client.system_add_keyspace(ks_def);

			client.set_keyspace(this.keyspace);
			// client.system_add_column_family(cf_def);

		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertData() throws InvalidRequestException, TException,
			UnsupportedEncodingException, NotFoundException,
			SchemaDisagreementException {
		// insert data

		System.out.println(client.describe_keyspace(keyspace));
		System.out.println("------------insert-----------");
		CfDef cf_def = new CfDef().setKeyspace(this.keyspace).setName(
				this.columnFamily).setDefault_validation_class("UTF8Type");
		List<CfDef> cf_defs = new ArrayList<CfDef>();
		cf_defs.add(cf_def);

		KsDef ks_def = new KsDef().setName(this.keyspace).setStrategy_class(
				NetworkTopologyStrategy.class.getSimpleName()).setCf_defs(
				cf_defs);

		//
		// client.system_add_keyspace(ks_def);
		// client.system_add_column_family(cf_def);

		ColumnParent parent = new ColumnParent(this.columnFamily);
		ColumnPath cp = new ColumnPath(this.columnFamily);
		ByteBuffer row = null;
		ByteBuffer columnkey = null;
		Column column = null;
		try {
			for (int i = 1; i <= 1; i++) {
				row = ByteBufferUtil.bytes(("key-" + (i)));
				columnkey = ByteBufferUtil.bytes("dd," + i);
				column = new Column();
				column.setName(columnkey);
				column.setValue(ByteBufferUtil.bytes("abcdefg"));
				column.setTimestamp(new Date().getTime());
				// column.setTtl(2000);
				// column.setVersion(1336377186220L+3);
				// column.setTtl(0);

				client.insert(row, parent, column, ConsistencyLevel.ONE);

			}

			CounterColumn countercolumn = new CounterColumn();
			countercolumn.setName(columnkey);
			countercolumn.setValue(10L);
			// client.add(row, parent, countercolumn, ConsistencyLevel.ONE);
			// client.remove_counter(row,cp,ConsistencyLevel.ONE);

			// for (int i = 60000; i <= 70000; i++) {
			// row = ByteBufferUtil.bytes(("aaaaa" + (i)));
			// column = new Column();
			// column.setName(ByteBufferUtil.bytes("bbbbb"+i));
			// column.setValue(ByteBufferUtil.bytes("ddddd"+i));
			// column.setTimestamp(new Date().getTime());
			// client.insert(row, parent1, column, ConsistencyLevel.ONE);
			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void queryData() throws InvalidRequestException, TException,
			UnsupportedEncodingException, NotFoundException {

		// query data
		System.out.println("------------query-----------");
		ColumnPath columnpath = new ColumnPath(this.columnFamily);
		ColumnParent parent = new ColumnParent(this.columnFamily);
		SlicePredicate slicepredicate = new SlicePredicate();
		ByteBuffer columnkey = null;
		ByteBuffer row = null;
		ByteBuffer deltakey = null;
		try {
			for (int i = 1; i <= 1; i++) {

				row = ByteBufferUtil.bytes(("key-" + (i)));
				columnkey = ByteBufferUtil.bytes("dd," + i);
				deltakey = ByteBufferUtil.bytes("8");
				columnpath.setColumn(columnkey);
				 ColumnOrSuperColumn columnOrSuper = client.get(row,
				 columnpath,
				 ConsistencyLevel.ONE);

				// ColumnOrSuperColumn columnOrSuper = client.get_delta(row,
				// deltakey, columnpath,
				// ConsistencyLevel.ONE);
				// ByteBuffer emptyByteBuffer = ByteBuffer
				// .wrap("0".getBytes("UTF-8"));
//				ByteBuffer emptyByteBuffer = ByteBuffer.wrap(new byte[0]);
//				SlicePredicate predicate = new SlicePredicate()
//						.setSlice_range(new SliceRange(emptyByteBuffer,
//								emptyByteBuffer, false, 0));
//				List<ColumnOrSuperColumn> results = client.get_slice(row,
//						parent, predicate, ConsistencyLevel.ONE);
				// System.out.println("columnValue: "
				// + columnOrSuper.getCounter_column().value);
//				ColumnOrSuperColumn columnOrSuper = null;
//				if (results.size() > 0) {
//					columnOrSuper = results.get(0);
//				}
				if (columnOrSuper.getColumn() != null) {
					System.out.println("rowKey     :" + (" key-" + (i)));
					System.out.println("columnName : "
							+ ByteBufferUtil
									.string(columnOrSuper.getColumn().name));
					System.out.println("columnValue: "
							+ ByteBufferUtil
									.string(columnOrSuper.getColumn().value));
					System.out.println("timeStamp  : "
							+ columnOrSuper.getColumn().getTimestamp());
					System.out.println("TTL        : "
							+ columnOrSuper.getColumn().getTtl());
					System.out.println("version    : "
							+ columnOrSuper.getColumn().getVersion());
				}

				// List columnkey_list = new ArrayList();
				// columnkey_list.add(columnkey);
				// slicepredicate.setColumn_names(columnkey_list);
				// int count = client.get_count(row, parent, slicepredicate,
				// ConsistencyLevel.ONE);
				// System.out.println(count);

				List<TokenRange> trlist = client.describe_ring(this.keyspace);
				for (TokenRange tr : trlist) {
					System.out.println(tr.start_token);
					System.out.println(tr.end_token);
					// System.out.println(tr.rpc_endpoints.get(0));
					// System.out.println(tr.endpoint_details.get(0).host);
					// System.out.println(tr.endpoint_details.get(0).datacenter);
					// System.out.println(tr.endpoint_details.get(0).rack);

				}
				System.out.println(Math.pow(2, 127));
				System.out.println(ByteBufferUtil.bytesToHex(row));
				RandomPartitioner rp = new RandomPartitioner();
				String token = rp.getToken(row).toString();
				System.out.println(token);
				OrderPreservingPartitioner opp = new OrderPreservingPartitioner();
				token = opp.getToken(row).toString();
				System.out.println(token);
				CollatingOrderPreservingPartitioner copp = new CollatingOrderPreservingPartitioner();
				token = copp.getToken(row).toString();
				System.out.println(token);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteData1() throws InvalidRequestException, TException,
			UnsupportedEncodingException, NotFoundException {

		// delete data
		System.out.println("------------remove-----------");
		ColumnPath columnpath = new ColumnPath(this.columnFamily);
		ByteBuffer row = null;
		try {
			for (int i = 1; i <= 2; i++) {
				row = ByteBufferUtil.bytes(("key" + (i)));

				columnpath.setColumn(ByteBufferUtil.bytes("ddd" + i));
				client.remove(row, columnpath, System.currentTimeMillis(),
						ConsistencyLevel.ONE);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateData() throws InvalidRequestException, TException,
			UnsupportedEncodingException, NotFoundException {
		// update data

		System.out.println("------------update-----------");

		ColumnParent parent = new ColumnParent(this.columnFamily);
		ByteBuffer row = null;
		UpdateColumn column = null;
		try {
			for (int i = 1; i <= 1; i++) {
				row = ByteBufferUtil.bytes(("key" + (i)));
				column = new UpdateColumn();
				column.setName(ByteBufferUtil.bytes("dd" + i));
				column.setValue(ByteBufferUtil.bytes(" e "));
				column.setTimestamp(new Date().getTime());
				column.setVersion(1343116518406L+13);

				// column.setVersion(new Date().getTime());
				// column.setTtl(10);
				client.insert_delta(row, parent, column, ConsistencyLevel.ONE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void shutDown() {
		try {
			tr.flush();
			tr.close();
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public void test(){
	// String string = "<Topic>\n<a>sdsdsds\n</a>\n</Topic>";
	// Pattern p = Pattern.compile("<Topic>(\n|.)*</Topic>");
	// Matcher m = p.matcher(string);
	// boolean b = false;
	// while(b = m.find()){
	// System.out.print(m.group());
	// }
	//
	//		
	//		
	// }
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		WriteTableTest1 wt = new WriteTableTest1();
		 wt.insertData();
		 wt.deleteData1();
//		 wt.updateData();
		 wt.queryData();
		// wt.test();
		// StorageService ss = StorageService.instance;
		// ss.getNaturalEndpoints(wt.keyspace, ByteBufferUtil.bytes(("key1")));
		wt.shutDown();
	}

}
