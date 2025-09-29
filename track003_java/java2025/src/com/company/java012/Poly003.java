package com.company.java012;


/*
1. 클래스는 부품객체		2. 상태와 행위		 3. 상속은 재활용 
		Object    		 
		  ↑				
		TestA3 (int a, toString) 
		  ↑           
		TestB3 (int b, toString) 
*/
class TestA3 extends Object{
	int a=10;
	@Override public String toString() {return "TestA3 [a="+ a + "]";}
}
class TestB3 extends TestA3{
	int b=10;
	@Override public String toString() {return "TestB3 [b="+ b + "]";}
}
///////////////////////////////////////////////////
public class Poly003 {
	public static void main(String[] args) {
		//자식 = 부모  다운캐스팅
		TestB3 tb = (TestB3) new TestA3();
		// 1. TestB3 tb 범위 : TestB3{int b, toString} - TestA3{int a, toString}
		// 2. TestA3() 는  {int a, toString}만 처리
		// 3. TestB3{int b, toString} 보장안됨.
		// 보장{int b, toString} - {int a, toString} (1번지) 
		//											= 1번지{int a, toString}
		// 생성자 호출한적이 없기에 사용불가능
		// TestB3 tb = (TestB3) new TestA3(); - Type mismatch: cannot convert from TestA3 to TestB3
		/* Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
			Cannot cast from TestA3 to TestB3 at com.company.java012.Poly3.main(Poly3.java:22) */
		
		}
}
///////////////////////////////////////////////////