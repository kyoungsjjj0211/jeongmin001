package com.company.java008_Ex;

public class MethodEx002 {
	public static void test1(int a) {System.out.print(a);}
	public static void test2(double a) {System.out.print(a);}
	public static void hap(int a,int b) {
		int total=0;
		for(int i=a; i<=b; i++) {total +=i;} 
		//total =+3;
		//total =+4;
		//total =+5;
		//a~b까지 더한값
		System.out.println(total);}
	
	public static void disp(int num, char ch) {//받은숫자만큼 문자 출력
		for(int i=0; i<num;i++) {System.out.println(ch);}
	}
	//public static void hap(int a, int b) {int sum = 0;for (int i = a; i <= b; i++) {sum += i;}System.out.println(sum);}
	//public static void disp(int count, char ch) {for (int i = 0; i < count; i++) {System.out.print(ch);}}
	public static void line() {System.out.println();}
	
		
	
	
	
	
	
	public static void main(String[] args) {
		test1(10);
		line();
		test2(1.2);
		line();
		hap(3,5);
		hap(1,10);
		disp(7,'*');
	}

}
