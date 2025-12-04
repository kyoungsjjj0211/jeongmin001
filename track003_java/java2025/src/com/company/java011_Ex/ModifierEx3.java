package com.company.java011_Ex;

import com.company.java011.Score;

public class ModifierEx3 {
    public static void main(String[] args) {
        Score iron = new Score();
        Score hulk = new Score("hulk", 20, 50, 30);


        iron.setName("iron");
        iron.setKor(100);
        iron.setEng(100);
        iron.setMath(100);

        // 출력
        Score.info();     // 헤더 출력
        iron.show();      // iron 정보 출력
        hulk.show();      // hulk 정보 출력
    }
}