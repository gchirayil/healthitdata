package com.example.healthitdata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.healthitdata.domain.BasicEhrNotesUsage;
import com.example.healthitdata.exception.DataServiceException;
import com.example.healthitdata.service.data.IHealthITDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@ExtendWith(MockitoExtension.class)
public class HealthITServiceTest {
	
	@InjectMocks
	private HealthITService healthITService;
	
	@Mock
	private IHealthITDataService healthITDataService;
	
	@BeforeEach
	public void beforeEach() {
		//MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getBasicEhrNotesUsageTest() throws JsonMappingException, JsonProcessingException, DataServiceException {
		
		int year = 2014;
		List<BasicEhrNotesUsage> basicEhrNotesUsageList = List.of(new BasicEhrNotesUsage("Maryland",71.0),new BasicEhrNotesUsage("Texas",84.0));
		Mockito.when(healthITDataService.getBasicEhrNotesUsageList(year)).thenReturn(basicEhrNotesUsageList);
		
		List<BasicEhrNotesUsage> basicEhrNotesUsageDescOrderList = healthITService.getBasicEhrNotesUsageDescOrder(year);
		
		assertEquals("Texas",basicEhrNotesUsageDescOrderList.get(0).getStateName());
	}

}
