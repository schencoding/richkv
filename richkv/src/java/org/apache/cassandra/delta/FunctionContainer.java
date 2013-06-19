package org.apache.cassandra.delta;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;

import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.app.DeltaData;

public abstract class FunctionContainer implements DeltaData {

	public  DeltaDataType ddt = DeltaDataType.LONG;

	public Object read(ByteBuffer bytebuffer) {
		Object obj = null;
		switch (ddt.getTypeId()) {
		case 1:
			try {
				obj = ByteBufferUtil.string(bytebuffer);
			} catch (CharacterCodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 2:
			obj = ByteBufferUtil.toInt(bytebuffer);
			break;
		case 3:
			obj = ByteBufferUtil.toLong(bytebuffer);
			break;
		case 4:
			obj = ByteBufferUtil.toFloat(bytebuffer);
			break;
		case 5:
			obj = ByteBufferUtil.toDouble(bytebuffer);
			break;
		case 6:
			try {
				obj = (Object) ByteBufferUtil.getObject(bytebuffer);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		}
		return obj;
	}

	public ByteBuffer write(Object object) {
		ByteBuffer bytebuffer = null;
		switch (ddt.getTypeId()) {
		case 1:
			bytebuffer = ByteBufferUtil.bytes((String) object);
			break;
		case 2:
			bytebuffer = ByteBufferUtil.bytes((Integer) object);
			break;
		case 3:
			bytebuffer = ByteBufferUtil.bytes((Long) object);
			break;
		case 4:
			bytebuffer = ByteBufferUtil.bytes((Float) object);
			break;
		case 5:
			bytebuffer = ByteBufferUtil.bytes((Double) object);
			break;
		case 6:
			try {
				bytebuffer = ByteBufferUtil.getByteBuffer(object);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
		return bytebuffer;
	}

}
