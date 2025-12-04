package com.company.java015;
///////////////////////////////////////
interface InterA2{void hi();}
interface InterB2{void hi(String name);}
interface InterC2{String hi();}
interface InterD2{String   hi(int num , String name); }
///////////////////////////////////////
public class Lambda002 {
	public static void main(String[] args) {
		System.out.println("\n\n[STEP1] 매개변수 X, 리턴값 X"); // InterA2
		//1-1. 익명객체 hi출력
		InterA2 a = new InterA2() {
			@Override public void hi() {System.out.println("hi");}
		}; a.hi();
		
		//1-2. 람담식 ()->{}
		InterA2 a2 = () ->{System.out.println("hi2");}; a2.hi();
		InterA2 a3 = () -> System.out.println("hi3"); a3.hi(); //처리할 일이 한줄 {}생략가능

		
		//interface InterB2{void hi(String name);}
		System.out.println("\n\n [STEP2] 매개변수 O, 리턴값 X");
		//2-1. 익명객체 hi sally!출력
		InterB2 b = new InterB2(){
			@Override public void hi (String name) {System.out.println("hi!" + name);}
		}; b.hi("sally");
		//2-2. 람다식 ()->{} //공통된 부분 다 빼기
		 InterB2 b2 = (String name) -> {System.out.println("hi!" + name);}; b2.hi("alpha");
		 InterB2 b3 = (name) -> {System.out.println("hi!" + name);}; b3.hi("buja");
		 InterB2 b4 = name -> System.out.println("hi!" + name); b4.hi("빨강이");
			
		 
		 //interface InterC2{String hi();}
		 System.out.println("\n\n[STEP3] 매개변수 X, 리턴값 O");
		 InterC2 c= new InterC2() {
			 @Override public String hi() {return "Good :Day";}
		 };
		 System.out.println(c.hi() );
		 
		 InterC2 c2 = ()->{return "Good :Day~!";};
		 System.out.println(c2.hi());
		 InterC2 c3 = ()->  "Good :Day~!"; System.out.println(c2.hi());
		 
		//interface InterD2{  String   hi(int num , String name); }
			System.out.println("\n\n[STEP4] 매개변수O , 리턴값 O"); 
			//4-1. 익명객체  
			InterD2 d = new InterD2() {
				@Override public String hi(int num, String name) { 
					String star = "";
					for(int i=0; i<num; i++) { star+= "★";}
					return "hi "+ name + star;
				} 
			};
			System.out.println(d.hi( 1, "sally" ));  //hi sally ★ 
			System.out.println(d.hi( 2, "sally" ));  //hi sally ★★   
			
			//4-2. 람다식  ()->{}
			InterD2 d2 = (int num, String name)->{  
				String star = "";
				for(int i=0; i<num; i++) { star+= "★";}
				return "hi "+ name + star;
			};
			System.out.println(d2.hi( 3, "alpha" ));  //hi alpha ★★★  
			System.out.println(d2.hi( 4, "alpha" ));  //hi alpha ★★★★  
			 
			InterD2 d3 = (  num,   name)->{  
				String star = "";
				for(int i=0; i<num; i++) { star+= "★";}
				return "hi "+ name + star;
			};
			System.out.println(d3.hi( 5, "buja" ));  //hi alpha ★★★  
			System.out.println(d3.hi( 6, "buja" ));  //hi alpha ★★★★  
			
	}
}
	


