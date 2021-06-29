package com.laurash.ipinfoapi.model;

public class LocationInfoIp {
	
	private String country_name;
	private String country_code;
	private Currency currency;
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "LocationInfoIp [country_name=" + country_name + ", country_code=" + country_code + ", currency="
				+ currency + "]";
	}
	
	

}
