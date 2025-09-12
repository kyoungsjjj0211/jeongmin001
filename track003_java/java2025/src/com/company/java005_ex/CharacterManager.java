package com.company.java005_ex;

import java.util.Scanner;

public class CharacterManager {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = null, job = null, tempName, tempJob;
        int level = 1, exp = 0, hp = 100;
        int menu;

        for (;;) {
            System.out.println("╔════════════════════╗");
            System.out.println("║   RPG CHARACTER    ║");
            System.out.println("╚════════════════════╝");
            System.out.println("1. 캐릭터 생성\n2. 정보 조회\n3. 경험치 추가\n4. 레벨업\n5. 삭제\n9. 종료");
            System.out.print("메뉴 선택 >>> ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            if (menu == 9) {
                System.out.println("게임 캐릭터 관리 시스템을 종료합니다.");
                break;
            }

            switch (menu) {
                case 1:
                    System.out.print("캐릭터 이름 입력: ");
                    name = scanner.nextLine();
                    System.out.print("직업 입력 (전사/마법사/도적): ");
                    job = scanner.nextLine();
                    level = 1;
                    exp = 0;
                    hp = 100;
                    System.out.println("캐릭터가 생성되었습니다!");
                    break;

                case 2:
                    System.out.print("캐릭터 이름 확인: ");
                    tempName = scanner.nextLine();
                    if (tempName.equals(name)) {
                        System.out.println("🧝 캐릭터 정보");
                        System.out.println("이름: " + name);
                        System.out.println("직업: " + job);
                        System.out.println("레벨: " + level);
                        System.out.println("경험치: " + exp);
                        System.out.println("체력: " + hp);
                    } else {
                        System.out.println("캐릭터를 찾을 수 없습니다.");
                    }
                    break;

                case 3:
                    System.out.print("캐릭터 이름 확인: ");
                    tempName = scanner.nextLine();
                    if (tempName.equals(name)) {
                        System.out.print("추가할 경험치 입력: ");
                        int addExp = scanner.nextInt();
                        exp += addExp;
                        System.out.println("경험치가 추가되었습니다. 현재 경험치: " + exp);
                    } else {
                        System.out.println("캐릭터를 찾을 수 없습니다.");
                    }
                    break;

                case 4:
                    System.out.print("캐릭터 이름 확인: ");
                    tempName = scanner.nextLine();
                    if (tempName.equals(name)) {
                        if (exp >= 100) {
                            level++;
                            exp -= 100;
                            hp += 20;
                            System.out.println("레벨업 성공! 현재 레벨: " + level + ", 체력: " + hp);
                        } else {
                            System.out.println("경험치가 부족합니다. 레벨업 실패.");
                        }
                    } else {
                        System.out.println("캐릭터를 찾을 수 없습니다.");
                    }
                    break;

                case 5:
                    System.out.print("삭제할 캐릭터 이름 입력: ");
                    tempName = scanner.nextLine();
                    if (tempName.equals(name)) {
                        System.out.print("정말 삭제하시겠습니까? (Y/N): ");
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("Y")) {
                            name = null;
                            job = null;
                            level = 1;
                            exp = 0;
                            hp = 100;
                            System.out.println("캐릭터가 삭제되었습니다.");
                        } else {
                            System.out.println("삭제가 취소되었습니다.");
                        }
                    } else {
                        System.out.println("캐릭터를 찾을 수 없습니다.");
                    }
                    break;

                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}

/*🎯 이 프로그램의 특징
게임 세계관 적용: RPG 요소(레벨, 경험치, 체력)를 활용

제어문 활용: for, switch, if 등으로 흐름 제어

확장 가능성: 클래스 분리, 다중 캐릭터, 전투 시스템 등으로 발전 가능

재미 요소: 레벨업, 직업 선택, 체력 증가 등 게임적 재미 포함*/