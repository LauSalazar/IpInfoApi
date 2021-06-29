package com.laurash.ipinfoapi.model;

import java.util.List;

public class Country {
	private String name;
	private List<Currency> currencies;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Currency> getCurrencies() {
		return currencies;
	}
	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}

	

}
