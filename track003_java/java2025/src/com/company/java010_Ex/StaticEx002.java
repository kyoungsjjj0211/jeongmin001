package com.company.java010_Ex;

//1. 클래스는 부품객체
//2. 클래스는 상태와 행위
class Mobile2{
	//상태 : 멤버변수
	String serialNo; // 인스턴스변수, heap area, new O, this, 생성자 O
	static int count=0; // 클래스변수 , method , new X, this X, 생성자 X 지금당장바로~!
	// 행위 : 멤버함수
	public Mobile2() {
		//객체를 한개씩 만들때마다 serialNo에 / 숫자를 한개씩 증가시키는데 ++count
		this.serialNo = "2030-" + ++count;
	}
}


public class StaticEx002 {

	public static void main(String[] args) {
		   Mobile2 m1 = new Mobile2(); //1. new 공간빌리기 2. 생성자() 3. 번지
		   Mobile2 m2 = new Mobile2(); 
		   Mobile2 m3 = new Mobile2();  
		   Mobile2 m4 = new Mobile2();  

		   System.out.println("모바일 갯수는 모두 "+ Mobile2.count +"개 입니다."); // 클래스명.변수 클래스변수 ◆ 4   
		   System.out.println("m1의 제품번호 " + m1.serialNo);  //1 m1(1번지).변수명   ◆   2030-1
		   System.out.println("m2의 제품번호 " + m2.serialNo);  //2 m2(2번지).변수명   ◆   2030-2
		   System.out.println("m3의 제품번호 " + m3.serialNo);  //3
		   System.out.println("m4의 제품번호 " + m4.serialNo);  //4

	}

}
/*연습문제2)  static
패키지명 : com.company.java010_ex
클래스명 :  StaticEx002
-- class Mobile2   작성해주세요    


class Mobile2{  
      String   serialNo;
      static  int count=0; 
} 

public class StaticEx002{
  public static void main(String[] args) {
     Mobile2 m1 = new Mobile2(); //1. new 공간빌리기  2. 생성자()  3. 번지
   Mobile2 m2 = new Mobile2(); 
   Mobile2 m3 = new Mobile2();  
   Mobile2 m4 = new Mobile2();  

   System.out.println("모바일 갯수는 모두 "+ Mobile2.count +"개 입니다.");   
   System.out.println("m1의 제품번호 " + m1.serialNo);  //1
   System.out.println("m2의 제품번호 " + m2.serialNo);  //2
   System.out.println("m3의 제품번호 " + m3.serialNo);  //3
   System.out.println("m4의 제품번호 " + m4.serialNo);  //4
  }
}

출력된결과:
모바일 갯수는 모두 4개 입니다.
m1의 제품번호 2030-1
m2의 제품번호 2030-2
m3의 제품번호 2030-3
m4의 제품번호 2030-4
*/