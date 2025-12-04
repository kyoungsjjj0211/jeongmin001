package com.company.java005_ex;

import java.util.Scanner;

public class Bank_ver2 {
    public static void main(String[] args) {
        int num, year = 0;
        String id = null, pass = null, n = null;
        double balance = 0, balance1 = 0, bal1 = 0;

        Scanner scanner = new Scanner(System.in);

        for (;;) {
            System.out.println("======BANK======\n* 1.추가\n* 2.조회\n* 3.입금\n* 4.출금\n* 5.삭제\n* 9.종료\n입력 >>> ");
            num = scanner.nextInt();
            System.out.println();

            switch (num) {
                case 1:
                    System.out.println("* 1 추가기능입니다");
                    System.out.println("아이디 입력");
                    id = scanner.next();
                    System.out.println("비밀번호 입력");
                    pass = scanner.next();
                    System.out.println("나이 입력");
                    year = scanner.nextInt();
                    System.out.println("잔액 입력");
                    balance = scanner.nextDouble();
                    break;

                case 2:
                    System.out.println("* 2 조회기능입니다");
                    if (checkCredentials(scanner, id, pass)) {
                        System.out.println("==계좌조회");
                        System.out.println("ID : " + id);
                        System.out.println("PASS : " + pass);
                        System.out.println("나이 : " + year);
                        System.out.println("잔액 : " + balance);
                    }
                    break;

                case 3:
                    System.out.println("* 3 입금기능입니다");
                    if (checkCredentials(scanner, id, pass)) {
                        System.out.println("입금 : ");
                        balance1 = scanner.nextDouble();
                        balance += balance1;
                        System.out.println("==입금완료");
                        System.out.println("잔액 : " + balance);
                    }
                    break;

                case 4:
                    System.out.println("* 4 출금기능입니다");
                    if (checkCredentials(scanner, id, pass)) {
                        System.out.println("출금 : ");
                        bal1 = scanner.nextDouble();
                        if (bal1 <= balance) {
                            balance -= bal1;
                            System.out.println("==출금완료");
                            System.out.println("잔액 : " + balance);
                        } else {
                            System.out.println("잔액이 부족합니다. 출금이 불가능합니다.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("* 5 삭제기능입니다");
                    if (checkCredentials(scanner, id, pass)) {
                        System.out.println("계좌를 삭제하시겠습니까? (Y/N)");
                        n = scanner.next();
                        if (n.equalsIgnoreCase("y")) {
                            id = null;
                            pass = null;
                            year = 0;
                            balance = 0;
                            System.out.println("계좌가 삭제되었습니다.");
                        } else {
                            System.out.println("삭제가 취소되었습니다.");
                        }
                    }
                    break;

                case 9:
                    System.out.println("*ATM을 종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }

            if (num == 9) {
                break;
            }
        
       } // end for
    } // end main

private static boolean checkCredentials(Scanner scanner, String id, String pass) {
        System.out.println("ID : ");
        String inputId = scanner.next();
        System.out.println("PASS : ");
        String inputPass = scanner.next();

        if (inputId.equals(id) && inputPass.equals(pass)) {
            return true;
        } else {
            System.out.println("다시 확인해주세요.\n");
            return false;
        }
    }
}