package com.company.java008;

public class Method002 {
	//(1)
	//public static 리턴값 매서드명 (파라미터) {}
	public static void myint(int a) {System.out.println(a);}
	
	public static void ten(int money) {System.out.println( money*10);}
	
	public static void add(int money,int bitcoin) {System.out.println(money + bitcoin);}
	///////////////////////////////////////
	public static void main(String[] args) {
		//(2) 사용
		//public static void myint(int a) {System.out.print(a);}
									myint(1);
									myint(2);
		//public static void myint(int money) {System.out.print(money*10);}
									ten(1);
		//public static void myint(int money,int bitcoin) {System.out.print(money+bitcoin);}
									add(100 , 20); //int money=100, int bitcoin=20
									add(200 , 30); //int money=200, int bitcoin=30
	}
	///////////////////////////////////////
}
