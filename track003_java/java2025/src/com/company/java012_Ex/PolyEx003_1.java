package com.company.java012_Ex;
/*
 Object ■3.)                      ■4.)
 	↑
 TestA4 ■2.) {a=10 / -------}     ■5.)
 	↑
 TestB4 ■1.) {b=20 / @toString}   ■6.)
 */
//Q1. 상속도를 그리시오. 
/*class TestA4  extends Object{  
 int a=10;
 @Override public String toString() { return "TestA4 [a=" + a + "]"; }
}
class TestB4  extends TestA4{  
 int b=20;
 @Override public String toString() { return "TestB4 [b=" + b + "]"; }
}
*/
public class PolyEx003_1 {
	public static void main(String[] args) {
	      TestA4  ta = new TestA4();
	      //Q2. TestA4  ta 사용할수 있는범위는? int a=10, toString 
	      //Q3. new TestA4() 는  heap area 에서 호출되는 생성자의 순서와 객체가 만들어지는 순서는?
	      // 생성자 호출 : Test A4 → Object , 객체 : 4→5  
	      TestB4  tb = new TestB4();  
	      //Q4. TestB4  tb 사용할수 있는범위는?  int a=10, toString, int b=20 ,  toString
	      //Q5. new TestB4() 는  heap area 에서 호출되는 생성자의 순서와 객체가 만들어지는 순서는?
	      // 생성자 호출 : TestB4 → TestA4 → Object ,객체 4→5→6 


	      // ■부모 =자식 / 업캐스팅 / 타입캐스팅 불필요(X)
	      ta = new TestB4();
	      //Q6. ta가 사용할수 있는 보장하는 변수와 메서드는? int a=10,toString  
	      //Q7. ta = new TestB4(); 에서 new TestB4() 에서 사용할수 있는 범위는?  b=20, a=10, @toString

	      // ■ 자식 = 부모 / 다운캐스팅 / 타입캐스팅 필요 (O)
	      tb         = (TestB4) ta;   
	      //Q8. tb         = (TestB4) ta;   에서 tb가 사용할수 있는 범위는? b=20,@toString , a=10 , ----- 
	      //Q9. 컴피일러시  tb         = (TestB4) ta;  오류가 안나는 이유는?  ?

	      
	      System.out.println(tb);  //Q10. 출력내용과 그이유는? TestA4  vs  TestB4 TestB4 
	      System.out.println(tb.b);//Q11. 출력내용? 20
	      System.out.println(tb.a);//Q12. 출력내용? 10
	   
	}
}
