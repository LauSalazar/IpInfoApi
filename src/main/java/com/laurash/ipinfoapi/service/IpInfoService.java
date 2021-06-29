package com.laurash.ipinfoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurash.ipinfoapi.model.Country;
import com.laurash.ipinfoapi.model.InfoIp;
import com.laurash.ipinfoapi.model.LocationInfoIp;
import com.laurash.ipinfoapi.repository.IpRepository;
import com.laurash.ipinfoapi.service.clients.CountryClient;
import com.laurash.ipinfoapi.service.clients.CurrencyClient;
import com.laurash.ipinfoapi.service.clients.LocationClient;
import com.laurash.ipinfoapi.service.constants.IpConstants;
import com.laurash.ipinfoapi.service.exceptions.MsgException;

@Service
public class IpInfoService {
	
	@Autowired
	IpRepository ipRepository;

	/**
	 * Metodo que consulta la informacion de una ip
	 * @param ip Dato a consultar
	 * @return Objeto InfoIp con los datos de la ip solicitada 
	 * @throws MsgException
	 */
	public InfoIp getInfoIp(String ip) throws MsgException {
		List<String> ips = ipRepository.getBanIp(ip);
		if(ips.isEmpty()) {
			
			LocationClient locationClient = new LocationClient();
			LocationInfoIp locationInfo = locationClient.getLocationInfoIp(ip);
			double quote = 0;
			
			String currencyCode = getCurrencyCode(locationInfo);
			
			//Se omitirá ya que la suscripcion gratuita no permite hacer la conversion de monedas
//			CurrencyClient currencyClient = new CurrencyClient();
//			if(!"".equalsIgnoreCase(currencyCode)) {
//				quote = currencyClient.getCurrencyInfo(currencyCode);
//			}
			
			InfoIp infoIp = new InfoIp();
			infoIp.setIp(ip);
			infoIp.setCountryISOCode(locationInfo.getCountry_code());
			infoIp.setCountryName(locationInfo.getCountry_name());
			infoIp.setLocalCurrency(currencyCode);
			infoIp.setDollarQuote(quote);
			return infoIp;
		} else {
			throw new MsgException(IpConstants.ERROR_MSG_IP_BAN);
		}
		
	}

	/**
	 * Metodo que consulta la informacion del codigo de la moneda
	 * @param locationInfo
	 * @return
	 */
	private String getCurrencyCode(LocationInfoIp locationInfo) {
		String currencyCode ="";
		if(null != locationInfo.getCurrency() && null != locationInfo.getCurrency().getCode()) {
			currencyCode = locationInfo.getCurrency().getCode();
		} else if(null != locationInfo.getCountry_code() && !"".equalsIgnoreCase(locationInfo.getCountry_code())){
			CountryClient countryClient = new CountryClient();
			Country country = countryClient.getInfoCountry(locationInfo.getCountry_code());
			currencyCode = country.getCurrencies().get(0).getCode();
		}
		return currencyCode;
	}

}
