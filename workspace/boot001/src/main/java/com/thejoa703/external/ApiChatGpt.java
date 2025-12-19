package com.thejoa703.external;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders; //##
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiChatGpt {

	@Value("${openai.api.key}")
	private String apiKey;
	
	private static final String API_URL="https://api.openai.com/v1/chat/completions";
	private final ObjectMapper objectMapper=new ObjectMapper();
	
	// 이 일기를 이모티콘으로 요약해줘
	public String getAIResponse(String userMessage) {
		RestTemplate  restTemplate = new RestTemplate();
	    //org.springframework.http.HttpHeaders;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Bearer " + apiKey);  //## 공백주의
		
		Map<String, Object> body = new HashMap<>();
		body.put("model", "gpt-4");
		body.put("messages", List.of(
				Map.of("role" , "user" , "content" , userMessage + "이 일기를 이모티콘으로 요약해줘")
		)); 
	    //org.springframework.http.HttpEntity;
		HttpEntity<Map<String, Object>>  requestEntity = new HttpEntity<>(body, headers);
		/////////////////////////////////////////////////////////////////////////////////

	    //org.springframework.http.ResponseEntity                          주소,      요청,          응답형태
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(API_URL, requestEntity, String.class);
		String responseBody = responseEntity.getBody();
		
		//com.fasterxml.jackson.databind.JsonNode
		try {
			JsonNode root =   objectMapper.readTree(responseBody);  
			return  root.path("choices").get(0).path("message").path("content").asText();
		} catch (Exception e) { throw new RuntimeException("OpenAI 응답 파싱 오류" , e); }
		 
	}
}
/*
package com.thejoa703.extemal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiChatGpt{
	@Value("${openai.api.key}")
	private String apiKey;
	
	private static final String API_URL="https://api.openai.com/v1/chat/completions";
	private final ObjectMapper objectMapper=new ObjectMapper();
	
	public String getAIResponse(String userMessage) {
		RestTemplate restTemplate  = new RestTemplate();
		//org.spingFramework.http.HttpHeaders;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Bearer " + apiKey); //## 공백주의
		
		Map<String, Object> body = new HashMap<>();
		body.put("model", "gpt-4.1-mini");
		body.put("messages", List.of(
				Map.of("role", "user", "content" , userMessage + "이 일기를 이모티콘으로 요약해줘")
		));
		//org.spingFramework.http.HttpEntity;
		HttpEntity<Map<String,Object>> requestEntity = new HttpEntity<>(body, headers);
		///////////////////////////////////////////////////////////////////////////////
		
		//org.springframework.gttp.ResponseEntity							주소,     요청,         응답형태
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(API_URL, requestEntity, String.class);
		String responseBody = responseEntity.getBody();
		//com.fasterxml.jackson.databind.JsonNode
		try {
			JsonNode root = objectMapper.readTree(responseBody);
			return  root.path("choices").get(0).path("message").path("content").asText();
		}catch(Exception e) {throw new RuntimeException("OpenAi 응답 피싱 오류", e);}

	}
}
*/



//참고 경로 : https://platform.openai.com/docs/api-reference/chat?locale=ko

/*
curl https://api.openai.com/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $OPENAI_API_KEY" \
  -d '{
    "model": "gpt-5.2",
    "messages": [
      {
        "role": "developer",
        "content": "You are a helpful assistant."
      },
      {
        "role": "user",
        "content": "Hello!"
      }
    ]
  }'
*/