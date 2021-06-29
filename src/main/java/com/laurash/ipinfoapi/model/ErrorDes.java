package com.laurash.ipinfoapi.model;

public class ErrorDes {
	private int code;
	private String type;
	private String info;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "ErrorDes [code=" + code + ", type=" + type + ", info=" + info + "]";
	}
	
	

}
