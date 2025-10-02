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
	
	
	public Bank_Main() {
		users 	   = new ArrayList<>();
		controller = new BankController[]{
				new Login(),new Add(), new Show(), 
				new WithDraw(),new Deposit(), new Delete()
		};
	}
	//멤버함수 (메뉴판)
	public void menu() {
		Scanner scanner = new Scanner(System.in);
		for(;;) {
			System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
					+ "		 [1] ➕ 계좌 추가\r\n"
					+ "		 [2] 🔍 계좌 조회\r\n"
					+ "		 [3] 💵 입금하기\r\n"
					+ "		 [4] 💸 출금하기\r\n"
					+ "		 [5] 🗑️ 계좌 삭제\r\n"
					+ "		 [9] ❌ 종료\r\n"
					+ "		 \r\n"
					+ "		 👉 번호를 선택하세요:");
		
			int num=scanner.nextInt();
			if(num==9){System.out.println("[9] ❌ 종료"); break;}
			else if (num==1) { controller[1].exec(users);}//add class
			else if(num==2 || num==3 || num==4 || num==5){
				 controller[0].exec(users);
			 switch (num) {
			 case 2 : System.out.println("[2] 🔍 계좌 조회");
			 controller[2].exec(users);
			 break;
			 case 3 : System.out.println("[3] 💵 입금하기");
			 controller[3].exec(users);
			 break;
			 case 4 : System.out.println("[4] 💸 출금하기");
			 controller[4].exec(users);
			 break;
			 case 5 : System.out.println("[5] 🗑️ 계좌 삭제");
			 controller[5].exec(users);break;
			 
				 
			
			 }
			 
			 
			 
			 
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
	}
	public static void main(String[] args) {
		new Bank_Main().menu();
	}

}
