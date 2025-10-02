package com.company.portfolio_game;

import java.util.List;
import java.util.Scanner;

public class Login implements Gamecontroller {
	@Override
	public int exec(List< CharacterInfo> characters, int find) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("🆔 아이디: "); String id = scanner.next();
		System.out.print("🔐 비밀번호: "); String pass = scanner.next();

		for (int i = 0; i < characters.size(); i++) {
			if (characters.get(i).getId().equals(id) && characters.get(i).getPass().equals(pass)) {
				System.out.println("✅ 로그인 성공");
				return i;
			}
		}
		return -1;
	}
}