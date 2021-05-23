package com.example.healthitdata.service;

import java.util.List;

import com.example.healthitdata.domain.BasicEhrNotesUsage;
import com.example.healthitdata.exception.DataServiceException;

public interface IHealthITService {

	List<BasicEhrNotesUsage> getBasicEhrNotesUsageDescOrder(Integer year) throws DataServiceException;
	
}