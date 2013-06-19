package exam;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
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

public class WriteArrayTest {
	private Cassandra.Client client;
	private String keyspace = "demo";
	private String columnfamily = "test";
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
		String str[] = { "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		try {
			for (int i = 1; i <= 1; i++) {
				row = ByteBufferUtil.bytes(("key" + (i)));
				columnkey = ByteBufferUtil.bytes("col1" + i);
				column = new Column();
				column.setName(columnkey);
				column.setValue(ByteUtil.getByteBuffer(str));
				column.setTimestamp(new Date().getTime());

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
				columnkey = ByteBufferUtil.bytes("col1" + i);
				deltakey = ByteBufferUtil.bytes("2,200");
				columnpath.setColumn(columnkey);
				ColumnOrSuperColumn columnOrSuper = client.get(row, columnpath,
						ConsistencyLevel.ONE);

				// ColumnOrSuperColumn columnOrSuper = client.get_delta(row,
				// deltakey, columnpath,
				// ConsistencyLevel.ONE);
				if (columnOrSuper.getColumn() != null) {
					System.out.println("rowKey     :" + (" key" + (i)));
					System.out.println("columnName : "
							+ ByteBufferUtil
									.string(columnOrSuper.getColumn().name));
					String[] str = (String[]) ByteUtil
									.getObject(columnOrSuper.getColumn().getValue());
					String string = "";
					for(String stemp:str){
						string += stemp+" ";
					}
					System.out.println("columnValue: "
							+ string);
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
		try {
			for (int i = 1; i <= 1; i++) {
				row = ByteBufferUtil.bytes(("key" + (i)));
				column = new UpdateColumn();
				column.setName(ByteBufferUtil.bytes("col1" + i));
				column.setValue(ByteBufferUtil.bytes("2,24"));
				column.setTimestamp(new Date().getTime());
				column.setVersion(-1);
//				column.setVersion(1339665947356L+10);

				client.insert_delta(row, parent, column, ConsistencyLevel.ONE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[]) throws AuthenticationException,
			AuthorizationException, TException, InvalidRequestException,
			SchemaDisagreementException, UnsupportedEncodingException,
			NotFoundException {

		WriteArrayTest wat = new WriteArrayTest();
		wat.init();

//		wat.insert();
		wat.update();
		wat.query();

		wat.destroy();

	}
}
