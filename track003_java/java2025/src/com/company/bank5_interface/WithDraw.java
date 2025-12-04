package com.company.bank5_interface;

import java.util.List;
import java.util.Scanner;

public class WithDraw implements BankController{


	@Override
	public int exec(List<UserInfo> users, int find) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("💸 출금할 금액을 입력하세요: "); double balance = scanner.nextDouble();
		 UserInfo u = users.get(find);
		 u.setBalance(u.getBalance() - balance);
		 System.out.println("출금이 완료되었습니다 > " +  u);
		 return 0;
		 /*
		 내가 작성한 코드
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("💸 출금할 금액을 입력하세요: "); double balance = scanner.nextDouble();
		 
		 UserInfo user = users.get(find); double withdraw = user.getBalance();
		 user.setBalance(withdraw - balance);
		 */
		
	}

}