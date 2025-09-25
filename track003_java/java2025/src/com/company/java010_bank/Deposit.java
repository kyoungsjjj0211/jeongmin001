	package com.company.java010_bank;

import java.util.Scanner;

public class Deposit {
	 //상태 : 멤버변수
		UserInfo userinfo;
		
		public Deposit() {super();}
		public Deposit(UserInfo userinfo) {
			super();
			this.userinfo = userinfo;
		}
	
	
		public void exec() {
			   Scanner scanner = new Scanner(System.in);
			    System.out.print(" 입금할 금액을 입력하세요 > ");
			    double balance = scanner.nextDouble();
			    //double currentBalance = this.userinfo.getBalance();
			    //double newBalance = currentBalance + balance;
			    this.userinfo.setBalance(this.userinfo.getBalance() +balance);

			    System.out.println(" 입금이 완료되었습니다.");
			    System.out.println(" 현재 잔액: " + this.userinfo.getBalance());
			//setter / getter 이용해서 사용자에게 입금받기 ###
			//변수
			//입력 -사용자에게 입금할 금액입력받기
			//처리 -setter을 이용해서 입금한 금액 셋팅하기
			//출력 -입금이 완료되었습니다 출력
			
		}
	}
	
	/*기능 : 사용자에게 입금받기*/