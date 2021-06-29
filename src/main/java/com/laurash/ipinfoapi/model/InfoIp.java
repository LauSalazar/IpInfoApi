package com.laurash.ipinfoapi.model;

public class InfoIp {
	/**
	 * Ip
	 */
	private String ip;
	/**
	 * Nombre del pais
	 */
	private String countryName;
	/**
	 * Codigo ISO del pais
	 */
	private String countryISOCode;
	/**
	 * Moneda local
	 */
	private String localCurrency;
	/**
	 * Cambio de la moneda local a dolares
	 */
	private double dollarQuote;
	
	public InfoIp() {};
	public InfoIp(String ip, String countryName, String countryISOCode, String localCurrency, double dollarQuote) {
		super();
		this.ip = ip;
		this.countryName = countryName;
		this.countryISOCode = countryISOCode;
		this.localCurrency = localCurrency;
		this.dollarQuote = dollarQuote;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryISOCode() {
		return countryISOCode;
	}
	public void setCountryISOCode(String countryISOCode) {
		this.countryISOCode = countryISOCode;
	}
	public String getLocalCurrency() {
		return localCurrency;
	}
	public void setLocalCurrency(String localCurrency) {
		this.localCurrency = localCurrency;
	}
	public double getDollarQuote() {
		return dollarQuote;
	}
	public void setDollarQuote(double dollarQuote) {
		this.dollarQuote = dollarQuote;
	}
	@Override
	public String toString() {
		return "InfoIp [ip=" + ip + ", countryName=" + countryName + ", countryISOCode=" + countryISOCode
				+ ", localCurrency=" + localCurrency + ", dollarQuote=" + dollarQuote + "]";
	}
	
	

}
