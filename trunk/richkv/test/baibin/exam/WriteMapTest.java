package exam;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cassandra.locator.NetworkTopologyStrategy;
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
import org.apache.cassandra.thrift.SlicePredicate;
import org.apache.cassandra.thrift.UpdateColumn;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class WriteMapTest {

	private Cassandra.Client client;
	private TTransport tr;
	private String keyspace = "demo";
	private String columnFamily = "test1";

	public WriteMapTest() throws AuthenticationException,
			AuthorizationException, TException, InvalidRequestException {
		TSocket socket = new TSocket("localhost", 9160);
		tr = new TFramedTransport(socket);
		TBinaryProtocol binaryProtocol = new TBinaryProtocol(tr, true, true);
		client = new Cassandra.Client(binaryProtocol);
		try {
			tr.open();
			client.set_keyspace(this.keyspace);
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertData() throws InvalidRequestException, TException,
			UnsupportedEncodingException, NotFoundException {
		// insert data

		System.out.println("------------insert-----------");

        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1, "aaaaa");
        map.put(2, "bbbbb");
		ColumnParent parent = new ColumnParent(this.columnFamily);
		ByteBuffer row = null;
		ByteBuffer columnkey = null;
		Column column = null;
		try {
			for (int i = 1; i <= 1; i++) {
				row = ByteBufferUtil.bytes(("key" + (i)));
				columnkey = ByteBufferUtil.bytes("map" + i);
				column = new Column();
				column.setName(columnkey);
				column.setValue(ByteUtil.getBytes(map));
				column.setTimestamp(1000);
				// column.setTtl(2000);
				// column.setVersion(1336377186220L+3);
				// column.setTtl(0);

				client.insert(row, parent, column, ConsistencyLevel.ONE);

			}

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
		try {
			for (int i = 1; i <= 1; i++) {

				row = ByteBufferUtil.bytes(("key" + (i)));
				columnkey = ByteBufferUtil.bytes("map" + i);
				columnpath.setColumn(columnkey);
				ColumnOrSuperColumn columnOrSuper = client.get(row, columnpath,
						ConsistencyLevel.ONE);

				if (columnOrSuper.getColumn() != null) {
					System.out.println("rowKey     :" + (" key" + (i)));
					System.out.println("columnName : "
							+ ByteBufferUtil
									.string(columnOrSuper.getColumn().name));
					System.out.println("columnValue: ");
					Map<Integer,String> map = (Map<Integer,String>)ByteUtil.getObject(columnOrSuper.getColumn().value);
					for(int j:map.keySet()){
						System.out.println(map.get(j));
					}
					System.out.println("timeStamp  : "
							+ columnOrSuper.getColumn().getTimestamp());
					System.out.println("TTL        : "
							+ columnOrSuper.getColumn().getTtl());
					System.out.println("version    : "
							+ columnOrSuper.getColumn().getVersion());
				}

				List columnkey_list = new ArrayList();
				columnkey_list.add(columnkey);
				slicepredicate.setColumn_names(columnkey_list);
				int count = client.get_count(row, parent, slicepredicate,
						ConsistencyLevel.ONE);
				System.out.println(count);

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
		 Map<Integer,String> map = new HashMap<Integer,String>();
	        map.put(33, "345");
	        map.put(44, "456");
		try {
			for (int i = 1; i <= 1; i++) {
				row = ByteBufferUtil.bytes(("key" + (i)));
				column = new UpdateColumn();
				column.setName(ByteBufferUtil.bytes("map" + i));
				column.setValue(ByteBufferUtil.getByteBuffer(map));
				column.setTimestamp(1000);
				column.setVersion(-1);

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

	public static void main(String[] args) throws Exception {
		WriteMapTest wm = new WriteMapTest();
//		wm.insertData();
//		 wm.deleteData();
		wm.updateData();
		wm.queryData();
		wm.shutDown();
	}

}
