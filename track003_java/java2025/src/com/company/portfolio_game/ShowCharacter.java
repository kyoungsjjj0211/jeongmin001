package com.company.portfolio_game;

import java.util.List;

public class ShowCharacter implements Gamecontroller {
	@Override
	public int exec(List<CharacterInfo> characters, int find) {
		System.out.println(characters.get(find));
		return find;
	}
}