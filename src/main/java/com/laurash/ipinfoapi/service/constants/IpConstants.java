package com.laurash.ipinfoapi.service.constants;

public class IpConstants {
	
	public static final String ERROR_MSG_LOCATION = "Ocurrio un error consultado la ubicacion de la ip";
	public static final String ERROR_MSG_CONVERT_CURRENCY = "Ocurrio un error convirtiendo a dolares";
	public static final String ERROR_MSG_BAN_IP = "La ip ingresada ya se encuentra restringida";
	public static final String ERROR_MSG_LET_IP = "La ip no se encuentra restringida";
	public static final String BASE_CURRENCY = "USD";
	public static final String URL_IPAPI = "http://api.ipapi.com/api/{ip}?access_key={access_key}";
	public static final String URL_FIXERAPI = "http://data.fixer.io/api/convert?access_key={api_key}&from={from}&to={to}&amount={amount}";
	public static final String URL_COUNTRIESAPI = "https://restcountries.eu/rest/v2/alpha/";
	public static final String ERROR_MSG_IP_BAN = "No es posible mostrar la informacion de esta ip";
	public static final String ACCESS_KEY_IPAPI = "7978df0028427271e71514d308ba2cbd";
	public static final String ACCESS_KEY_FIXERAPI = "8d6f844b743984448c3597610983079f";
	
}
