package com.company.java012_Ex;
/*
Object
  ↑
Parent7  int x=100, method() -> "Parent Method"
  ↑
Child7 	 int x= 200, method() -> "ChildMethod"
*/
//Q1. 상속도 그리기
//Q2. 각클래스에서 사용할수있는 멤버변수/멤버메서드
//A. Parent7 x=100   method() -> "Parent Method"
//A. Child7 x=200  method() -> @"Child Method"
class Parent7  extends Object{
	   int x = 100;
	   public Parent7() { super(); }
	   void method() { System.out.println("Parent Method"); }
	} 
	class Child7 extends Parent7 {
	   int x = 200;
	   public Child7() { super(); }
	   @Override  void method() { System.out.println("Child Method"); }
	}
	
	
	
public class PolyEx005 {
	public static void main(String[] args) {
	      Parent7 p = new Child7();     
	      // Q3.  Parent7 p   보장하는 범위   A. x-100, @method() "Child Method"
	      // Q4. 인스턴스화 했을때 사용가능한 범위 : new Child7()  A. x = 200 @method() → "Child Method" - x = 100 , -------
	      
	                            Child7 c = new Child7();     
	      System.out.println("p.x = " + p.x);  // Q5. 출력되는 내용  A. p.x = 100
	      p.method();  // Q6. 출력되는 내용       					  A. Child Method
	      System.out.println("c.x = " + c.x);   // Q7. 출력되는 내용 A. c.x = 200
	      c.method();   // Q8. 출력되는 내용   						  A. Child Method
	      //Q9. main 에서 부모메서드 호출하기 ? ((Parent7)p).method(); //x 어버라이딩 된 메서드를 직접호출하는건 불가능
	      ((Parent7)p).method();//x 오버라이딩 된 메서드를 직접호출하는건 불가능
	      c.papaMethod(); // 자식에서 부모호출가능
	      ((Child7)p).papaMethod(); //타입캐스팅 - 부모가 자식메서드 호출가능 ( 자식생성자 호출시)
	   }
}

