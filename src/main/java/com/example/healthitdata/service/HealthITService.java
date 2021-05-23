package com.example.healthitdata.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthitdata.domain.BasicEhrNotesUsage;
import com.example.healthitdata.exception.DataServiceException;
import com.example.healthitdata.service.data.IHealthITDataService;

@Service
public class HealthITService implements IHealthITService {
	
	@Autowired
	IHealthITDataService healthITDataService;

	@Override
	public List<BasicEhrNotesUsage> getBasicEhrNotesUsageDescOrder(Integer year) throws DataServiceException {
	
		List<BasicEhrNotesUsage> basicEhrNotesUsageList = healthITDataService.getBasicEhrNotesUsageList(year);
		
		return basicEhrNotesUsageList.stream()
					.sorted(Comparator.comparingDouble(BasicEhrNotesUsage::getPercentage).reversed())
					.collect(Collectors.toList());
	}

}
