package com.company.java010;

//public (아무데서나) > protected(extends) > default(같은폴더내에서만) > private(클래스안에서만)


class UserSon1 extends UserInfo{
	public void show() {
		System.out.println("홍길동 아버지 이름 > " + super.name); 			// 자식 - public
		System.out.println("홍길동 아버지 금고번호 > " + super.safeCode);		// 자식 - protected
		System.out.println("홍길동 아버지 집 > " + super.house);			// 자식 - package (같은폴더에서)
		//System.out.println("홍길동 아버지 iQ > " + super.iQ);
		System.out.println("홍길동 아버지 iQ > " + super.getiQ());
	}
}
//////////////////////////////////////////////////
public class Modifier001 {

	public static void main(String[] args) {
		System.out.println("\n\n1. 홍길동 아버지 정보"); // 본인 : public > protected > default > private(x)
		UserInfo user = new UserInfo();
		user.name="홍상직";  //public 아무데서나 접근 (홍길동씨 아버지)
		user.safeCode = "1234"; //protected 본인꺼 접근가능
		user.house = "";
		user.setiQ(148);
		System.out.println(user.getiQ());

	}

}
//////////////////////////////////////////////////