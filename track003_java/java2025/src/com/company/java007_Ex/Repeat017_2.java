package com.company.java007_Ex;

public class Repeat017_2 {
	public static void main(String[] args) {
		char[][] arr = new char [2][3];
		char data='A';
				for(int ch=0; ch<arr.length; ch++) {
					for(int kan=0; kan< arr[ch].length; kan++) {
						arr[ch][kan] = data++;
					}
					data='B';
				}
				for(int ch= 0; ch < arr.length; ch++) {
					for (int kan=0; kan < arr[ch].length; kan++) {
						System.out.print(arr[ch][kan]+"\t");
						
					}
					System.out.println();
				}
	}
}
