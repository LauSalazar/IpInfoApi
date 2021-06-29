package com.laurash.ipinfoapi.model;

public class Error {
	private boolean success;
	private ErrorDes error;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ErrorDes getError() {
		return error;
	}
	public void setError(ErrorDes error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "Error [success=" + success + ", error=" + error + "]";
	}
	
	

}
