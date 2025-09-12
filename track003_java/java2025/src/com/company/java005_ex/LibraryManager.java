package com.company.java005_ex;

import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bookTitles = new String[100];
        boolean[] isBorrowed = new boolean[100];
        int bookCount = 0;
        int menu;

        for (;;) {
            System.out.println("╔════════════════════╗");
            System.out.println("║     My LIBRARY     ║");
            System.out.println("╚════════════════════╝");
            System.out.println("1. 도서 등록\n2. 도서 목록 조회\n3. 도서 대출\n4. 도서 반납\n5. 도서 삭제\n9. 종료");
            System.out.print("메뉴 선택 >>> ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            if (menu == 9) {
                System.out.println("도서관 시스템을 종료합니다.");
                break;
            }

            switch (menu) {
                case 1:
                    System.out.print("등록할 도서 제목 입력: ");
                    String title = scanner.nextLine();
                    bookTitles[bookCount] = title;
                    isBorrowed[bookCount] = false;
                    bookCount++;
                    System.out.println("도서가 등록되었습니다.");
                    break;

                case 2:
                    System.out.println("📖 도서 목록");
                    for (int i = 0; i < bookCount; i++) {
                        System.out.println((i + 1) + ". " + bookTitles[i] + " [" + (isBorrowed[i] ? "대출중" : "보유중") + "]");
                    }
                    break;

                case 3:
                    System.out.print("대출할 도서 번호 입력: ");
                    int borrowIndex = scanner.nextInt() - 1;
                    if (borrowIndex >= 0 && borrowIndex < bookCount) {
                        if (!isBorrowed[borrowIndex]) {
                            isBorrowed[borrowIndex] = true;
                            System.out.println("도서 대출 완료: " + bookTitles[borrowIndex]);
                        } else {
                            System.out.println("이미 대출된 도서입니다.");
                        }
                    } else {
                        System.out.println("잘못된 번호입니다.");
                    }
                    break;

                case 4:
                    System.out.print("반납할 도서 번호 입력: ");
                    int returnIndex = scanner.nextInt() - 1;
                    if (returnIndex >= 0 && returnIndex < bookCount) {
                        if (isBorrowed[returnIndex]) {
                            isBorrowed[returnIndex] = false;
                            System.out.println("도서 반납 완료: " + bookTitles[returnIndex]);
                        } else {
                            System.out.println("이 도서는 대출되지 않았습니다.");
                        }
                    } else {
                        System.out.println("잘못된 번호입니다.");
                    }
                    break;

                case 5:
                    System.out.print("삭제할 도서 번호 입력: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    if (deleteIndex >= 0 && deleteIndex < bookCount) {
                        System.out.println("도서 \"" + bookTitles[deleteIndex] + "\"를 삭제하시겠습니까? (Y/N)");
                        scanner.nextLine(); // 버퍼 비우기
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("Y")) {
                            for (int i = deleteIndex; i < bookCount - 1; i++) {
                                bookTitles[i] = bookTitles[i + 1];
                                isBorrowed[i] = isBorrowed[i + 1];
                            }
                            bookCount--;
                            System.out.println("도서가 삭제되었습니다.");
                        } else {
                            System.out.println("삭제가 취소되었습니다.");
                        }
                    } else {
                        System.out.println("잘못된 번호입니다.");
                    }
                    break;

                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}

/*💡 이 프로그램의 특징
제어문 활용: for, switch, if 등 다양한 제어문을 활용

배열 기반 데이터 관리: 도서 정보와 대출 상태를 배열로 관리

확장 가능성: 추후 Book 클래스로 객체화하거나, ArrayList로 변경 가능

실무 감각: 삭제 시 확인 절차, 대출 상태 체크 등 사용자 경험 고려*/