package org.apache.cassandra.delta;

import java.io.Serializable;

public class FunctionBean implements Serializable {

	private static final long serialVersionUID = -4051388778722003738L;
	private String name;
	private String path;
	private String detail;
	private short flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public short getFlag() {
		return flag;
	}

	public void setFlag(short flag) {
		this.flag = flag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
