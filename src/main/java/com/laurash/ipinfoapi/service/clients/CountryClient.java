package com.laurash.ipinfoapi.service.clients;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.laurash.ipinfoapi.model.Country;
import com.laurash.ipinfoapi.service.constants.IpConstants;

public class CountryClient {
	
	public Country getInfoCountry(String code) {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(IpConstants.URL_COUNTRIESAPI.concat(code), String.class);
		Gson gson = new Gson();
		return gson.fromJson(result, Country.class);
	}

}
