package com.company.java012_Ex;
/*
		Object    		 
		  ↑				
		TestA2 (int a ,  toString)
		  ↑           
		TestB2 (int b ,  toString)
*/
//Q1. 상속도를 그리시오.
class Object{}

class TestA2 extends Object{
	int a=10; 
	@Override public String toString() {return "TestA2 [ a=" + a + "]"; }
}
class TestB2 extends TestA2{
	int b=20;
	@Override public String toString() {return "TestB2 [ b=" + b + "]"; } 
}
public class PolyEx001 {

	public static void main(String[] args) {
		TestA2 ta = new TestB2(); 
		//Q2. 22번째 줄에서 TestA2 ta는 클래스의 무엇을 사용할수 있는지 코드의 의미 //A. TestA2{a=10 / toString} -> 부모 "TestA2 [ a=" + a + "]" - > 출력은 자식"TestB2 [ b=" + b + "]"
		//Q3. 22번째 줄에서 TestB2()는 클래스의 무엇을 사용할 수 있을까요? // int b= 20, @toString
		//A. TestB2 {b=10/@toString} - TestA2 {a=10/------}
		//A. ta[1000번지] = 1000번지 TestB2 { b=20/@toString} - TestA2{a=10/------}
		System.out.println(ta); // Q4. 출력내용은? TestA2 vs TestB2 // 출력 : TestB2
		System.out.println(ta.a); // Q5. 사용가능?  //사용가능 
		//System.out.println(ta.b); // Q6. 사용가능? //사용불가능 (((TestB2)ta).b) <- 감싸주었을떄 사용 가능?
	}

}
