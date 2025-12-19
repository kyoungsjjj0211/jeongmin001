package com.thejoa703.external;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
@Component
public class ApiCoolSms {

		@Value("${coolsms.apikey}")
		String api_key;
		@Value("${coolsms.apisecretkey}")
		String api_secret;
		
		public String phoneNumber(String to) throws CoolsmsException{
			Random random = new Random();
			String result = String.format("%06d", random.nextInt(10000000));
			//2. 메시지보내기
			//net.nurigo.java_sdk.apu.Message;
			Message message = new Message(api_key , api_secret);
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("to", to);
			params.put("from", to);
			params.put("type", "SMS");
			params.put("text", "[THEJOA] 인증번호 : ["+result+"] 타인 유출로 인한 피해 주의");
			message.send(params);
			return result;
		}
}
