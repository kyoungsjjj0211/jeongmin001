package com.company.portfolio_game;

import java.util.List;
import java.util.Scanner;

public class CreateCharacter implements Gamecontroller {
	@Override
	public int exec(List<CharacterInfo> characters, int find) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("사용할 아이디 입력: ");
		String id = scanner.next();
		System.out.print("비밀번호 입력: ");
		String pass = scanner.next();

		characters.add(new CharacterInfo(id, pass));
		System.out.println("✅ 캐릭터 생성 완료!");
		return 1;
	}
}