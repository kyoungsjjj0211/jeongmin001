package com.company.java011_Ex;

public class Milk{  // java011_ex에 설정해주세요!
	   private int  mno;   
	   private String mname;  
	   private  int mprice;
	   
	   public void setMprice(int mprice) {
	        this.mprice = mprice;
	   }
	   public Milk(int mno, String mname, int mprice) {super(); this.mno = mno; this.mname = mname; this.mprice = mprice;}
	   public Milk() {
		super();
		// TODO Auto-generated constructor stub
	}
	   public int getMno() {return mno;}
	   public void setMno(int mno) {this.mno = mno;}
	   public String getMname() {return mname;}
	   public void setMname(String mname) {this.mname = mname;}
	   public int getMprice() {return mprice;}
	   @Override public String toString() {
		return "Milk [mno=" + mno + ", mname=" + mname + ", mprice=" + mprice + "]";
	}
	}

