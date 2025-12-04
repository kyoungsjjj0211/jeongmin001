package com.company.java005_ex;

public class forlengthbock {
	public static void main(String[] args) {
		
		char[] chars = new char[3];

       
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ('a' + i);
        }

 
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
	}
}
