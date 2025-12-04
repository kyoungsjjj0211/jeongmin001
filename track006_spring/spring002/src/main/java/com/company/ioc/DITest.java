package com.company.ioc;

// @Date
public class DITest {
	private String name;
	private int age;
	
	public DITest() {super();}
	public DITest(String name, int age) {super(); this.name = name; this.age = age;}

	@Override
	public String toString() { return "DITest [name=" + name + ", age=" + age + "]";}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public int getAge() {return age;}

	public void setAge(int age) {this.age = age;}
	

	// 생성자 + ToString +getters/setters
}
