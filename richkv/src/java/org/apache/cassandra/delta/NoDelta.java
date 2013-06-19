package org.apache.cassandra.delta;

import java.nio.ByteBuffer;
import java.util.Map;

import org.apache.cassandra.utils.app.DeltaData;

public class NoDelta extends FunctionContainer {

	@Override
	public ByteBuffer delta(ByteBuffer oldValue, ByteBuffer deltakey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object merge(Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object merge_delta(Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, ByteBuffer> spilt(ByteBuffer oldValue,
			ByteBuffer newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
