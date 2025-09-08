package com.company.java005_ex;

public class ForEx005_2 {
	 public static void main(String[] args) {
	     //변수   
		 int Count = 0;
	        
	     System.out.print("모음 : ");
	     //입력+처리
			for (char ch = 'a'; ch <= 'z'; ch++) {
				switch (ch) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					System.out.print(ch);
					Count++;
					break;
				}}
	     //출력
	        System.out.println(); 
	        System.out.println("갯수 : " + Count + "개");
	 }
}
	

