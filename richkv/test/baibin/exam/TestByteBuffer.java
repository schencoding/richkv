package exam;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.cassandra.utils.ByteBufferUtil;


public class TestByteBuffer {
	
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		int i = 234;
		Integer j = 453333;
		ByteBuffer b1  = ByteBufferUtil.bytes(j);
		ByteBuffer b2  = ByteBufferUtil.getByteBuffer(j);
		System.out.println(b1.capacity());
		System.out.println(b2.capacity());
		Object obj1 = ByteBufferUtil.getObject(b1);
		Object obj2 = ByteBufferUtil.getObject(b2);
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		
	}

}
