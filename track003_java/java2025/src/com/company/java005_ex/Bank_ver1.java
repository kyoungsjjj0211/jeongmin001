package com.company.java005_ex;

import java.util.Scanner;

public class Bank_ver1 {
	public static void main(String[] args) {
		// 변수  // null = ""
		int num, year = 0;
		 
		String id = null, pass = null, id1, pass1, n=null;
		double balance = 0, balance1 =0, bal =0,  bal1 = 0;
		Scanner scanner = new Scanner(System.in);
		// 입력+처리+출력

		for (;;) {
			System.out.println("======BANK======\n*" + " 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료\n입력 >>> ");
			num = scanner.nextInt();

			System.out.println();
			switch (num) {
			case 1:
				System.out.println("* 1 추가기능입니다");
				//아이디 입력 > _입력받기
				//비밀번호 입력 > _입력받기
				//나이 입력 > _입력받기
				//잔액 입력 > _입력받기
				//변수
				
				//입력
				System.out.println("아이디 입력");
				id = scanner.next();
				System.out.println("비밀번호 입력");
				pass = scanner.next();
				System.out.println("나이 입력");
				year = scanner.nextInt();
				System.out.println("잔액 입력");
				balance = scanner.nextDouble();
				//처리
				
				//출력
				break;
			case 2:
				System.out.println("* 2 조회기능입니다");
				//변수
				
				//입력 2-1 사용자에게 아이디와 비밀번호 입력받기
				System.out.println("ID : ");
				id1 =scanner.next();
				System.out.println("PASS : ");
				pass1 =scanner.next();
				
				//처리 2-2 아이디와 비밀번호가 다르면 정보를 확인해주세요.
					
			    if (id1.equals(id) && pass1.equals(pass)) {
			    	System.out.print("==계좌조회\n"+ "ID : " + id +"\nPASS : " + pass + "\n나이 : " + year + "\n잔액" + balance+ "\n");
			    } else {System.out.println("다시 확인해주세요.\n");}
				//출력 2-3 같다면 사용자 정보출력
					
				break;
			case 3:
				System.out.println("* 3 입금기능입니다");
				//변수
				
				//입력
				System.out.println("ID : ");
				id1 =scanner.next();
				System.out.println("PASS : ");
				pass1 =scanner.next();
			    
				//처리
				    if (id1.equals(id) && pass1.equals(pass)) {
				    	System.out.println("입금 : ");
				    	balance1 = scanner.nextDouble();
				    	System.out.println("==입금완료");
				    	System.out.println("잔액 : " + (bal=balance+balance1));
				    	
				    }else {System.out.println("다시 확인해주세요.");}
				    
				  				 
				//출력
				break;
			case 4:
				System.out.println("* 4 출금기능입니다");
			    System.out.println("ID : ");
			    id1 = scanner.next();
			    System.out.println("PASS : ");
			    pass1 = scanner.next();

			    if (id1.equals(id) && pass1.equals(pass)) {
			        System.out.println("출금 : ");
			        bal1 = scanner.nextDouble();

			        if (bal1 <= balance) {
			            balance -= bal1;
			            System.out.println("==출금완료");
			            System.out.println("잔액 : " + balance);
			        } else {
			            System.out.println("잔액이 부족합니다. 출금이 불가능합니다.");
			        }
			    } else {
			        System.out.println("다시 확인해주세요.");
			    }
			    break;
			case 5:
				System.out.println("* 5 삭제기능입니다");
				//변수
				
				//입력
				System.out.println("ID : ");
				id1 = scanner.next();
				System.out.println("PASS : ");
				pass1 = scanner.next();
				//처리
				if (id1.equals(id)&&pass1.equals(pass)) 
				{
					System.out.println("계좌를 삭제하시겠습니까? (Y/N)");
					n=scanner.next();
					if(n.equals("y")) {id = null; pass = null; year = 0; balance = 0; System.out.println("");}
					else if(n.equals("n")) {System.out.println("");}
					//만약에 n이 입력한 값이 n이라면 삭제하지않는다. y,n = 문자 ""
					//만약에 n이 y이라면 정보삭제
				}else {System.out.println("다시 확인해주세요.");}
				//출력
				break;
			case 9:
				System.out.println("*ATM을 종료합니다.");
				break;

			}
			if (num == 9) {
				break;
			}
		}//end for
	}// end main
}// end class

/*
 * 하루에 하나씩 힌트 나가요~~! 천천히 정리하면서 익히면서 도전, 9.15까지 숙제
 * 
 * Step1. 무한반복으로 만드는 메뉴만들기
 * 
 * for(;;){//1-1무한반복 // 1-2 빠져나올조건 9 // 1-3 입력받은 번호가 if or switch 1을 입력하면
 * 추가기능입니다. 출력구문까지만 2을 입력하면 추가기능입니다. 출력구문까지만 3을 입력하면 추가기능입니다. 출력구문까지만 4을 입력하면
 * 추가기능입니다. 출력구문까지만 5을 입력하면 추가기능입니다. 출력구문까지만 9을 입력하면 추가기능입니다. 출력구문까지만 }
 * 
 * Step2.
 * 
 * Step3.
 */
