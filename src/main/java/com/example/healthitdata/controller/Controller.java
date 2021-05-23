package com.example.healthitdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthitdata.domain.BasicEhrNotesUsage;
import com.example.healthitdata.exception.DataServiceException;
import com.example.healthitdata.service.HealthITService;
import com.example.healthitdata.service.IHealthITService;

@RequestMapping("/api/v1/")
@RestController
public class Controller {
	
	@Autowired
	IHealthITService healthITService;
	
	@GetMapping("ehrnotesusage/{year}")
	public List<BasicEhrNotesUsage> listEhrNotesUsage(@PathVariable Integer year) throws DataServiceException {
		return healthITService.getBasicEhrNotesUsageDescOrder(year);
	}

}
