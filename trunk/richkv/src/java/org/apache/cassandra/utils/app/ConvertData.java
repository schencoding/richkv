package org.apache.cassandra.utils.app;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.cassandra.utils.ByteBufferUtil;

public class ConvertData {

	public static Object deserialize(ByteBuffer bytebuffer) {

		Object obj = null;
		try {
			obj = (Object) ByteBufferUtil.getObject(bytebuffer);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	public static ByteBuffer serialize(Object obj) {

		ByteBuffer bytebuffer = null;
		try {
			bytebuffer = ByteBufferUtil.getByteBuffer(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytebuffer;
	}

}
