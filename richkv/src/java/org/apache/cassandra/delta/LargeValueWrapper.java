package org.apache.cassandra.delta;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Map;

import org.apache.cassandra.utils.ByteBufferUtil;

public class LargeValueWrapper implements Serializable {

	private final Map<Integer, String> map;

	public LargeValueWrapper(Map map) {
		this.map = map;
	}

	public String getChunkName(int id) {
		assert map != null;
		return map.get(id);
	}

	public void putChunkName(int id, String columnName) {
		assert map != null;
		map.put(id, columnName);
	}

	public void removeChunk(int id) {
		assert map != null;
		map.remove(id);
	}

	public Map getMap() {
		return map;
	}

	public ByteBuffer toByteBuffer() {
		ByteBuffer bf = null;
		try {
			bf = ByteBufferUtil.getByteBuffer(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bf;
	}

	public static LargeValueWrapper create(ByteBuffer byteBuffer) {
		LargeValueWrapper lvw = null;

		try {
			lvw = (LargeValueWrapper) ByteBufferUtil.getObject(byteBuffer);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lvw;
	}

}
