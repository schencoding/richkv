package exam;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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
import org.apache.cassandra.thrift.SchemaDisagreementException;
import org.apache.cassandra.thrift.UpdateColumn;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.thrift.TException;

import conn.Connector;

public class WriteLargeData {
	private Cassandra.Client client;
	private String keyspace = "demo";
	private String columnfamily = "test";
	private String columnfamily1 = "test1";
	private boolean isEmpty = false;

	private void init() throws AuthenticationException, AuthorizationException,
			TException, InvalidRequestException, SchemaDisagreementException {
		client = Connector.getConn();
		if (isEmpty) {
			Connector.dropKeyspace(keyspace);
			Connector.createKeyspace(keyspace, columnfamily);
		}
		Connector.useKeyspace(keyspace);

	}

	private void destroy() {
		Connector.close();
	}

	public void insert() throws InvalidRequestException, TException,
			UnsupportedEncodingException, NotFoundException,
			SchemaDisagreementException {

		// insert data
		System.out.println("------------insert-----------");

		ColumnParent parent = new ColumnParent(this.columnfamily);
		ByteBuffer row = null;
		ByteBuffer columnkey = null;
		Column column = null;
		String str = "";
		StringBuilder sb = new StringBuilder();
		str = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
		for (int j = 0; j < 1000; j++) {
			sb.append(str);
		}
		try {
			for (int i = 1; i < 2; i++) {
				row = ByteBufferUtil.bytes(("key" + (i)));
				columnkey = ByteBufferUtil.bytes("aacol" + i);
				column = new Column();
				column.setName(columnkey);
				column.setValue(ByteBufferUtil.bytes(10));
				column.setTimestamp(50);

				client.insert(row, parent, column, ConsistencyLevel.ONE);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void query() throws InvalidRequestException, TException,
			UnsupportedEncodingException, NotFoundException {

		// query data
		System.out.println("------------query-----------");
		ColumnPath columnpath = new ColumnPath(this.columnfamily);
		ColumnParent parent = new ColumnParent(this.columnfamily);
		ByteBuffer columnkey = null;
		ByteBuffer row = null;
		ByteBuffer deltakey = null;
		try {
			for (int i = 1; i <= 1; i++) {

				row = ByteBufferUtil.bytes(("key" + (i)));
				columnkey = ByteBufferUtil.bytes("col" + i+"-1");
				deltakey = ByteBufferUtil.bytes("10");
				columnpath.setColumn(columnkey);
//				ColumnOrSuperColumn columnOrSuper = client.get(row, columnpath,
//						ConsistencyLevel.ONE);
				
				columnkey = ByteBufferUtil.bytes("col" + i);
				columnpath.setColumn(columnkey);
//				ColumnOrSuperColumn columnOrSuper = client.get(row, columnpath,
//						ConsistencyLevel.ONE);
				ColumnOrSuperColumn columnOrSuper = client.read_chunk(1, row, columnpath, ConsistencyLevel.ONE);

				// ColumnOrSuperColumn columnOrSuper = client.get_delta(row,
				// deltakey, columnpath,
				// ConsistencyLevel.ONE);
				if (columnOrSuper.getColumn() != null) {
					System.out.println("rowKey     :" +ByteBufferUtil
							.string(row));
					System.out.println("columnName : "
							+ ByteBufferUtil
									.string(columnOrSuper.getColumn().name));
					// String[] str = (String[]) ByteUtil
					// .getObject(columnOrSuper.getColumn().getValue());
					// String string = "";
					// for(String stemp:str){
					// string += stemp+" ";
					// }
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

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update() throws InvalidRequestException, TException,
			UnsupportedEncodingException, NotFoundException {
		// update data

		System.out.println("------------update-----------");

		ColumnParent parent = new ColumnParent(this.columnfamily);
		ByteBuffer row = null;
		UpdateColumn column = null;

		String string = "";
		StringBuilder sb = new StringBuilder();
		string = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
		for (int j = 0; j < 10; j++) {
			sb.append(string);
		}

		try {
			for (int i = 1; i <= 100; i++) {
				row = ByteBufferUtil.bytes(("key" + (i)));
				column = new UpdateColumn();
				column.setName(ByteBufferUtil.bytes("col*" + i));
				column.setValue(ByteBufferUtil.bytes("3333333"));
				column.setTimestamp(new Date().getTime());
				column.setVersion(-1);
				// column.setVersion(1339665947356L+10);

				client.insert_delta(row, parent, column, ConsistencyLevel.ONE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete() throws InvalidRequestException, TException,
			UnsupportedEncodingException, NotFoundException {

		// delete data
		System.out.println("------------remove-----------");
		ColumnPath columnpath = new ColumnPath(this.columnfamily);
		ByteBuffer row = null;
		try {
			for (int i = 1; i < 2; i++) {
				row = ByteBufferUtil.bytes(("key" + (i)));

				columnpath.setColumn(ByteBufferUtil.bytes("col--" + i));
				long timestamp = new Date().getTime()+10000;
				System.out.println(timestamp);
				client.remove(row, columnpath, 21,
						ConsistencyLevel.ONE);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void test() throws CharacterCodingException {

		ByteBuffer rowkey = ByteBufferUtil.bytes("2");
		ByteBuffer rowkey1 = ByteBufferUtil.bytes(5);
		ByteBuffer columnkey = ByteBufferUtil.bytes("col1");
		ByteBuffer columnkey1 = ByteBufferUtil.bytes("col13");
		ByteBuffer a = ByteBufferUtil.bytes(5);
		ArrayList list = new ArrayList();
		list.add(rowkey);
		list.add(rowkey1);
		list.add(columnkey);
		if (!list.contains(columnkey1)) {
			list.add(columnkey1);
		}
		System.out.println(list.size());
		System.out.println(list.contains(a));

		System.out.println();

	}

	public static void main(String args[]) throws AuthenticationException,
			AuthorizationException, TException, InvalidRequestException,
			SchemaDisagreementException, UnsupportedEncodingException,
			NotFoundException, CharacterCodingException {

		WriteLargeData wat = new WriteLargeData();
		wat.init();
//		wat.insert();
//		 wat.update();
//		wat.delete();
		wat.query();
		// wat.test();
		// wat.destroy();

	}
}
