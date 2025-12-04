package com.company.bank5_interface;

import java.util.List;
import java.util.Scanner;

public class Deposit implements BankController {
	@Override
	public int exec(List<UserInfo> users, int find) {
		//Deposit : user.get(유저번호)
		//변수
		Scanner scanner = new Scanner(System.in);
		//입력-금액입력받기
		System.out.println("입금할 금액을 입력 > "); double balance = scanner.nextDouble();
		//처리-해당유저의 금액에 추가
		UserInfo u= users.get(find);
		u.setBalance(u.getBalance() + balance);
		//출력 - 입금이 완료되었습니다.
		System.out.println("입금이 완료되었습니다. >" + u);
		return 0;
	}

}
/*  
 
 내가 작성한 코드
	@Override
	public int exec(List<UserInfo> users, int find) {
		//처리
		//출력
		Scanner scanner = new Scanner(System.in);
		 
            System.out.println("입금 : "); double balance= scanner.nextDouble();
            
            balance = scanner.nextDouble(); balance1 += balance;
            System.out.println("==입금완료");
            System.out.println("잔액 : " + balance1);
        }
		return 0;
	}
	 

	private boolean checkCredentials(int find, List<UserInfo> users) {
		return false;
	}
}
	
*/