package com.company.java012;



/*
1. 클래스는 부품객체		2. 상태와 행위		 3. 상속은 재활용 
		Object    		 
		  ↑				
		TestA4 (int a, toString)
		  ↑           
		TestB4 (int b, toString)
*/
class TestA4 extends Object{
	int a=10;
	@Override public String toString() {return "TestA4 [a="+ a + "]";}
}
class TestB4 extends TestA4{
	int b=10;
	@Override public String toString() {return "TestB4 [b="+ b + "]";}
}
////////////////////////////////////////////////////////
public class Poly004 {

	public static void main(String[] args) {
		TestA4 ta = new TestA4();
		//1. ta : {int a , toString} = {int a, toString} - {}
		TestB4 tb = new TestB4();  // TestB4() - TestA4() - Object()
		//2. tb : {int b, @toString}--{int a, ------}
		//              =2000번지 {int b, @toString}--{int a, -------}
		ta = new TestB4();//5. 부모에 자식을 담은적이 있어야 한다.
						 // 부모 =  자식 / 업캐스팅 / 타입캐스팅 X11
		// ta : {int a, toString} = 3000번지 {int b, @toString} -- {int a, -------}
		tb        = (TestB4) ta; //4. 자식 = 부모 / 다운캐스팅 / 타입캐스팅 O
		//3. tb : {int b, @toString}--{int a, ------}
		// 								=3000번지 {int b, [@toString} -- {int a], -------}
		
		System.out.println(tb);
		System.out.println(tb.b);
		System.out.println(tb.a);
	}
}
////////////////////////////////////////////////////////