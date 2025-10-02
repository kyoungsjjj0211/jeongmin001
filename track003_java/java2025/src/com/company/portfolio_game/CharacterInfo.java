package com.company.portfolio_game;

import java.io.Serializable;

public class CharacterInfo implements Serializable, Comparable<CharacterInfo> {
	private static final long serialVersionUID = 1L;

	private String id;
	private String pass;
	private int level;
	private int exp;

	public CharacterInfo() { }

	public CharacterInfo(String id, String pass) {
		this.id = id;
		this.pass = pass;
		this.level = 1;
		this.exp = 0;
	}

	@Override
	public String toString() {
		return "🧝‍♂️ 캐릭터 정보 [ID=" + id + ", 레벨=" + level + ", 경험치=" + exp + "]";
	}

	public String getId() { return id; }
	public String getPass() { return pass; }
	public int getLevel() { return level; }
	public int getExp() { return exp; }

	public void gainExp(int amount) {
		this.exp += amount;
		while (exp >= level * 100) {
			exp -= level * 100;
			level++;
			System.out.println("🎉 레벨업! 현재 레벨: " + level);
		}
	}

	@Override
	public int compareTo(CharacterInfo o) {
		if (this.level != o.level) {
			return o.level - this.level;
		}
		return o.exp - this.exp;
	}
}