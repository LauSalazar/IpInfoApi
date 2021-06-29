package com.laurash.ipinfoapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.laurash.ipinfoapi.repository.IpRepository;
import com.laurash.ipinfoapi.service.exceptions.MsgException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class IpInfoServiceTest {
	
	@Autowired
	IpInfoService ipInfoService;
	
	@Autowired
	IpRepository ipRepository;
	
	@Autowired
	IpService ipService;

	@Test
	void getInfoIpExceptionExisttest() throws MsgException {
		String ip = "125.25.36.5";
		List<String> ips = ipRepository.getBanIp(ip);
		if(ips.isEmpty()) {
			ipService.banIp(ip);
			MsgException msg = assertThrows(MsgException.class, () -> ipInfoService.getInfoIp(ip));
			assertEquals("No es posible mostrar la informacion de esta ip", msg.getMessage());
			ipService.letIp(ip);
		} else {
			String ipIn = ips.get(0);
			MsgException msg = assertThrows(MsgException.class, () -> ipInfoService.getInfoIp(ipIn));
			assertEquals("No es posible mostrar la informacion de esta ip", msg.getMessage());
		}
	}
	
	@Test
	void getInfoIpClientException() throws MsgException {
		String ip = "125.25.36.5";
		List<String> ips = ipRepository.getBanIp(ip);
		if(ips.isEmpty()) {
			try {
				ipInfoService.getInfoIp(ip);
			} catch (Exception e) {
				System.out.println(e);
				assertEquals(MsgException.class, e.getClass());
			}
			
			
		}
	}

}
