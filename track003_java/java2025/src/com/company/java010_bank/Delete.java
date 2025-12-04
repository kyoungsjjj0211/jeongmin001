package com.company.java010_bank;

public class Delete {
	UserInfo userinfo;
	public Delete() {super();}
	public Delete(UserInfo userinfo) {
		super();
		this.userinfo = userinfo;
	}
		public void exec() {
			this.userinfo.setId(" ");
			this.userinfo.setPass(" ");
			this.userinfo.setBalance(0);
			System.out.println("정보를 삭제했습니다.");
			
			//setter / getter 이용해서 유저정보삭제 초기화 ###
			//setter / getter 이용해서 사용자에게 출금받기 ###
			//변수
			//입력 - 
			//처리 - setter를 이용해서 이름null, 비번null, 잔액0 으로
			//출력 - 정보를 삭제했습니다 출력
		
	}
}
/* 기능 : 유저정보삭제, 초기화
*/