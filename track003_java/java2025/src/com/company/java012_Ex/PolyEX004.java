package com.company.java012_Ex;
/*
Object
  ↑
Papa (money=10000, sing() → GOD-거짓말)
  ↑
Son  (money=1500, sing() → 빅뱅-거짓말)
 */

//Q1. 상속도 그리기
//Q2. 각클래스에서 사용할수있는 멤버변수/멤버메서드
//A : PAPA /Money=10000 /sing("God-거짓말")
//A : Son / Money=1500 /sing("빅뱅-거짓말")

class Papa extends Object{
	
int money = 10000;     
public Papa() { super(); }
public void sing() {  System.out.println("GOD-거짓말");  }
}// end class

class Son extends Papa{ 
int money = 1500;
public Son() { super(); }
@Override public void sing() {  System.out.println("빅뱅-거짓말"); }
} // end class

public class PolyEX004 {
	public static void main(String[] args) { 
	      Papa mypapa = new Son();    
	      // Q3. Papa mypapa 의미? // money =10000 ,toString("GOD-거짓말")
	      // Q4. 인스턴스화한 실제 메모리 빌려온그림  
	      //mypapa [1000번지] = 1000번지 Son {money=1500, sing="빅뱅-거짓말" } - papa{money=10000 , sing = -------}
	      System.out.println(mypapa.money); // Q5.  출력    A. 10000
	      mypapa.sing();  //Q6. 출력  A.빅뱅-거짓말
	       //Q7. mypapa.money 를 이용해서  1500 출력되게 해주세요. A. (((Son)mypapa).money) 
	}

}