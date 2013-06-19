package org.apache.cassandra.utils.app;

import java.nio.ByteBuffer;
import java.util.Map;

import org.apache.cassandra.thrift.FtDef._Fields;

public interface DeltaData {

	public enum DeltaDataType {
		STRING((short) 1), INT((short) 2), LONG((short) 3), FLOAT((short) 4), DOUBLE(
				(short) 5), OBJECT((short) 6);

		private final short tid;

		DeltaDataType(short id) {
			tid = id;
		}

		public short getTypeId() {
			return tid;
		}

		public static DeltaDataType findId(int id) {
			switch (id) {
			case 1: // STRING
				return STRING;
			case 2: // INT
				return INT;
			case 3: // LONG
				return LONG;
			case 4: // FLOAT
				return FLOAT;
			case 5: // DOUBLE
				return DOUBLE;
			case 6: // OBJECT
				return OBJECT;
			default:
				return null;
			}
		}

	}

	public Object merge(Object oldValue, Object newValue);

	public Object merge_delta(Object oldValue, Object newValue);

	public ByteBuffer delta(ByteBuffer oldValue, ByteBuffer deltakey);

	public Map<Integer, ByteBuffer> spilt(ByteBuffer oldValue,
			ByteBuffer spiltLength);

	public Object read(ByteBuffer bytebuffer);

	public ByteBuffer write(Object object);

}
