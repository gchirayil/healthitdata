package com.example.healthitdata.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.healthitdata.domain.BasicEhrNotesUsage;
import com.example.healthitdata.service.IHealthITService;

@WebMvcTest(value = Controller.class)
@AutoConfigureMockMvc
public class ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	IHealthITService healthITService;
	
	@Test
	public void listEhrNotesUsageTest() throws Exception {
		
		List<BasicEhrNotesUsage> basicEhrNotesUsageList = List.of(new BasicEhrNotesUsage("Maryland",71.0),new BasicEhrNotesUsage("Texas",84.0));
		Mockito.when(healthITService.getBasicEhrNotesUsageDescOrder(2014)).thenReturn(basicEhrNotesUsageList);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/ehrnotesusage/2014").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
							.andExpect(MockMvcResultMatchers.status().isOk())
							.andReturn();
		
		String resultStr = result.getResponse().getContentAsString();
		
		String expected = "[{stateName:\"Maryland\", percentage:71.0},{stateName:\"Texas\", percentage:84.0}]";
		
		JSONAssert.assertEquals(expected, resultStr, false);
	}

}
