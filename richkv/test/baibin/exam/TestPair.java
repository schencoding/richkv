package exam;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.Pair;

public class TestPair {
	
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		Map<Pair<ByteBuffer,ByteBuffer>,String> map = new HashMap<Pair<ByteBuffer,ByteBuffer>,String>();
//		String x = "aaa";
//		String y = "bbb";
//		String a = "aaa";
//		String b = "bbb";
		String str = "aaaaaaaaaa";
		StringBuilder sbu = new StringBuilder(1000);
		for(int i=0;i<100;i++){
			sbu.append(str);
		}
		long t1 = System.nanoTime();
		ByteBuffer b1 = ByteBufferUtil.bytes(sbu.toString());
		long t2 = System.nanoTime();
		ByteBuffer b2 = ByteBufferUtil.getByteBuffer(sbu);
		long t3 = System.nanoTime();
		Object o = ByteBufferUtil.getObject(b2);
		long t4 = System.nanoTime();
		String a = ByteBufferUtil.string(b1);
		long t5 = System.nanoTime();
		StringBuilder sbu2 = (StringBuilder)o;
		String b = o.toString();
		long t6 = System.nanoTime();
		System.out.println(t2-t1);
		System.out.println(t3-t2);
		System.out.println(t4-t3);
		System.out.println(t5-t4);
		System.out.println(t6-t5);
		
		
		
//		ByteBuffer b2 = ByteBufferUtil.bytes(y);
//		ByteBuffer b3 = ByteBufferUtil.bytes(a);
//		ByteBuffer b4 = ByteBufferUtil.bytes(b);
//	    map.put(Pair.create(b1, b2), "111");
//	    Pair key = Pair.create(b3, b4);
//	    if(map.containsKey(key)){
//	    	System.out.println(map.get(key));
//	    }
	}

}
