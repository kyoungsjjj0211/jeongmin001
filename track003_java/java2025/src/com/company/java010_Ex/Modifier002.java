package com.company.java010_Ex;

import com.company.java010.UserInfo;

class UserSon2 extends UserInfo{
	public void show() {
		System.out.println("홍길동 아버지 이름 > " + super.name); 			// 자식 - public
		System.out.println("홍길동 아버지 금고번호 > " + super.safeCode);		// 자식 - protected
		//System.out.println("홍길동 아버지 집 > " + super.house);			// 자식 - package (같은폴더에서)
		//System.out.println("홍길동 아버지 iQ > " + super.iQ);
		System.out.println("홍길동 아버지 iQ > " + super.getiQ());
		//Q super.house를 못쓰는 이유는 - UserInfo 클래스의 house는 접근자가 package (java010폴더안에서만)
		//      UserSon2클래스는 (java010_ex 폴더안에 있음.)
	}
}
//////////////////////////////////////////////////
public class Modifier002 {
	public static void main(String[] args) {
		System.out.println("\n\n1. 홍길동 아버지 정보"); // 본인 : public > protected > default > private(x)
		UserInfo user = new UserInfo();
		user.name="홍상직";  //public 아무데서나 접근 (홍길동씨 아버지)
	//	user.safeCode = "1234"; //protected 본인꺼 접근가능 Q2. 오류이유? extends 상속받은적이 없음.
	//	user.house = "";             Q3 .오류 이유? 같은폴더 아님 - java010_ex 폴더안에 있음.
		user.setiQ(148);
		System.out.println(user.getiQ());

	}

}
//////////////////////////////////////////////////