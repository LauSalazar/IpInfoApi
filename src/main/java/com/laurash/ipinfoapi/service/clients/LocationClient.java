package com.laurash.ipinfoapi.service.clients;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.laurash.ipinfoapi.model.Error;
import com.laurash.ipinfoapi.model.LocationInfoIp;
import com.laurash.ipinfoapi.service.constants.IpConstants;
import com.laurash.ipinfoapi.service.exceptions.MsgException;

public class LocationClient {

	public LocationInfoIp getLocationInfoIp(String ip) throws MsgException {
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(IpConstants.URL_IPAPI, String.class, ip,IpConstants.ACCESS_KEY_IPAPI); 
		LocationInfoIp infoIp = null;
		
		Gson gson = new Gson();
		Error error = gson.fromJson(result, Error.class);
		
		if(result != null && result.contains("error") && !error.isSuccess()) {
			throw new MsgException(IpConstants.ERROR_MSG_LOCATION);
		} else {
			infoIp = gson.fromJson(result, LocationInfoIp.class);
		}
	    return infoIp;
	}

}
