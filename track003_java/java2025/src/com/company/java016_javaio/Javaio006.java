package com.company.java016_javaio;

public class Javaio006 {

	public static void main(String[] args) {
		//#1. String 문자열누적 - 새로운 주소 (변형 x)
		String str = "ABC";
		System.out.println("1. str주소 > " + str + " " + System.identityHashCode(str));
		
		str += "D";
		System.out.println("2. str주소 > " + str + " " + System.identityHashCode(str));
		
		//#2. StringBuffer 문자열 누적 - 기존 주소 (변형 o)
		StringBuffer sb= new StringBuffer();
		sb.append("ABC");
		System.out.println("3. sb주소 > " + sb + " " + System.identityHashCode(sb));
		
		sb.append("D");
		System.out.println("4. sb주소 > " + sb + " " + System.identityHashCode(sb));

		//1. id/secret
		//Client ID	       FigimYBBeWqPMrh2uQ0W
		//Client Secret    g4voC20v0G
		
		//2. 요청 URL
		//https://openapi.naver.com/v1/search/book.xml	XML
		//https://openapi.naver.com/v1/search/book.json	JSON
		
		//3. HTTP 메서드 : GET
		
		//4. 파라미터 - 요청내용을 주소표시창줄에 데이터 넣어서 줄께 - 파라미를 쿼리 스트링 형식으로 전달합니다.
		//파라미터 타입 필수여부 설명
		//query String Y 검색어.UTF-8로 인코딩되어야합니다.
		
		// https://openapi.naver.com/v1/search/book.xml?query=사용자가요청한값    (쿼리 스트링 형식)
		// https://openapi.naver.com/v1/search/book.json?query=사용자가요청한값    (쿼리 스트링 형식)
		
	}

}
