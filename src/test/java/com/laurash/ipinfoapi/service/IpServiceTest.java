package com.laurash.ipinfoapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.laurash.ipinfoapi.service.exceptions.MsgException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class IpServiceTest {
	
	@Autowired
	IpService ipService;
	
	@Test
	void banIpTest() throws MsgException {
		String ip = "125.25.36.5";
		ipService.banIp(ip);
		assertThrows(MsgException.class, () -> ipService.banIp(ip));
		ipService.letIp(ip);
		assertThrows(MsgException.class, () -> ipService.letIp(ip));
	}

}
