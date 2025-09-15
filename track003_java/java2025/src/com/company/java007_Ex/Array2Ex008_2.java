package com.company.java007_Ex;

public class Array2Ex008_2 {
    public static void main(String[] args) {
        int[][] data = {
            {10, 10, 10, 10},
            {20, 20, 20, 20},
            {30, 30, 30, 30}
        };
        int[][] result = new int[data.length + 1][data[0].length + 1];

        // 복사 + 행합 + 열합 + 전체합
        for (int i = 0; i < data.length; i++) {
            for (int a = 0; a < data[i].length; a++) {
                int value = data[i][a];
                result[i][a] = value; // 데이터 복사
                result[i][data[i].length] += value; // 행 합계
                result[data.length][a] += value; // 열 합계
                result[data.length][data[0].length] += value; // 전체 합계
            }
        }

        // 출력
        for (int i = 0; i < result.length; i++) {
            for (int a = 0; a < result[i].length; a++) {
                System.out.print(result[i][a] + "\t");
            }
            System.out.println();
        }
    }
}
