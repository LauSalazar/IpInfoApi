package com.laurash.ipinfoapi.service.clients;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.laurash.ipinfoapi.model.CurrencyConvert;
import com.laurash.ipinfoapi.model.Error;
import com.laurash.ipinfoapi.service.constants.IpConstants;
import com.laurash.ipinfoapi.service.exceptions.MsgException;

public class CurrencyClient {

	public double getCurrencyInfo(String currencyCode) throws MsgException {
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(IpConstants.URL_FIXERAPI, String.class, IpConstants.ACCESS_KEY_FIXERAPI, IpConstants.BASE_CURRENCY, currencyCode, currencyCode);
		Gson gson = new Gson();
		Error error = gson.fromJson(result, Error.class);
		
		CurrencyConvert currencyConvert = null;
		if(result != null && result.contains("error") && !error.isSuccess()) {
			throw new MsgException(IpConstants.ERROR_MSG_CONVERT_CURRENCY);
		} else {
			currencyConvert = gson.fromJson(result, CurrencyConvert.class);
		}
		return currencyConvert.getResult();
		
		
	}

}
