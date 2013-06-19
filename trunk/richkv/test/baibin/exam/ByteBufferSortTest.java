package exam;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.NavigableSet;
import java.util.TreeMap;

import org.apache.cassandra.db.Column;
import org.apache.cassandra.db.IColumn;
import org.apache.cassandra.db.ISortedColumns;
import org.apache.cassandra.db.UpdateColumn;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.HeapAllocator;


public class ByteBufferSortTest {
	
	public static void main(String args[]){
		ISortedColumns columns =UpdateColumn.createSortedColumns();
		long curr = new Date().getTime();
		System.out.println(curr);
		long []tArray= {curr,curr+1,curr-1,curr+7,curr+3,curr+10,curr+100,curr+20,curr+200,curr+30,curr+300,curr+40};
		System.out.println("----------put---------");
		for(int i=0;i<tArray.length;i++){			
			long version = tArray[i];		
			Column column = new Column(ByteBufferUtil.bytes("name"),ByteBufferUtil.bytes("value"),0,version);
			System.out.println(version);
			columns.addColumn(column, HeapAllocator.instance);
		}
		
		System.out.println("----------get---------");
		int size = columns.getColumnNames().size();
		for(int j=0;j<size;j++){
			ByteBuffer bytebuffer = (ByteBuffer) ((NavigableSet) columns.getColumnNames()).pollFirst();			
			System.out.println(ByteBufferUtil.toLong(bytebuffer));
		}
		
	}

}
