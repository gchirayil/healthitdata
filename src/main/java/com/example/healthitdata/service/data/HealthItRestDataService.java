package com.example.healthitdata.service.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.healthitdata.domain.BasicEhrNotesUsage;
import com.example.healthitdata.exception.DataServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HealthItRestDataService implements IHealthITDataService {
	
    @Value("${healthit.baseurl}")
    private String healthITBaseUrl;
	
	@Override
	public List<BasicEhrNotesUsage> getBasicEhrNotesUsageList(int year) throws DataServiceException {

		String source = "AHA_2008-2017.csv";

		Map<String,String> paramsMap = new HashMap<>();
		paramsMap.put("period", String.valueOf(year));
		
		Map<String, Map<String, Object>> jsonMap = parseDataFromRest(source, paramsMap);
		
		List<BasicEhrNotesUsage> basicEhrNotesUsageList = new ArrayList<>();
		for (String key : jsonMap.keySet()) {
			Map<String,Object> valueMap = jsonMap.get(key);
			
			String stateName = (String) valueMap.get("region");
			String pctStr = (String) valueMap.get("pct_hospitals_basic_ehr_notes");
			Double pct = pctStr.equals("") ? 0.0 : Double.parseDouble(pctStr)*100.0;
			
			pct = Math.round(pct * 100.0) / 100.0; // Round to 2 decimal places
			
			basicEhrNotesUsageList.add(new BasicEhrNotesUsage(stateName,pct));			
		}
		
		return basicEhrNotesUsageList;
	}
	
	private Map<String, Map<String, Object>> parseDataFromRest(String source, Map<String,String> paramsMap) throws DataServiceException {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = healthITBaseUrl + "?source=" + source;
		for (String paramKey : paramsMap.keySet()) {
			url += "&" + paramKey + "=" + paramsMap.get(paramKey);
		}
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String, Object>> jsonMap = null;
		try {
			jsonMap = objectMapper.readValue(response.getBody(),
			    new TypeReference<Map<String,Map<String,Object>>>(){});
		} catch (JsonProcessingException e) {
			throw new DataServiceException("Error occurred while extracting data");
		}
		
		return jsonMap;
	}

}
