package com.thejoa703.dto;

import lombok.Data;

@Data
public class PagingDto {
	private int listtotal; //#1) 전체글 128
	private int onepagelist; //#2) 한페이지에 보여줄 게시물의 수 10
	private int pagetotal; //#3) 총페이지 128/10=12 12개 + 8글 = 13개  128/10= 13
	private int bottomlist; //#4) 하단의 페이지 나누기 이전 11 12 13....... 몇개?
	private int pstartno; //#5) 페이지 시작번호 - 스타트번호
	
	private int current; //#6) 현제페이지번호
	private int start; //#7) 시작페이지번호
	private int end; //#8) 끝페이지번호
	
	

	public PagingDto(int listtotal,int pstartno) { //전체페이지수, 시작번호
		super();
		this.listtotal = listtotal; 	// 전체페이지수
		this.onepagelist = 10; 			// 한페이지에 보여줄 게시물의 수 10
		if(listtotal <= 0) {listtotal=1;}
		this.pagetotal = (int) Math.ceil(listtotal/(double)onepagelist);
		// 128/10 = 12+1 , 130/10=13
		// 12.6 -> Math.ceil(12.6) → 13
		// 13.0 -> Math.ceil(13.0) → 13
		this.bottomlist = 10; 
		this.pstartno = (pstartno-1)*onepagelist + 1; // (1)1,10     (2)11,20,  (3)21,30 (db에서 가져올 번호)
		this.current = pstartno; 
		this.start 	 = ((current-1)/bottomlist)*bottomlist + 1;  
		this.end 	 = start + bottomlist - 1;
		if(end > pagetotal){end=pagetotal;} //128 = 13 시작 21 끝 30 전체갯수 13

		 
	}
	 //  1  2  3  4  5  6  7  8  9 10
}// 이전 11 12 13 14 15 16 17 18 19 20 다음    (11→11, 15→ 11, 20→11) 10/10 14/10 19/10 = 1
