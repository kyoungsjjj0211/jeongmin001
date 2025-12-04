package com.company.java010_bank;

import java.util.Scanner;

public class Login {
	UserInfo userinfo;

	public Login() {super();}
	public Login(UserInfo userinfo) {
		super();
		this.userinfo = userinfo;
	}
	public int exec() {
		Scanner scanner = new Scanner(System.in);
		//setter / getter 이용해서 유저정보 확인
		//변수
		int find=-1;
		
		//입력-사용자에게 아이디입력받기 /비밀번호 입력받기
		System.out.println("아이디를 입력해주세요 : ");
		String tempid = scanner.nextLine();
		
		System.out.println("비밀번호를 입력해주세요 : ");
		String temppass = scanner.nextLine();
		
		//return tempid.equals(this.userinfo.getId()) && temppass.equals(this.userinfo.getPass());


				

		//처리-입력한 아이디와 userinfo.id가 같고 입력한 비밀번호와 userinfo.pass가 같다면 find=1; 찾으면 1
		if(tempid.equals(userinfo.getId()) && temppass.equals(userinfo.getPass())) {
			System.out.println("로그인되었습니다.");
			find=1;
		}
		else{System.out.println("로그인에 실패하였습니다.");}
	//출력 - 
		return find;
	}
}

/*기능 : 유저정보 확인
*/