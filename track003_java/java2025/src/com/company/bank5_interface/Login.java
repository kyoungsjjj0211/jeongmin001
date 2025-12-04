package com.company.bank5_interface;

import java.util.List;
import java.util.Scanner;

public class Login implements BankController{


	@Override
	public int exec(List<UserInfo> users, int find) {
		//변수
		Scanner scanner = new Scanner(System.in);
		//입력
        System.out.print("🆔 아이디 입력: "); String tempId = scanner.nextLine();
        System.out.print("🔐 비밀번호 입력: "); String tempPass = scanner.nextLine();
        //처리
        // 내가 입력받은 아이디와 유저 0번째 user.get(0)의 아이디 , 0번이 유저번호
        // if (내가 입력받은 아이디와 유저 1번째 user.get(1)의 아이디) { 1번이 유저번호}
        // if (내가 입력받은 아이디와 유저 1번째 user.get(1)의 아이디) { 1번이 유저번호}
        // ver-2
        // System.out.print("🆔 아이디 입력: "); String tempId = scanner.next();
        // System.out.print("🔐 비밀번호 입력: "); String tempPass = scanner.next();
        // for(int i=0; i<users.size(); i++){
        // if(tempid.equals(users.get(i).getId() ) && temppass.equals(users.get(i).getPass()) ){
        // return i;} } return -1;}
        //출력
        for (int i = 0; i < users.size(); i++) {
            UserInfo user = users.get(i);
            if (user.getId().equals(tempId) && user.getPass().equals(tempPass)) {
                System.out.println("✅ 로그인 성공!");
                return i;
            }
        }

        return -1; 
		
	}

}
