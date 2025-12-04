	package com.company.java005;
	
	public class Repear002_While_Dowhile {
		public static void main(String[] args) {
			System.out.println("for문 1 2 3 4 5");
			for (int i = 1; i <= 5; i++) {
				System.out.print(i + "\t");
			}
	
			System.out.println("while문 1 2 3 4 5");
			int i = 1;
			while (i <= 5) {
				System.out.print(i + "\t");
				i++;
			}
	
			System.out.println("do while문 1 2 3 4 5");
			i = 1;
			do {
				System.out.print(i + "\t");
				i++;
			} while (i <= 5);
	
			////////////////////////
			System.out.println("for문 5 4 3 2 1");
			for (int s = 5; s >= 1; s--) {
				System.out.print(s + "\t");
			}
	
			System.out.println("for문 5 4 3 2 1");
			int s = 5;
			while (s >= 1) {
				System.out.print(s + "\t");
				s--;
			}
	
			System.out.println("for문 5 4 3 2 1");
			s = 5;
			do {
				System.out.print(s + "\t");
				s--;
			} while (s >= 1);
			
			System.out.println("for문 JAVA1, JAVA2, JAVA3");
			for (int a = 1; a <= 3; a++) {
				System.out.print("Java" + a + "\t");
			}
			
			System.out.println("for문 JAVA1, JAVA2, JAVA3");
			int a = 1;
			while (a<=3) {
				System.out.print("Java" + a + "\t");
				a++;}
			
			System.out.println("for문 JAVA1, JAVA2, JAVA3");
			a = 1;
			do {
				System.out.print("Java" + a + "\t");
				a++;
				}while (a<=3);
		}
	}
