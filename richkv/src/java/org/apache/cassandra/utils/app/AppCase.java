package org.apache.cassandra.utils.app;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.cassandra.config.ConfigurationException;
import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.db.Column;
import org.apache.cassandra.db.ColumnFamilyStore;
import org.apache.cassandra.db.UpdateColumn;
import org.apache.cassandra.thrift.CassandraServer;

import antlr.collections.List;

public class AppCase {

	public static Object appendValue(Object oldValue, Object newValue,
			boolean bool, DeltaData deltadata) {
		if (bool) {
			return deltadata.merge_delta(oldValue, newValue);
		} else {
			return deltadata.merge(oldValue, newValue);
		}

	}

	public static ByteBuffer deltaValue(ByteBuffer oldValue,
			ByteBuffer deltaKey, DeltaData deltadata) {

		return deltadata.delta(oldValue, deltaKey);

	}

	public static Map<Integer, ByteBuffer> spiltValue(ByteBuffer oldValue,
			ByteBuffer deltaKey, DeltaData deltadata) {

		return deltadata.spilt(oldValue, deltaKey);

	}

	public static Object read(ByteBuffer byteBuffer, DeltaData deltadata) {

		return deltadata.read(byteBuffer);

	}

	public static ByteBuffer write(Object object, DeltaData deltadata) {

		return deltadata.write(object);

	}

	public static void main(String args[]) {
		Object deltadata = null;
		String path = " com.hp.hpl.cassandra.DeltaMap".trim();
		System.out.println(path);
		if (path == null) {
			try {
				throw new ConfigurationException(
						"Missing value for delta_function_path");
			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			deltadata = Class.forName(path).getClass();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
