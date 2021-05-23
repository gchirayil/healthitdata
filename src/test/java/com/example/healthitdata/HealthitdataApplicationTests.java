package com.example.healthitdata;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.healthitdata.domain.BasicEhrNotesUsage;
import com.example.healthitdata.exception.DataServiceException;
import com.example.healthitdata.service.IHealthITService;

@SpringBootTest
class HealthitdataApplicationTests {
	
	@Autowired
	private IHealthITService healthITService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void getBasicEhrNotesUsageDescOrderITTest() throws DataServiceException {
		List<BasicEhrNotesUsage> basicEhrNotesUsageList = healthITService.getBasicEhrNotesUsageDescOrder(2014);
		
		for (BasicEhrNotesUsage basicEhrNotesUsage : basicEhrNotesUsageList) {
			basicEhrNotesUsage.print();
		}
	}

}
