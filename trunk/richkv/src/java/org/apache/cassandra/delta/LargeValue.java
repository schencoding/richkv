package org.apache.cassandra.delta;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.Pair;

public class LargeValue {

	private static final Map<Pair<String, String>, List<Pair<ByteBuffer, ByteBuffer>>> map = new HashMap<Pair<String, String>, List<Pair<ByteBuffer, ByteBuffer>>>();

	public static String getStringName(ByteBuffer columnkey, int id) {
		String chunkname = null;
		try {
			long time = System.currentTimeMillis();
			chunkname = ByteBufferUtil.string(columnkey) + "-" + time + "-"
					+ id;
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chunkname;
	}

	public static boolean isLarge(Pair<String, String> key,
			Pair<ByteBuffer, ByteBuffer> value) {
		if (map.containsKey(key)) {
			if (map.get(key).contains(value)) {
				return true;
			}
		}
		return false;

	}

	public static void addLargeMark(Pair<String, String> key,
			Pair<ByteBuffer, ByteBuffer> value) {
		if (!map.containsKey(key)) {
			List<Pair<ByteBuffer, ByteBuffer>> list = new ArrayList<Pair<ByteBuffer, ByteBuffer>>();
			list.add(value);
			map.put(key, list);
		} else {
			if (!map.get(key).contains(value)) {
				map.get(key).add(value);
			}
		}
	}
}
