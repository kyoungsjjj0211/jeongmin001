package com.company.java003;

public class Casting002char {
		public static void main(String[] args) {
			//#1. 문자 초기화
			//문자는 저장시 숫자 /철력시 문자
			char ch1 = ' ';  // 공백한개라도 있어야 오류가 안남.
			char ch2 = '\u0000';
			
			System.out.println("step1 : " + ch1 + "\t" + ch2);
			System.out.println("step2 : " + (int)ch1 + "\t" + (int)ch2);
			
			//#2. 문자의 연산
			char c = 'A';
			System.out.println("step3 : " + c + "\t" + (int)c);
			System.out.println("step4 : " + (c+1)); // 다음의 결과물은?
			//2-1) 'A'+1
			//2-2) int(4byte) = char(65|2byte) + int(1|4byte)
			//2-3) 66
			System.out.println("step5 : " + (char)(c+1));
			

			//Q1) 대문자'A'를 소문자 'a'로 변환시키기
			System.out.println("hint : " + 'A' + "\t" + (int)'A'); //A 65
			System.out.println("hint : " + 'a' + "\t" + (int)'a'); //a 97
			// 'a' = 'A' 어떻게 처리
			// 97 = 65+32
			char q1 = 'A';
			char a1 = (char)(q1+32);  // int(4byte) char(2byte) + int(4byte)
			System.out.println(q1 + "을 소문자로 변환시키려면 +32 : "+ a1);
			
			char upper = 'A';
			char lower = (char)(upper + 32); // 'A' → 'a'

			System.out.println(upper + "=" + lower); // 출력: A=a

			
			//#3. 문자열
			//자료형의 분류는 기본형(값) 과 참조형 (주소)
			String str1 = "abc";
			String str2 = "abc";
			String str3 = new String("abc");
			
			System.out.println(System.identityHashCode(str1));
			System.out.println(System.identityHashCode(str2));
			System.out.println(System.identityHashCode(str3));
			
			System.out.println(str1 == str3); //주소값비교 - false
			System.out.println(str1.equals(str3)); //문자열비교 ★
			
		}// end main
}//end class
