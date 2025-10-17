package com.company.java015_labmda_stream;

interface  RInterC2{  String hi(); }          // 파라미터x, 리턴O  - ()->{return}
interface  REx2{  void print(String s);     } // 파라미터o, 리턴x  - (s)->{ x } 

public class RepeatLambda {
	public static void main(String[] args) {
		//1-1. 익명객체 (1회성)
		RInterC2  ex1 = new RInterC2() {
			@Override public String hi() { return "Good :Day"; }
		};  
		RInterC2  ex2 = new RInterC2() {  //
			@Override public String hi() { return "Good :Day"; }
		};  
		System.out.println(  ex1.hi() );
		
		//1-2. 람다  ()->{}
		RInterC2 ex3 = ()->{return  "Good :Day";   };
		System.out.println(  ex3.hi()  );
		
		//2. 
		//REx2  ex4 = (s)->{ System.out.println(s); };
		REx2  ex4 = System.out::println;   // 어떤클래스의 , 어떤메서드
		ex4.print("Good :Day");
	}
}


 
//Ex1)  다음 인터페이스를 확인하고 두가지의 방법으로 구현하시오
//```
//interface InterC2{  String hi(); }
//```
//1) 익명객체
//2) 람다식
//
//```answer 
//```
//
//
//Ex2)  다음 인터페이스를 확인하고 다음과 같이 나오게 람다식을 구현하시오
//interface  Ex2{  void print(String s);     }  // (String s)-> x
//
//```answer 
//``` 