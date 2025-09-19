package com.company.java008_Ex;

public class Repeat2 {
	public static void main(String[] args) {
        int[][] arr = new int[2][3];
        // int data = 101;
        int[][] data = {{101, 102, 103},{201, 202, 203}
        };
    
        for (int i = 0; i < arr.length; i++) {
            for (int a = 0; a < arr[i].length; a++) {
                arr[i][a] = data[i][a];
                //arr[i][a] = data ++
            }
            		//data=201;
        }
        		
    
        for (int i = 0; i < arr.length; i++) {
            for (int a = 0; a < arr[i].length; a++) {
                System.out.print(arr[i][a] + " ");
            }
            System.out.println();
        }
    }
}