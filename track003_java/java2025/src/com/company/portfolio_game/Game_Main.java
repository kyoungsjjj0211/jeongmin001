package com.company.portfolio_game;

import java.io.*;
import java.util.*;

public class Game_Main {
	private List<CharacterInfo> characters;
	private Gamecontroller[] controller;
	private final String FILE_NAME = "characters.dat";

	public Game_Main() {
		loadCharacters(); // 시작 시 로드
		controller = new Gamecontroller[]{
			new Login(), new CreateCharacter(), new ShowCharacter(),
			new GainExp(), new DeleteCharacter(), new ShowRanking()
		};
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int num = -1;

		while (num != 9) {
			System.out.println("\n🎮 [RPG 캐릭터 육성 시스템]");
			System.out.println("[1] 캐릭터 생성");
			System.out.println("[2] 캐릭터 정보 조회");
			System.out.println("[3] 경험치 획득");
			System.out.println("[4] 캐릭터 삭제");
			System.out.println("[5] 캐릭터 랭킹 보기");
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
			else if (num == 5) controller[5].exec(characters, 0);
			else if (num == 9) System.out.println("👋 프로그램 종료");
			else System.out.println("⚠️ 잘못된 입력입니다.");

			if (num >= 1 && num <= 4) saveCharacters(); // 변경 시 저장
		}
		saveCharacters(); // 종료 전 저장
	}

	private void loadCharacters() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			characters = (List<CharacterInfo>) in.readObject();
			System.out.println("📂 캐릭터 데이터 불러오기 완료 (" + characters.size() + "명)");
		} catch (Exception e) {
			characters = new ArrayList<>();
			System.out.println("📁 저장된 캐릭터 정보가 없습니다. 새로 시작합니다.");
		}
	}

	private void saveCharacters() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			out.writeObject(characters);
		} catch (Exception e) {
			System.out.println("❌ 캐릭터 저장 실패");
		}
	}

	public static void main(String[] args) {
		new Game_Main().menu();
	}
}


/*
기능	적용된 클래스	설명
📁 자동 저장/불러오기	Game_Main.java, CharacterInfo.java	실행 시 자동 로드, 캐릭터 변경 시 자동 저장
🏅 캐릭터 랭킹 보기	ShowRanking.java, CharacterInfo.java	정렬 기준(레벨, 경험치) 기반 출력, 메뉴 5번 추가
*/