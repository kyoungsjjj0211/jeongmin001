package com.company.java005_ex;

public class ForEx004_2 {
	public static void main(String[] args) {
		
		//변수
		int count = 0; 
		System.out.print("3의배수 : ");
		
		//입력 + 처리
		 //입력 + 처리
	    //sum변수에 담기
	    //sum = sum+1; // sum[1] 0+1
	    //sum = sum+2; // sum[3] 1+2
	    //sum = sum+3; // sum[6] 3+3
	    // {반복} {변수} for(시작;종료;변화;)
	    for (int i = 1; i <= 10; i++) {if (i % 3 == 0) {System.out.print(i); count++;
	    if (i+3<=10) {System.out.print(", ");}}}
	    
	    //출력

	    System.out.println(); 
	    System.out.println("갯수 : " + count + "개");
	}
}
	 
