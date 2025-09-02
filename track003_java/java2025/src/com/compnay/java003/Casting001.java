package com.compnay.java003;

public class Casting001 {
	public static void main(String[] args) {
		//#1. 형변환 - 자동타입변환
		// byte < short < int < long < float < double
		byte by = 1;
		short sh = 2;
		int i = 4;
		long l = 8L;
		float f = 3.14f;
		double d = 3.14;
		boolean bl = true;
		sh = by; // 정수(2byte) = 정수(1byte)
		i = by; // 정수(4byte) = 정수(1byte)
		l = by; // 정수(8byte) = 정수(1byte)
	//  l  = f; // 정수(8byte) = 실수(4byte)  정수<실수 
				// - Type mismatch:cannot convert from float to long 
				// - Line breakpoint:Casting001 [line: 17] - main(String[])
		
		f = l; // 실수(4byte) = 정수(8byte)   정수 < 실수
	// 	i = bl; // boolean 빼고 형변환 가능
				// Type mismatch:cannot convert from boolean to int
		
		//#2. 형변환 - 강제타입변환
		// by = i; // 정수인지 실수인지 판단, 정수(1byte) - 정수(4byte) 해결 방법 ↓
		by = (byte) i; 
		
		int i2 = (int) 1.2;  // 정수(4byte) - 실수(double-8byte)
		float f2 = (float) 1.2; // 정수(4byte) - 실수(double-8byte)
		
		//Q1) System.out.println (1.5+2.7); 3으로 나오게 만들기
		
		System.out.println( 1.5 + 2.7 );
		System.out.println( (int) 1.5 + (int) 2.7 ); // 형변환 이용
		
	}

}
