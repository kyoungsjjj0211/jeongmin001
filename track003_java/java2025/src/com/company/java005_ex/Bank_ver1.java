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
			
			/*
			 for(;;){무한반복
			 ■기능 1. 메뉴판
			 System.out.print("\n\n== BANK ==");
			 "\n1. 추가" + "\n2.조회" + "\n3.입금" + "\n4.출금" + "\n5.삭제");
			 num=scanner.nextInt();
			 ■기능 2.
			 if(num==9){System.out.println("종료합니다."); breaek;}
			 else if(num==1){
			 System.out.print("ID 입력 > ") ; id=scanner.next();
			 System.out.print("PASS 입력 > ") ; pass=scanner.next();
			 System.out.print("금액 입력 > ") ; balance=scanner.nextDouble();
			 }else if (num==2 || num==3 || num==4 || num==5){
			 System.out.print("ID 입력 > ") ; String tempId=scanner.next();
			 System.out.print("PASS 입력 > ") ; String tempPass=scanner.next();
			 if(!(id.eqauls(tempId) && pass.equals(tempPass) )){
			 System.out.println("아이디와 비밀번호를 확인해주세요!");
			 continue; //아래꺼 진행하지마!
			 }
			 //2. 2,3,4,5 각가에 해당하는 처라
			 switch(num){
			 case 2 : System.out.println("ID >" + id + "PASS > " pass + "잔액 > " + balance); break;
			 case 3 : System.out.print("입금할 금액 > "); double input = scanner.nextDouble();
			   		  balance +=intput;
			   		  System.out.println("입금을 완료했습니다.");
			   		  break;
			 case 4 : System.out.print("출금할 금액 > " ); double output = scanner.nextDouble();
			 		  if(output>balance) { System.out.println("잔액이 모자랍니다."); continue;}
			 		  balance -= output;
			 		  System.out.println("출금을 완료했습니다.");
			 		   break;
			 case 5 : System.out.println("삭제하시겠습니까?"); String answer = scanner.next();
			 if(!answer.toLowerCse().equals("y")) {System.out.println("삭제를 취소했습니다."); continue;
			 }
			 id=pass=""; balance=0;
			 System.out.println("삭제를 완료했습니다.");
			  break;
			 */
			 
			/*
			 if(9){빠져나오기}
			 else if(1) {사용자에게 추가}
			 else if (2,3,4,5){
			 1. 사용자 인증
			 2. 2,3,4,5 각각에 해당하는 처리
			 switch(){
			 case 2 : 정보출력 break;
			 case 3 : 입금 break;
			 case 4 : 출금 break;
			 case 5 : 삭제 break;
			 */
			System.out.println("╔══════════════════╗");
			System.out.println("║     Mine BANK    ║");
			System.out.println("╚══════════════════╝");
			System.out.println("* 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료\n입력 >>> ");
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
