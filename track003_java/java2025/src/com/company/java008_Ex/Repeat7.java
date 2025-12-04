package com.company.java008_Ex;

public class Repeat7 {

		public static int add(int x, int y) {return x+y;}
		
		public static int add(byte a,byte b) {return a+b;}
		
		public static int add(short a, short b) {return a+b;}
		
//		public static long add(int a, int b) {return a+b;}
	//  ↓	
//변환 후 public static long add(float a, int b) {return (int)a+b;}
		
		public static long add(long a, long b) {return a+b;}
		
		public static void main(String[] args) {
			
			// public static long add(int a, int b) {return a+b;} 
			// int라는 파라미터 자료형이 같기 때문에 하나는 float 하나는 int형으로 바뀌어야한다.

	}

}
