package com.company.java011_Ex;
class User002 {
	   final String nation = "Korea";   // 
	   final String jumin;              // 
	   String name;

	   public User002() { jumin = "00000"; }  // 
	   public User002(String jumin, String name) {
	      this.jumin = jumin;                 // 
	      this.name = name;
	   }
	}
public class FinalEx {
		   public static void main(String[] args) {
		      User002 user1 = new User002("123456-1234567", "아이유");
		      System.out.println(user1);   

		   // user1.nation = "USA";      
		      // X  final 변수 nation은 이미 "Korea"로 초기화되었기 때문에 변경 불가
		   // user1.jumin  = "123123-1234321"; 
		      // X final 변수 jumin은 생성자에서 이미 초기화되었기 때문에 변경 불가
		      user1.name = "IU"; 
		      System.out.println(user1);   
		   }
		}

/*
연습문제1)  final
패키지명 : com.company.java011_ex
클래스명 : FinalEx
다음코드에서 오류나는 부분을 찾아 주석달고 이유를 적으시오.
class User002 {
   final String nation = "Korea";   
   final String jumin;   
   String name;

   public User002() { jumin="00000"; }
   public User002(String jumin, String name) {
      this.jumin = jumin;
      this.name = name;
   }
}
 public class FinalEx {
   public static void main(String[] args) {
      User002 user1 = new User002("123456-1234567", "아이유");
      System.out.println(user1);   
      
      user1.nation = "USA";      
      user1.jumin  = "123123-1234321"; 
      user1.name = "IU"; 
      System.out.println(user1);   
   }
}
*/