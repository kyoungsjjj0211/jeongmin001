package com.company.portfolio_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game_Main {
	private List<CharacterInfo> characters;
	private Gamecontroller[] controller;

	public Game_Main() {
		characters = new ArrayList<>();
		controller = new Gamecontroller[]{
			new Login(), new CreateCharacter(), new ShowCharacter(), new GainExp(), new DeleteCharacter()
		};
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int num = -1;

		while (num != 9) {
			System.out.println("🎮 [RPG 캐릭터 육성 시스템]");
			System.out.println("[1] 캐릭터 생성");
			System.out.println("[2] 캐릭터 정보 조회");
			System.out.println("[3] 경험치 획득");
			System.out.println("[4] 캐릭터 삭제");
			System.out.println("[9] 종료");
			System.out.print("👉 메뉴 선택: ");
			num = scanner.nextInt();

			int find = -1;

			if (num >= 2 && num <= 4) {
				find = controller[0].exec(characters, 0); // 로그인
				if (find == -1) {
					System.out.println("❌ 로그인 실패");
					continue;
				}
			}

			if (num == 1) controller[1].exec(characters, 0);
			else if (num == 2) controller[2].exec(characters, find);
			else if (num == 3) controller[3].exec(characters, find);
			else if (num == 4) controller[4].exec(characters, find);
			else if (num == 9) System.out.println("👋 프로그램 종료");
			else System.out.println("⚠️ 잘못된 입력입니다.");
		}
	}

	public static void main(String[] args) {
		new Game_Main().menu();
	}
}
