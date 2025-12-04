package com.company.bank5_interface;

import java.util.List;

public class Show implements BankController{


	@Override
	public int exec(List<UserInfo> users, int find) {
		/*
		UserInfo info = users.get(find);
		System.out.println("ID> " + info.getId());
		System.out.println("PASS> " + info.getPass());
		System.out.println("BALANCE> " + info.getBalance());
		
		*/
		if (find < 0 || find >= users.size()) {
            System.out.println("조회 실패: 유효하지 않은 사용자입니다.");
            return -1;
        }

        UserInfo user = users.get(find);

        System.out.println("🔍 [계좌 조회]");
        System.out.println("🆔 아이디: " + user.getId());
        System.out.println("🔐 비밀번호: " + user.getPass());
        System.out.println("💰 현재 잔액: " + user.getBalance() + "원");

        return find;
    }
}
//user.add(new UserInfo("id" , "pw" , 1))
//user.get(0) 0번째 유저
//user.size() 유저의 갯수
//user.remove(0) 0번째유저 삭제