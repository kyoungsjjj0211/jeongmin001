package com.company.java005_ex;
import java.util.Arrays;
import java.util.Scanner;

public class  MainportfolioCharacterManagerArray2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] name = new String[3];
        String[] job = new String[3];
        int[] level = new int[3];
        int[] exp = new int[3];
        int[] hp = new int[3];

        int menu = -1;

        while (menu != 9) {
            System.out.println("╔════════════════════╗");
            System.out.println("║   RPG CHARACTER    ║");
            System.out.println("╚════════════════════╝");
            System.out.println("1. 캐릭터 생성\n2. 정보 조회\n3. 경험치 추가\n4. 레벨업\n5. 삭제\n9. 종료");
            System.out.print("메뉴 선택 >>> ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (menu) {
                case 1: // 캐릭터 생성
                    int createIndex = -1;
                    for (int i = 0; i < name.length; i++) {
                        if (name[i] == null) {
                            createIndex = i;
                            break;
                        }
                    }
                    if (createIndex == -1) {
                        System.out.println("⚠️ 캐릭터 슬롯이 가득 찼습니다.");
                        break;
                    }

                    System.out.print("캐릭터 이름 입력: ");
                    String newName = scanner.nextLine();

                    // 중복 검사
                    boolean duplicate = false;
                    for (String n : name) {
                        if (newName.equals(n)) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (duplicate) {
                        System.out.println("❌ 이미 존재하는 이름입니다.");
                        break;
                    }

                    System.out.print("직업 입력 (전사/마법사/도적): ");
                    String newJob = scanner.nextLine();

                    name[createIndex] = newName;
                    job[createIndex] = newJob;
                    level[createIndex] = 1;
                    exp[createIndex] = 0;
                    hp[createIndex] = 100;

                    System.out.println("✅ 캐릭터가 생성되었습니다!");
                    break;

                case 2: // 정보 조회
                    System.out.print("캐릭터 이름 확인: ");
                    String searchName = scanner.nextLine();
                    int find = findCharacter(name, searchName);

                    if (find == -1) {
                        System.out.println("❌ 캐릭터를 찾을 수 없습니다.");
                    } else {
                        System.out.println("🧝 캐릭터 정보");
                        System.out.println("이름: " + name[find]);
                        System.out.println("직업: " + job[find]);
                        System.out.println("레벨: " + level[find]);
                        System.out.println("경험치: " + exp[find]);
                        System.out.println("체력: " + hp[find]);
                    }
                    break;

                case 3: // 경험치 추가
                    System.out.print("캐릭터 이름 확인: ");
                    searchName = scanner.nextLine();
                    find = findCharacter(name, searchName);

                    if (find == -1) {
                        System.out.println("❌ 캐릭터를 찾을 수 없습니다.");
                    } else {
                        System.out.print("추가할 경험치 입력: ");
                        int addExp = scanner.nextInt();
                        exp[find] += addExp;
                        System.out.println("✅ 경험치가 추가되었습니다. 현재 경험치: " + exp[find]);
                    }
                    break;

                case 4: // 레벨업
                    System.out.print("캐릭터 이름 확인: ");
                    searchName = scanner.nextLine();
                    find = findCharacter(name, searchName);

                    if (find == -1) {
                        System.out.println("❌ 캐릭터를 찾을 수 없습니다.");
                    } else {
                        if (exp[find] >= 100) {
                            level[find]++;
                            exp[find] -= 100;
                            hp[find] += 20;
                            System.out.println("🎉 레벨업 성공! 현재 레벨: " + level[find] + ", 체력: " + hp[find]);
                        } else {
                            System.out.println("⚠️ 경험치가 부족합니다. 레벨업 실패.");
                        }
                    }
                    break;

                case 5: // 삭제
                    System.out.print("삭제할 캐릭터 이름 입력: ");
                    searchName = scanner.nextLine();
                    find = findCharacter(name, searchName);

                    if (find == -1) {
                        System.out.println("❌ 캐릭터를 찾을 수 없습니다.");
                    } else {
                        System.out.print("정말 삭제하시겠습니까? (Y/N): ");
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("Y")) {
                            name[find] = null;
                            job[find] = null;
                            level[find] = 0;
                            exp[find] = 0;
                            hp[find] = 0;
                            System.out.println("🗑️ 캐릭터가 삭제되었습니다.");
                        } else {
                            System.out.println("삭제가 취소되었습니다.");
                        }
                    }
                    break;

                case 9:
                    System.out.println("게임 캐릭터 관리 시스템을 종료합니다.");
                    break;

                default:
                    System.out.println("⚠️ 잘못된 메뉴입니다.");
            }
        }
    }

    // 캐릭터 이름으로 인덱스 찾기
    public static int findCharacter(String[] nameArray, String targetName) {
        for (int i = 0; i < nameArray.length; i++) {
            if (targetName.equals(nameArray[i])) {
                return i;
            }
        }
        return -1;
    }
}
