package com.company.ioc;

import java.util.List;

import lombok.Data;

@Data
public class AnimalFarm {
	private String name;
	private Animal ani;
	private List<String> skills;

	//##
	public void show() {
		System.out.println(name + ">" + ani.eat() );
		System.out.println(name + ">" + ani.sleep() );
		System.out.println(name + ">" + ani.poo() );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal getAni() {
		return ani;
	}

	public void setAni(Animal ani) {
		this.ani = ani;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	
}


/* [AnimalFarm] (사용) → [ <<interface>>Animal]
↑(삽입)                 ↑(구현)        ↑(구현)
[beans.xml]   (생성) → [Cat       /       Dog]
*/