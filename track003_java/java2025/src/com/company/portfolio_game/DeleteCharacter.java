package com.company.portfolio_game;

import java.util.List;

public class DeleteCharacter implements Gamecontroller {
	@Override
	public int exec(List<CharacterInfo> characters, int find) {
		CharacterInfo removed = characters.remove(find);
		System.out.println("🗑️ 캐릭터가 삭제되었습니다: " + removed.getId());
		return -1;
	}
}