package exam;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cassandra.thrift.AuthenticationException;
import org.apache.cassandra.thrift.AuthorizationException;
import org.apache.cassandra.thrift.Cassandra;
import org.apache.cassandra.thrift.Column;
import org.apache.cassandra.thrift.ColumnOrSuperColumn;
import org.apache.cassandra.thrift.ColumnParent;
import org.apache.cassandra.thrift.ColumnPath;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.thrift.InvalidRequestException;
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

public class WriteStringTest {
	private Cassandra.Client client;
	private TTransport tr;
	private String keyspace = "demo";
	private String columnFamily = "test";

	public WriteStringTest() throws AuthenticationException,
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

		// System.out.println("------------insert-----------");
		StringBuffer sf = new StringBuffer(500000);

		for (int n = 0; n < 50000; n++) {
			sf.append("1111111111");
		}
		String str = sf.toString();
		ColumnParent parent = new ColumnParent(this.columnFamily);
		ByteBuffer row = null;
		ByteBuffer columnkey = null;
		Column column = null;
		try {
			column = new Column();

			row = ByteBufferUtil.bytes(("rkey"));
			columnkey = ByteBufferUtil.bytes("ckey");
			column.setName(columnkey);
			column.setValue(ByteBufferUtil.bytes(str));
			long start = System.nanoTime();
			for (int i = 1; i <= 1000; i++) {
				//				
				column.setTimestamp(1000);
				// column.setTtl(2000);
				// column.setVersion(1336377186220L+3);
				// column.setTtl(0);
				// String c = a.substring(i,a.length());

				client.insert(row, parent, column, ConsistencyLevel.ONE);

			}
			long end = System.nanoTime();
			System.out.println(end - start);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateRead() throws InvalidRequestException, TException,
			UnsupportedEncodingException, NotFoundException {
		// update data

		System.out.println("------------update-----------");

		StringBuffer sf = new StringBuffer(500000);

		for (int n = 0; n < 50000; n++) {
			sf.append("1111111111");
		}
		String str = sf.toString();
		ColumnParent parent = new ColumnParent(this.columnFamily);
		ByteBuffer row = null;
		ByteBuffer columnkey = null;
		UpdateColumn column = null;
		try {
			column = new UpdateColumn();

			row = ByteBufferUtil.bytes(("rkey"));
			columnkey = ByteBufferUtil.bytes("ckey");
			column.setName(columnkey);
			column.setValue(ByteBufferUtil.bytes(str));
			column.setTimestamp(1000);
			column.setVersion(-1);
			long start = System.nanoTime();
			for (int i = 1; i <= 1000; i++) {
				//				
				
				// column.setTtl(2000);
				// column.setVersion(1336377186220L+3);
				// column.setTtl(0);
				// String c = a.substring(i,a.length());

				client.insert_delta(row, parent, column, ConsistencyLevel.ONE);

			}
			long end = System.nanoTime();
			System.out.println(end - start);

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
				columnkey = ByteBufferUtil.bytes("str" + i);
				columnpath.setColumn(columnkey);
				ColumnOrSuperColumn columnOrSuper = client.get(row, columnpath,
						ConsistencyLevel.ONE);

				if (columnOrSuper.getColumn() != null) {
					System.out.println("rowKey     :" + (" key" + (i)));
					System.out.println("columnName : "
							+ ByteBufferUtil
									.string(columnOrSuper.getColumn().name));
					System.out.println("columnValue: ");
					System.out.println(ByteBufferUtil.string(columnOrSuper
							.getColumn().value));
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
		int n = 60000;

		String s2 = "";
		for (int s = 0; s < 205; s++) {
			s2 += "4";
		}

		try {
			for (int i = 1; i <= n; i++) {
				row = ByteBufferUtil.bytes(("key" + i));
				column = new UpdateColumn();
				column.setName(ByteBufferUtil.bytes("str" + i));
				// for (int j = 1; j <= n - i; j++) {
				// s2 += (i + 1);
				// }
				column.setValue(ByteBufferUtil.bytes(s2));
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
		WriteStringTest ws = new WriteStringTest();
		System.out.println("----------start---------");

		ws.insertData();

		System.out.println("----------end---------");
		// ws.deleteData();
		// ws.updateData();
		// ws.queryData();
		ws.shutDown();
	}
}