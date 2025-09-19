package com.company.java008_Ex;

public class Repeat6 {

	public static void main(String[] args) {
		
        String[][] arr = new String[2][3];
        String[][] data = { { "A","B","C"}, {"a","b","c"}
        };
        for (int i=0; i<arr.length; i++) {
        	for(int a=0; a<arr[i].length; a++) {
        		arr[i][a] = data[i][a];
        	}
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int a = 0; a < arr[i].length; a++) {
                System.out.print(arr[i][a] + " ");
            }
            System.out.println(); 
        }
	}
}
