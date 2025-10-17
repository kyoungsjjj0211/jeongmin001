package com.company.bocksub;
//다음 인터페이스를 확인하고 두가지의 방법으로 구현하시오

interface InterC2{String hi();}
interface  Ex2{  void print(String s);     }

//(1) 익명객체
//Interface InterC2{String hi();}






//(2) 람다식


//Ex2)  다음 인터페이스를 확인하고 다음과 같이 나오게 람다식을 구현하시오
  // (String s)-> x

public class wpwt {
	public static void main(String[] args) {
		InterC2 c = new InterC2() {
			@Override public String hi() { return "Good :Day"; } 
		};  
		System.out.println( c.hi() );
		
		InterC2 c2 = ()->{return "Good : Day";};
		System.out.println( c2.hi() );

		InterC2 c3 = ()->"Good : Day";
		System.out.println( c3.hi() );
		

		Ex2 ex4=(s)->System.out.println(s);
		ex4.print("lambda:)");
		
		Ex2 ex5=System.out::println;  
		ex5.print("lambda:)");

	}
}
