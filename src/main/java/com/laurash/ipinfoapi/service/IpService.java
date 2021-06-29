package com.laurash.ipinfoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurash.ipinfoapi.repository.IpRepository;
import com.laurash.ipinfoapi.service.constants.IpConstants;
import com.laurash.ipinfoapi.service.exceptions.MsgException;

/**
 * Clase service para realizar validaciones necesarias antes de realizar guardado en base de datos
 * @author lksalazar
 *
 */
@Service
public class IpService {
	
	@Autowired
	private IpRepository ipRepository;

	/**
	 * Metodo que guarda una ip en base de datos en caso de que no exista
	 * @param ip Dato a guardar
	 * @throws MsgException Mensaje de error
	 */
	public void banIp(String ip) throws MsgException {
		List<String> ips = ipRepository.getBanIp(ip);
		if(ips.isEmpty()) {
			ipRepository.saveIp(ip);
		} else {
			throw new MsgException(IpConstants.ERROR_MSG_BAN_IP);
		}
		
	}
	
	/**
	 * Metodo que elimina una ip de la base de datos en caso de que no exista
	 * @param ip Dato a eliminar
	 * @throws MsgException Mensaje de error
	 */
	public void letIp(String ip) throws MsgException {
		List<String> ipExist = ipRepository.getBanIp(ip);
		if(!ipExist.isEmpty()) {
			ipRepository.deleteIp(ip);
		} else {
			throw new MsgException(IpConstants.ERROR_MSG_LET_IP);
		}
	}

}
