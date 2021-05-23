package com.example.healthitdata;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReadTest {

	
	@Test
	public void testJsonReadToMap() throws JsonMappingException, JsonProcessingException {
		
		//String jsonObject = "{\"brand\":\"ford\", \"doors\":5}";
		
		String jsonObject =
				"{\r\n" + 
				"\"104\": {\r\n" + 
				"\"region\": \"National\",\r\n" + 
				"\"region_code\": \"US\",\r\n" + 
				"\"period\": \"2014\",\r\n" + 
				"\"pct_hospitals_basic_ehr_notes\": \"0.76\",\r\n" + 
				"\"pct_rural_hospitals_basic_ehr_notes\": \"0.7\",\r\n" + 
				"\"pct_small_hospitals_basic_ehr_notes\": \"0.7\",\r\n" + 
				"\"pct_critical_access_hospitals_basic_ehr_notes\": \"\",\r\n" + 
				"\"pct_hospitals_basic_ehr_no_notes\": \"0.83\",\r\n" + 
				"\"pct_rural_hospitals_basic_ehr_no_notes\": \"0.77\",\r\n" + 
				"\"pct_small_hospitals_basic_ehr_no_notes\": \"0.76\",\r\n" + 
				"\"pct_critical_access_hospitals_basic_ehr_no_notes\": \"\",\r\n" + 
				"\"pct_hospitals_cehrt\": \"0.97\",\r\n" + 
				"\"pct_small_rural_hospitals_cehrt\": \"0.96\",\r\n" + 
				"\"pct_cah_hospitals_cehrt\": \"0.94\",\r\n" + 
				"\"pct_hospitals_share_labs_any_outside_provs\": \"0.69\",\r\n" + 
				"\"pct_hospitals_share_labs_any_outside_hospitals\": \"0.54\",\r\n" + 
				"\"pct_hospitals_share_labs_any_outside_ambu_provs\": \"0.63\",\r\n" + 
				"\"pct_hospitals_patients_ecopy_ehr\": \"\",\r\n" + 
				"\"pct_hospitals_patients_ecopy_discharge_instr\": \"\",\r\n" + 
				"\"pct_hospitals_share_care_summaries_any_outside_provs\": \"0.64\",\r\n" + 
				"\"pct_hospitals_share_care_summaries_any_outside_hospitals\": \"0.55\",\r\n" + 
				"\"pct_hospitals_share_care_summaries_any_outside_ambu_provs\": \"0.57\",\r\n" + 
				"\"pct_hospitals_patients_vdt\": \"0.64\",\r\n" + 
				"\"pct_hospitals_patients_secure_message\": \"0.51\",\r\n" + 
				"\"pct_hospitals_find_clinical_info\": \"\",\r\n" + 
				"\"pct_hospitals_send_clinical_info\": \"\",\r\n" + 
				"\"pct_hospitals_receive_clinical_info\": \"\",\r\n" + 
				"\"pct_hospitals_integrate_any_clinical_info\": \"\",\r\n" + 
				"\"pct_hospitals_integrate_scr\": \"\",\r\n" + 
				"\"pct_hospitals_send_receive_find_integrate\": \"\",\r\n" + 
				"\"pct_hospitals_api\": \"\",\r\n" + 
				"\"pct_hospitals_integrate_pdmp\": \"\"\r\n" + 
				"},\r\n" + 
				"\"105\": {\r\n" + 
				"\"region\": \"Alaska\",\r\n" + 
				"\"region_code\": \"AK\",\r\n" + 
				"\"period\": \"2014\",\r\n" + 
				"\"pct_hospitals_basic_ehr_notes\": \"0.36\",\r\n" + 
				"\"pct_rural_hospitals_basic_ehr_notes\": \"0.63\",\r\n" + 
				"\"pct_small_hospitals_basic_ehr_notes\": \"0.83\",\r\n" + 
				"\"pct_critical_access_hospitals_basic_ehr_notes\": \"\",\r\n" + 
				"\"pct_hospitals_basic_ehr_no_notes\": \"0.76\",\r\n" + 
				"\"pct_rural_hospitals_basic_ehr_no_notes\": \"0.63\",\r\n" + 
				"\"pct_small_hospitals_basic_ehr_no_notes\": \"0.83\",\r\n" + 
				"\"pct_critical_access_hospitals_basic_ehr_no_notes\": \"\",\r\n" + 
				"\"pct_hospitals_cehrt\": \"\",\r\n" + 
				"\"pct_small_rural_hospitals_cehrt\": \"\",\r\n" + 
				"\"pct_cah_hospitals_cehrt\": \"\",\r\n" + 
				"\"pct_hospitals_share_labs_any_outside_provs\": \"0.73\",\r\n" + 
				"\"pct_hospitals_share_labs_any_outside_hospitals\": \"0.34\",\r\n" + 
				"\"pct_hospitals_share_labs_any_outside_ambu_provs\": \"0.73\",\r\n" + 
				"\"pct_hospitals_patients_ecopy_ehr\": \"\",\r\n" + 
				"\"pct_hospitals_patients_ecopy_discharge_instr\": \"\",\r\n" + 
				"\"pct_hospitals_share_care_summaries_any_outside_provs\": \"0.49\",\r\n" + 
				"\"pct_hospitals_share_care_summaries_any_outside_hospitals\": \"0.23\",\r\n" + 
				"\"pct_hospitals_share_care_summaries_any_outside_ambu_provs\": \"0.49\",\r\n" + 
				"\"pct_hospitals_patients_vdt\": \"0.59\",\r\n" + 
				"\"pct_hospitals_patients_secure_message\": \"0.11\",\r\n" + 
				"\"pct_hospitals_find_clinical_info\": \"\",\r\n" + 
				"\"pct_hospitals_send_clinical_info\": \"\",\r\n" + 
				"\"pct_hospitals_receive_clinical_info\": \"\",\r\n" + 
				"\"pct_hospitals_integrate_any_clinical_info\": \"\",\r\n" + 
				"\"pct_hospitals_integrate_scr\": \"\",\r\n" + 
				"\"pct_hospitals_send_receive_find_integrate\": \"\",\r\n" + 
				"\"pct_hospitals_api\": \"\",\r\n" + 
				"\"pct_hospitals_integrate_pdmp\": \"\"\r\n" + 
				"}" +
				"}";
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Map<String,Object>> jsonMap = objectMapper.readValue(jsonObject,
		    new TypeReference<Map<String,Map<String,Object>>>(){});
		
		for (String key : jsonMap.keySet()) {
			System.out.println(key);
			System.out.println("value:"+jsonMap.get(key).toString());
			Map<String,Object> valueMap = jsonMap.get(key);
			System.out.println("pct:"+valueMap.get("pct_hospitals_basic_ehr_notes"));
			
			//JsonNode root = objectMapper.readTree(jsonMap.get(key).toString());
			//JsonNode pct = root.path("pct_hospitals_basic_ehr_notes");
			//System.out.println("pct:"+pct.asText());
			
		}
	}
}
