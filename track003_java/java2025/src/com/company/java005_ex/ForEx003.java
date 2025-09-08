package com.company.java005_ex;

public class ForEx003 {
	public static void main(String[] args) {
		//변수
	    int sum = 0;
        
	    //입력 + 처리
	    //sum변수에 담기
	    //sum = sum+1; // sum[1] 0+1
	    //sum = sum+2; // sum[3] 1+2
	    //sum = sum+3; // sum[6] 3+3
	    // {반복} {변수} for(시작;종료;변화;)
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        //출력
	    // ""1 +2 +3 +4 +5 +6 +7 +8 +9 +10 =55
        System.out.println("1~10까지의 합 : " + sum);
      //System.out.println("=" + count);
    }
}