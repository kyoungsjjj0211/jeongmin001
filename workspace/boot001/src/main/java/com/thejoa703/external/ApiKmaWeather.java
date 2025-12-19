package com.thejoa703.external;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiKmaWeather {
	@Value("${kma.api}")
	private String apiKey;
	
	public String getWeatherResponse() throws URISyntaxException{
		String date = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
		String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"
				+ "?serviceKey="+apiKey+"&numOfRows=10&pageNo=1"
				+ "&base_date="+date+"&base_time=0600&nx=55&ny=127";
		URI uri = new URI(url); //##
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		
		return response.getBody();
	}
	
}
/*
https://www.data.go.kr/data/15084084/openapi.do


http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst
?serviceKey=인증키&numOfRows=10&pageNo=1
&base_date=20251218&base_time=0600&nx=55&ny=127

>xml
http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst
?serviceKey=d1dbaa48990a65bd6404577b3a7b2de5afbde095cdee258bfeba049b8945d2c7&numOfRows=10&pageNo=1
&base_date=20251218&base_time=0600&nx=55&ny=127

>json
http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst
?serviceKey=d1dbaa48990a65bd6404577b3a7b2de5afbde095cdee258bfeba049b8945d2c7&numOfRows=10&pageNo=1
&base_date=20251218&base_time=0600&nx=55&ny=127&_type=json
*/