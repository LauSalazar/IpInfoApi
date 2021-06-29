package com.laurash.ipinfoapi.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class IpRepositoryTest {
	
	@Autowired
	IpRepository ipRepository;

	@Test
	void test() {
		String ip = "125.25.36.5";
		List<String> ips = new ArrayList<String>();
		ips.add(ip);
		
		ipRepository.saveIp(ip);
		List<String> ipsResult = ipRepository.getBanIp("125.25.36.5");
		assertFalse(ipsResult.isEmpty());
		ipRepository.deleteIp(ip);
		
	}

}
