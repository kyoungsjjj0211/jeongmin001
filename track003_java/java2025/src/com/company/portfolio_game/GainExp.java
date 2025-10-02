package com.company.portfolio_game;

import java.util.List;
import java.util.Random;

public class GainExp implements Gamecontroller {
	@Override
	public int exec(List<CharacterInfo> characters, int find) {
		Random random = new Random();
		int gainedExp = 50 + random.nextInt(100);
		System.out.println("✨ " + gainedExp + " 경험치 획득!");
		characters.get(find).gainExp(gainedExp);
		return find;
	}
}