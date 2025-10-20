package com.company.java016_javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Network001_google {

	public static void main(String[] args) {
		//1. Url
		try {
			URL url = new URL("https://www.google.com/");
			//2. 연결객체
			HttpURLConnection conn = (HttpURLConnection)  url.openConnection();
			//3. 요청설정
			conn.setRequestMethod("GET");
			conn.setDoInput(true); conn.setDoOutput(true); conn.setReadTimeout(1000); // 1초
			//4. 응답코드
			int code = conn.getResponseCode(); // 구글에서 응답
			System.out.println(code); //200 응답성공! 404페이지없음 500오류
			//5. 응답데이터 BufferedReader > [Network001-프로그램] > BufferdWriter
			BufferedReader br;
			if(code == 200) {
				//한줄씪읽을 수 있께 속도향상 - 바이트스트림을 문자스트림 - 응답 데티어 스트림
				br= new BufferedReader ( new InputStreamReader(conn.getInputStream()));
			}else {
				br= new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			String line=""; StringBuffer sb = new StringBuffer();
			while( (line = br.readLine()) !=null ) {sb.append(line+"\n");}
			
			System.out.println(sb.toString());
			br.close(); conn.disconnect();
		} catch(MalformedURLException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		}
	}

}
		
		
		


