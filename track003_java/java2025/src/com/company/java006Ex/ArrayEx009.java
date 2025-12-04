package com.company.java006Ex;

public class ArrayEx009 {
	public static void main(String[] args) {
	String[] name= {"아이언맨"	,"헐크","캡틴","토르","호크아이"};
	int[] kor= {100,20,90,70,35};
	int[] eng= {100,20,90,70,35};
	int[] mat= {100,20,90,70,35};
	int[] aver=new int[5];
	int[] rank = {1, 1, 1, 1, 1};
	String[] pass = new String[5];
	String[] jang = new String[5];
	
	for (int i = 0; i < name.length; i++) {
		aver[i] = (kor[i] + eng[i] + mat[i]) / 3;
        if (aver[i] >= 60) {pass[i] = "합격";} else {pass[i] = "불합격";}
        if (aver[i] >= 95) {jang[i] = "장학생";} else {jang[i] = "비장학생";}
	}
    
    for (int i=0; i<aver.length; i++) {
    	for(int j=0; j<aver.length; j++) {
    		if(aver[i] < aver[j]) { rank[i]++;
    		}
    	}
	
	}
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("이름      국어   영어   수학   평균   합격여부   장학생  랭크");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        for (int i = 0; i < name.length; i++) {
        	String starRank = "★".repeat(rank[i]); 
            System.out.printf("%s\t %d\t %d\t %d\t %d\t %s\t %s\t %s\n",
                name[i], kor[i], eng[i], mat[i], aver[i], pass[i], jang[i], starRank);
        }
		System.out.println("\t");
		}
	}


