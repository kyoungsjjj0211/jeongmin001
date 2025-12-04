package com.company.portfolio_game;

import java.util.Collections;
import java.util.List;

public class ShowRanking implements Gamecontroller {
	@Override
	public int exec(List<CharacterInfo> characters, int find) {
		if (characters.isEmpty()) {
			System.out.println("⚠️ 등록된 캐릭터가 없습니다.");
			return -1;
		}

		Collections.sort(characters);
		System.out.println("🏆 캐릭터 랭킹");
		for (int i = 0; i < characters.size(); i++) {
			System.out.println((i + 1) + "위: " + characters.get(i));
		}
		return -1;
	}
}
