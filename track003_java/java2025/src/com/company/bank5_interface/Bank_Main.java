package com.company.bank5_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank_Main {
	
	String id = null, pass = null, id1, pass1, n=null;
	double balance = 0, balance1 =0, bal =0,  bal1 = 0;
	//멤버변수
	private List<UserInfo> users;
	private BankController[] controller;
	
	//생성자 - 멤버변수를 초기화해서 사용가능하게
	public Bank_Main() {
		users 	   = new ArrayList<>();
		controller = new BankController[]{
				new Login(),new Add(), new Show(), 	new Deposit(),new WithDraw(), new Delete()
		};// controller[0]      1          2                 3              4            5
	}
	//멤버함수 (메뉴판)
	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int num=-1;
		while(num !=9) {
			System.out.println(users); // 테스트용도
			System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n" + "		 [1] ➕ 계좌 추가\r\n" + "		 [2] 🔍 계좌 조회\r\n" + "		 [3] 💵 입금하기\r\n" + "		 [4] 💸 출금하기\r\n" + "		 [5] 🗑️ 계좌 삭제\r\n" + "		 [9] ❌ 종료\r\n" + "		 \r\n" + "		 👉 번호를 선택하세요:");
			num=scanner.nextInt();
			
			
			int find=1; // 찾은 유저번호 or 0 로그인 or 1
			//add, get(번호), size, remove(번호), contains()
			//추가 :
			//Add : controller[1].exec(users); -        users.add(new UserInfo]("id", "pw", 1));
			//Show : user.get(사용자 번호)
			//Deposit : user.get(사용자 번호) / 찾은유저.setBalance(입금받은돈)
			//Delete : user.remove(번호)
			//1. 파라미터 user, 사용자 번호 
			//2. 리턴값은  유저 번호
			//3. int (유저 번호) exec(user, 사용자 번호)
			//
			if(num >=2 && num <=5) {find=controller[0].exec(users , 0);} 
			controller[num].exec(users, find);
			
			
			 
		}
		
	}
		
			
		//변수
		//입력 + 처리
		
		/*
		 🌟💰 WELCOME TO BANK SYSTEM 💰🌟
		 [1] ➕ 계좌 추가
		 [2] 🔍 계좌 조회
		 [3] 💵 입금하기
		 [4] 💸 출금하기
		 [5] 🗑️ 계좌 삭제
		 [9] ❌ 종료
		 
		 👉 번호를 선택하세요:
		 
		 Q1. 무한반복 + 각번호 입력받으면 ~기능입니다 출력
		 Q2. 입력받은 번호가 1번이면 유저추가
		 Q3. 입력받은 번호가 2,3,4,5 이면
		 while(9가 아니라면 계속하기){
		 	if(입력받은 번호가 1번이면){유저추가}
		 	else if(9면){종료구문추가}
			1) Login
			2) 2,3,4,5 각각에서 처리해야할일
		*/
	
	public static void main(String[] args) {
		new Bank_Main().menu();
	}

}
