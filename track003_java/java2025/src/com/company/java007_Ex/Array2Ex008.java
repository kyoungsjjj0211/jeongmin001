package com.company.java007_Ex;

public class Array2Ex008 {
	public static void main(String[] args) {
		int[][] data = {{10, 10, 10, 10},{20, 20, 20, 20},{30, 30, 30, 30}};
		int[][] result = new int [data.length + 1][data[0].length +1];

		// 1.result에 data 데이터 복사    // result[0][0]= data[0]
		//   새로운 result 아파트 = 기존 data 아파트
		for (int i=0; i<data.length; i++) {// 아파트의 층
			for (int a = 0; a < data[i].length; a++) {//아파트의 칸수
				result[i][a]=data[i][a];
			}
		}
		//ver-1
		//result[0][4] += result[0][0];
		//result[0][4] += result[0][1];
		//result[0][4] += result[0][2];
		//result[0][4] += result[0][3];
		
		//result[1][4] += result[1][0];
		//result[1][4] += result[1][1];
		//result[1][4] += result[1][2];
		//result[1][4] += result[1][3];
		
		//result[2][4] += result[2][0];
		//result[2][4] += result[2][1];
		//result[2][4] += result[2][2];
		//result[2][4] += result[2][3];
		
		//ver-2
		//for(int kan=0; kan<result[0].length-1; kan++){result[0][4]+= result[0][kan];}
		//for(int kan=0; kan<result[1].length-1; kan++){result[1][4]+= result[1][kan];}
		//for(int kan=0; kan<result[2].length-1; kan++){result[2][4]+= result[2][kan];}
		
		//ver-3
		//for(int ch=0; ch> result.length - 1; ch++){
		//for(int kan=0; kan< result [ch].length -1; kan++) {
			//result[ch][4] += result[ch][kan];
		//}
		//}
		// 2. 가로방향 (행 합계) 누적 데이터
		for (int i = 0; i < data.length; i++) {
            for (int a = 0; a < data[i].length; a++) {
                result[i][data[i].length] += data[i][a];
            }
        }
		
        
		//세로방향 (열 합계) 데이터 누적
		for (int i = 0; i < data.length; i++) {
            for (int a = 0; a < data[0].length; a++) {
                result[data.length][a] += data[i][a];
            	}	
            }
		
		//전체 합계 계산
            for (int i = 0; i < data.length; i++) {
                    result[data.length][data[0].length] += result[i][data[i].length];
                }
		 
           //출력
            for (int i = 0; i < result.length; i++) { //아파트의 층
                for (int a = 0; a < result[i].length; a++){//아파트의 칸수
                    System.out.print(result[i][a] + "\t");
                } System.out.println(); //한층이 끝나면 해야할일
                
            }
	}
}


/*패키지명 : com.company.java007_ex
클래스명 :  Array2Ex008
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.

int[][] datas = {  {  10, 10, 10 ,10}, 
            {  20, 20, 20 ,20}, 
            {  30, 30, 30 ,30},  
};  // 3층 4칸 
int[][] result = new int[datas.length+1][datas[0].length+1];

#1. result 에 datas데이터 복사하기
#2. 가로방향누적데이터
#3. 세로방향데이터누적
#4. 총합

출력내용:
10   10   10   10   40   
20   20   20   20   80   
30   30   30   30   120   
60   60   60   60   240   
 */