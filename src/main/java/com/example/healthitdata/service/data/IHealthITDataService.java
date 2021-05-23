package com.example.healthitdata.service.data;

import java.util.List;

import com.example.healthitdata.domain.BasicEhrNotesUsage;
import com.example.healthitdata.exception.DataServiceException;

public interface IHealthITDataService {

	List<BasicEhrNotesUsage> getBasicEhrNotesUsageList(int year) throws DataServiceException;

}
