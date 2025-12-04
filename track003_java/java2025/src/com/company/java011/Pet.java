package com.company.java011;

public class Pet {
    private String name;
    private int walkTime, snackCount, cuddleCount, moodScore;
    private String snackStars, tailWag, todayMessage;

    public Pet() {}

    public Pet(String name, int walkTime, int snackCount, int cuddleCount) {
        this.name = name;
        this.walkTime = walkTime;
        this.snackCount = snackCount;
        this.cuddleCount = cuddleCount;
        calculateMood();
    }

    @Override public String toString() {
		return "Pet [name=" + name + ", walkTime=" + walkTime + ", snackCount=" + snackCount + ", cuddleCount="
				+ cuddleCount + ", moodScore=" + moodScore + ", snackStars=" + snackStars + ", tailWag=" + tailWag
				+ ", todayMessage=" + todayMessage + "]";
	}

	public int getMoodScore() {return moodScore;}
	public void setMoodScore(int moodScore) {this.moodScore = moodScore;}
	public String getSnackStars() {return snackStars;}
	public void setSnackStars(String snackStars) {this.snackStars = snackStars;}
	public String getTailWag() {return tailWag;}
	public void setTailWag(String tailWag) {this.tailWag = tailWag;}
	public String getTodayMessage() {return todayMessage;}
	public void setTodayMessage(String todayMessage) {this.todayMessage = todayMessage;}
	public String getName() {return name;}
	public int getWalkTime() {return walkTime;}
	public int getSnackCount() {return snackCount;}
	public int getCuddleCount() {return cuddleCount;}


    public void setName(String name) {
        this.name = name;
    }

    public void setWalkTime(int walkTime) {
        this.walkTime = walkTime;
        calculateMood();
    }

    public void setSnackCount(int snackCount) {
        this.snackCount = snackCount;
        calculateMood();
    }

    public void setCuddleCount(int cuddleCount) {
        this.cuddleCount = cuddleCount;
        calculateMood();
    }

    private void calculateMood() {
        moodScore = walkTime + (snackCount * 10) + (cuddleCount * 5);

        if (moodScore >= 90) snackStars = "★★★★★";
        else if (moodScore >= 70) snackStars = "★★★★";
        else if (moodScore >= 50) snackStars = "★★★";
        else if (moodScore >= 30) snackStars = "★★";
        else snackStars = "★";

        if (moodScore >= 90) tailWag = "흔들흔들흔들";
        else if (moodScore >= 60) tailWag = "흔들흔들";
        else if (moodScore >= 40) tailWag = "살짝 흔들";
        else tailWag = "꼬리 내림";

        if (moodScore >= 90) todayMessage = "\"오늘은 정말 행복했어요!\"";
        else if (moodScore >= 60) todayMessage = "\"좋은 하루였어요!\"";
        else if (moodScore >= 40) todayMessage = "\"조금 더 놀아줘요!\"";
        else todayMessage = "\"외로웠어요...\"";
    }

    public void show() {
        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s %-15s %s\n",
                name,
                walkTime + "분",
                snackCount + "개",
                cuddleCount + "회",
                moodScore,
                snackStars,
                tailWag,
                todayMessage);
    }
   
    public static void info() {
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("이름   산책시간   간식개수   쓰다듬횟수   행복도   간식보상   꼬리흔들기   오늘의멘트");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
}
