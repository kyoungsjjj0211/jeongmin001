package com.company.java005_ex;

import java.util.Arrays;
import java.util.Scanner;

public class Bacnk002_Array {
	public static void main (String[] args) {
		//변수								 0  1  2
		 String []id=new String[3];       // one two three
	     String []pass = new String[3];  // 1111 2222 3333
	     double []balance = new double[3];// 1100 2200 3300
	     int num=-1;
	     Scanner scanner=new Scanner(System.in); 
	     //입력 + 처리 + 출력
	     while(num !=9) {//9가 아니라면 계속 무한반복
	    	// System.out.println( Arrays.toString(id));
	    	// System.out.println( Arrays.toString(pass));
	    	// System.out.println( Arrays.toString(balance));
	    	 //기능 1. 메뉴판
				System.out.println("╔══════════════════╗");
				System.out.println("║     Myo  BANK    ║");
				System.out.println("╚══════════════════╝");
				System.out.println("* 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료\n입력 >>> ");
				num=scanner.nextInt();
				
				if(num==1) { //1-1. 빈칸인지 확인후 find
							 //ver-1 if(0번이 빈칸이라면){find는 0} if(1번이 빈칸이라면){find는 1}
							 //ver-2 if(0번이 null){find는 0} if(1번이 null){find는 1}
							 //ver-3 if(id[0]==null){find=0;} if(id[1]==null){find=1}
							 //ver-4 찾았으면 나오기 추가 - 백만개의 자료있다라고하면 ~! 시간 오래걸림
					int find=-1;  
					for (int i = 0; i < id.length; i++) {
						if (id[i] == null) { find = i; break; }
					}
					//id 중복 검사
					//사용자에게 입력받은 아이디와 id[0]번이 사용자에게 입력받은 id[1]과 같다면 만들수 없다
					//사용자에게 입력받은 아이디와 id[1]번이 사용자에게 입력받은 id[2]과 같다면 만들수 없다
					//if(사용자에게 입력받은 아이디와 id[0]번이 사용자에게 입력받은 id[1]과 같다면){만들수 없다}
					//
					
					System.out.println("ID를 입력하세요");
					id[find] = scanner.next();
					System.out.println("PASS를 입력하세요");
					pass[find] = scanner.next();
					System.out.println("입금액을 입력하세요");
					balance[find] = scanner.nextDouble();
					System.out.println("계정이 생성되었습니다.");
				}
						
				else if (num==2 || num ==3 || num ==4 || num ==5) {//2-1 인증정보
								  //1. 사용자에게 아이디 입력받기
								  //2. 사용자에게 비밀번호 입력받기
								  //3. ver-0 int find=-1; 없는 번호 / 문자얄 비교는 equals
							 	  //3. ver-1 사용자에게 입력받은 아이디와 id[0]번이 같고 사용자에게 입력받은 비밀번호와 pass[0]번이면 사용자번호는 0
								  //3. ver-1 사용자에게 입력받은 아이디와 id[1]번이 같고 사용자에게 입력받은 비밀번호와 pass[1]번이면 사용자번호는 1
								  //4. ver-2 if(사용자에게입력받은아이디와 id[1]번이 같고 사용자에게 입력받은 비밀번호와 pass[1]번이면){사용자번호는1}
								  //4. 만약 find == -1 이라면 유저정보 못찾음!
								  // 2-2. find 번호로 각각의 처리
					    System.out.print("ID를 입력하세요: ");
					    String inputId = scanner.next();
					    System.out.print("PASS를 입력하세요: ");
					    String inputPass = scanner.next();

						int find = -1;
						for (int i = 0; i < id.length; i++) {
							if (inputId.equals(id[i]) && inputPass.equals(pass[i])) {
								find = i;
								break;
							}
						}
						if (find == -1) {
							System.out.println("❌ 유저 정보를 찾을 수 없습니다.");
						} else {
							if (num == 2) {
								System.out.println("💰 현재 잔액: " + balance[find]);
							} else if (num == 3) {
								System.out.print("입금할 금액을 입력하세요: ");
								double deposit = scanner.nextDouble();
								balance[find] += deposit;
								System.out.println("✅ 입금 완료! 현재 잔액: " + balance[find]);
							} else if (num == 4) {
								System.out.print("출금할 금액을 입력하세요: ");
								double withdraw = scanner.nextDouble();
								if (balance[find] >= withdraw) {
									balance[find] -= withdraw;
									System.out.println("✅ 출금 완료! 현재 잔액: " + balance[find]);
								} else {
									System.out.println("⚠️ 잔액이 부족합니다.");
								}
							} else if (num == 5) {
								id[find] = null;
								pass[find] = null;
								balance[find] = 0;
								System.out.println("🗑️ 계정이 삭제되었습니다.");
							}
					        
					   /*
					System.out.println("ID입력 : ");
					String inputId=scanner.next();
					System.out.println("PASS입력 : ");
					String inputPass=scanner.next();
					boolean found = false;
					
					for(int i=0; i<id.length; i++) {
						if (inputId.equals(id[i]) && inputPass.equals(pass[i])) {
							System.out.println("잔액 : " + balance[i]);
							found =true;
							break;*/
						}
					}
				}
				/*else if(num==3) {
					
				}
				else if(num==4) {
					
				}
				else if(num==5) {
					
				}
				else System.out.println("메뉴를 확인해주세요");
					}//while end
				
				//if(num==1) (1이라면) {1-1. 빈칸인지 확 후 1-2.유저 계정에 입력받기}
				//else if (num==2 || num==3 || num==4 || num==5)(2,3,4,5,){2-1. 인증정보 , 2-2 각각의 처리}
				//else{System.out.println("메뉴를 확인해주세요.");}
*/
		}//main end
	}//class end


