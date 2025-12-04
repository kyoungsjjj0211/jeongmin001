package com.company.java010_bank;

import java.util.Scanner;

public class Widthdraw {
	UserInfo userinfo;
	
	public Widthdraw() {super();}
	public Widthdraw(UserInfo userinfo) {super(); this.userinfo = userinfo;}


	
		public void exec() {
			Scanner scanner = new Scanner(System.in);
	        System.out.println("출금할 금액을 입력해주세요 > ");
	        double temp = scanner.nextDouble();

	        double Balance = this.userinfo.getBalance();

	        if (temp <= 0) {
	            System.out.println("❌ 출금 금액은 0보다 커야 합니다.");
	        } else if (temp > Balance) {
	            System.out.println("❌ 잔액이 부족합니다. 현재 잔액: " + Balance + "원");
	        } else {
	            this.userinfo.setBalance(Balance - temp);
	            System.out.println("✅ 출금이 완료되었습니다. 남은 잔액: " + this.userinfo.getBalance() + "원");
	        }
	    }
	}
		
			/*Scanner scanner = new Scanner(System.in);
			System.out.println("출금할 금액을 입력해주세요 > ");
			double output = scanner.nextDouble();
			this.userinfo.setBalance(this.userinfo.getBalance() - output);
			System.out.println("출금이 완료되었습니다.");
			}
			}
			*/
			//setter / getter 이용해서 사용자에게 출금받기 ###
			//변수
			//입력 - 사용자에게 출금할 금앱 입력받기
			//처리 - setter를 이용해서 출금한 금액 셋팅하기
			//출력 - 출금이 완료되었습니다. 출력
	

	

/* 기능 : 사용자에게 출금받기
*/