package com.laurash.ipinfoapi.model;

public class CurrencyConvert {
	private boolean success;
	private String date;
	private double result;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "CurrencyConvert [success=" + success + ", date=" + date + ", result=" + result + "]";
	}
	
	

}
