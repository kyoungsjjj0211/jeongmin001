package com.company.java006Ex;

public class ArrayEx005 {
	public static void main(String[] args) {
		char ch [] = {'B','a','n','a','n','a'};
		int Acount =0;
		int acount =0;
		
		for(int i = 0; i<ch.length; i++) {
			if(ch[i] >='A' && ch[i] <='Z') {Acount++;}
			else if (ch[i] >='a' && ch[i] <='z') {acount++;}
		}
		System.out.println("대문자의 개수 : " + Acount);
		System.out.println("소문자의 개수 : " + acount);
	}

}
/*연습문제5)  array
패키지명 : com.company.java006_ex
클래스명 :  ArrayEx005
    1. 배열명 : ch
    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'
    3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트
*/
//ver-1. 만약 'B'가 대문자라면 대문자 카운트, 소문자라면 소문자 카운트
//ver-2. if(만약 'B'가 대문자라면){대문자 카운트} else if(소문자라면){소문자카운트}
//ver-3. 	  if(ch[0]>='A' && ch[0]<='Z'){upper++;}
//		 else if(ch[0]>='a' && ch[0]<='z'){lower++;}
//출력 -대문자의 갯수카운트, 소문자의 갯수카운트