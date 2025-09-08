package com.company.java005_ex;

public class ForEx005 {
	 public static void main(String[] args) {
	     //변수   
		 int Count = 0;
	     //입력 + 처리(1)
		 //a가 모음이라면 (a,e,i,o,u) 카운트
		 //b가 모음이라면 (a,e,i,o,u) 카운트
		 //c가 모음이라면 (a,e,i,o,u) 카운트
		 
		 //입력 + 처리(2) 구조
		 //if(a가 모음이라면 (a,e,i,o,u)){ 카운트}
		 //if(b가 모음이라면 (a,e,i,o,u)){ 카운트}
		 //if(c가 모음이라면 (a,e,i,o,u)){ 카운트}
		 
		 //입력 + 처리(3) 코드 작성 {반복}{변수}
		 //if ('a'=='a'||'a'=='e'||'a'=='i'||'a'=='o'||'a'=='u'){Count++;}
		 //if ('b'=='a'||'b'=='e'||'b'=='i'||'b'=='o'||'b'=='u'){Count++;}
		 //if ('c'=='a'||'c'=='e'||'c'=='i'||'c'=='o'||'c'=='u'){Count++;}
	     System.out.print("모음 : ");
	     //입력+처리
	     for (char ch = 'a'; ch <= 'z'; ch++) {
	            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
	            {System.out.print(ch + " ");Count++;}}
	     //출력
	        System.out.println(); 
	        System.out.println("소문자 a~z까지 모음의 갯수 > " + Count);
	    }
	}

