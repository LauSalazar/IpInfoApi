package com.laurash.ipinfoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laurash.ipinfoapi.model.InfoIp;
import com.laurash.ipinfoapi.service.IpService;
import com.laurash.ipinfoapi.service.IpInfoService;
import com.laurash.ipinfoapi.service.exceptions.MsgException;

/**
 * Clase controller donde se expondran los servicios para consultar informacion de una ip, prohibir consultarla y permitirla
 * @author lksalazar
 *
 */
@RestController
public class ApiController {
	
	@Autowired
	private IpService ipService;
	
	@Autowired
	private IpInfoService ipInfoService;

	/**
	 * Servicio para obtener informacion de una ip
	 * @param ip Dato a consultar
	 * @return Objeto con los datos de la ip consultada
	 * @throws MsgException 
	 */
	@GetMapping("/infoIp")
	public ResponseEntity<InfoIp> getInfo(@RequestParam String ip) throws MsgException {
			InfoIp infoIp = ipInfoService.getInfoIp(ip);
			return new ResponseEntity<>(infoIp, HttpStatus.OK);
	}
	
	/**
	 * Servicio para prohibir que se consulte informacion de una ip determinada
	 * @param ip Dato de la ip a prohibir
	 * @return Mensaje de exito
	 */
	@GetMapping("banIp")
	public ResponseEntity<String> banIp(@RequestParam String ip){
		Gson gson = new GsonBuilder().create();
		try {
			ipService.banIp(ip);
			return new ResponseEntity<>("Ip guardada correctamente", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Servicio para permitir que se consulte la informacion de una ip
	 * @param ip Dato de la ip a permitir la consulta
	 * @return Mensaje de exito
	 */
	@GetMapping("letIp")
	public ResponseEntity<String> letIp(@RequestParam String ip){
		Gson gson = new GsonBuilder().create();
		try {
			ipService.letIp(ip);
			return new ResponseEntity<>("Ip permitida nuevamente", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(gson.toJson(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
