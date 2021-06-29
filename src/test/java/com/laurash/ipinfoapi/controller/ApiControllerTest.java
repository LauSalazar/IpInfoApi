package com.laurash.ipinfoapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.laurash.ipinfoapi.model.InfoIp;
import com.laurash.ipinfoapi.service.IpInfoService;
import com.laurash.ipinfoapi.service.IpService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IpInfoService ipInfoService;
	
	@MockBean
	private IpService ipService;
	
	
	@Test
	void infoIPTest() throws Exception {
		InfoIp infoIp = new InfoIp("125.25.36.5","COLOMBIA","CO","COP",3700.25);
		String infoResponse = "{\"ip\":\"125.25.36.5\",\"countryName\":\"COLOMBIA\",\"countryISOCode\":\"CO\",\"localCurrency\":\"COP\",\"dollarQuote\":3700.25}";
		Mockito.when(ipInfoService.getInfoIp("125.25.36.5")).thenReturn(infoIp);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/infoIp")
				.param("ip", "125.25.36.5");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
		assertEquals(infoResponse, response.getContentAsString());

		
	}
	
	@Test
	void banIpTest() throws Exception {
		String msj = "Ip guardada correctamente";
		ipService.banIp("125.25.36.5");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/banIp")
				.param("ip", "125.25.36.5");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
		assertEquals(msj, response.getContentAsString());
	}
	
	@Test
	void letIpTest() throws Exception {
		String msj = "Ip permitida nuevamente";
		ipService.letIp("125.25.36.5");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/letIp")
				.param("ip", "125.25.36.5");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
		assertEquals(msj, response.getContentAsString());
	}



}
