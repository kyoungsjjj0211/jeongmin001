package com.company.java010;

//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)

class Farm{
	//상태 - 멤버변수
	String name; //인스턴스 변수 - heap area - new O - 생성자 / cat(1번지).name , cat(1번지).name , cat(1번지).age
	int age; 	 //인스턴스 변수 - heap area - new O - 생성자 / dog(2번지).name , dog(2번지).name , dog(2번지).age
	static String FarmName="(주) 동물농장"; //클래스.변수 - Farm.FarmName (명시적 초기화)
	static int FarmNum; // 클래스.변수 -  method area - new X - 생성자 X
	static String FarmBoss;
	static {FarmNum=2; FarmBoss="신동엽";} // 초기화블록
	

	//행위 - 멤버함수
	static void num_plus() {FarmNum++;     /* this.age++; */ } //클래스.메서드 static → this 사용불가
	
	void show() { // 인스턴스메서드
		System.out.println("\n\n::::::::::::::::::::::");
		System.out.println("::이름 : " + this.name);
		System.out.println("::나이 : " + this.age);
	}
}
////////////////////////////////////////////////////////
public class Static001 {
	
	public static void main(String[] args) {
		System.out.println("\n\n0.동물농장");
		System.out.println(":: 회사이름 > " +  Farm.FarmName);
		System.out.println(":: 회사사장 > " +  Farm.FarmBoss);
		System.out.println(":: 회사인원 > " +  Farm.FarmNum);
	
		System.out.println("\n\n1. 동물농장식구-this-각각");
		
		Farm cat = new Farm(); // 1)new : 메모리 빌리기, 객체생성  2) Farm() 초기화  3) cat 번지
		cat.name="jeong"; cat.age=3; cat.show(); // 갖고놀기 사용하기
		Farm dog = new Farm(); dog.name="alpha"; dog.age=7; /*dog.num_plus();*/ dog.show(); 
	}

}
////////////////////////////////////////////////////////
/* 초기화순서 :      기본값             명시적초기화             초기화블록             생성자
 * FarmNum          0               null               (o) 2                   X
 * FarmBoss        null             null               (o) 신동엽                X               클래스변수
 * FarmName        null           (주)동물농장            (X) (주)동물농장           X  
 //////////////////////////////////////////////////////////////////////////////////////////////
 *  cat      name=null, age=0     (x)name=null, age=0   (x)name=null, age=0     name=null, age=0      
 *  dog      name=null, age=0     (x)name=null, age=0   (x)name=null, age=0     name=null, age=0        인스턴스변수
 

------------------------[ runtime data area]
[method: 정보, static, final : 공용정보] 
	Farm.class , Static001.class  ★ 클래스 : 설계도
	FarmNum=2; FarmBoss="신동엽"; FarmName="(주) 동물농장";
------------------------------------
[heap: 동적]            | [stack : 잠깐빌리기]
2번지 {name=null, age=0} ← dog[2번지]
1번지 {name=null, age=0} ← cat[1번지]
					   | main
------------------------------------
*/