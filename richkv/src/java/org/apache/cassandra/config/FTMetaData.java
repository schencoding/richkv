package org.apache.cassandra.config;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;

import org.apache.cassandra.thrift.FtDef;
import org.apache.cassandra.utils.ByteBufferUtil;

public class FTMetaData {

	public final String name;
	public final String strategyClass;
	public final String description;

	private FTMetaData(String name, String strategyClass, String description) {
		this.name = name;
		this.strategyClass = strategyClass;
		this.description = description;
	}

	public static FTMetaData cloneWith(FTMetaData ftm) {
		return new FTMetaData(ftm.name, ftm.strategyClass, ftm.description);
	}

	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof FTMetaData))
			return false;
		FTMetaData other = (FTMetaData) obj;
		return other.name.equals(name)
				&& other.strategyClass.equals(strategyClass)
				&& other.description.equals(description);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(", strategy:").append(strategyClass).append(
				", description: ").append(description);
		return sb.toString();
	}

	public static FTMetaData fromThrift(FtDef ftd)
			throws ConfigurationException {
		return new FTMetaData(ftd.name, ftd.strategy_class, ftd.description);
	}

	public FtDef toThrift() {

		FtDef ftdef = new FtDef(name, strategyClass);
		ftdef.setDescription(description);

		return ftdef;
	}

	public static FTMetaData fromByteBuffer(ByteBuffer name, ByteBuffer value)
			throws ConfigurationException, CharacterCodingException {
		String temp = ByteBufferUtil.string(value);
		int n = temp.lastIndexOf(',');
		return new FTMetaData(ByteBufferUtil.string(name), temp
				.substring(n + 1), temp.substring(0, n));
	}

	public ByteBuffer toByteBuffer() {
		String string = description == null ? "" : description + ","
				+ strategyClass;
		return ByteBufferUtil.bytes(string);
	}

	public static void main(String args[]) throws IOException,
			ClassNotFoundException {
		FTMetaData ft = new FTMetaData("a", "b", "111asdfsdf");
		ByteBuffer b1 = ByteBufferUtil.getByteBuffer(ft);
		FTMetaData ftm = (FTMetaData) ByteBufferUtil.getObject(b1);
		System.out.println(ftm.name);
		System.out.println(ftm.description);
		System.out.println(ftm.strategyClass);
	}

}
