package com.company.java016_javaio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class Javaio004 {
	public static void main(String[] args) throws IOException  { 
		//#1. 경로
		String origin="src/com/company/java016_javaio_ex/ma.jpg";
		String target1="src/com/company/java016_javaio_ex/ma1.jpg";
		String target2="src/com/company/java016_javaio_ex/ma2.jpg";
		
		//#2. byte 이미지파일 원본 읽어들여서 쓰기
		//ma.jpg → ma1.jpg
		//InputStream > [프로그램] > OutputStream
		InputStream bis = new FileInputStream(origin); // 원본 읽어들여서
		OutputStream bos = new FileOutputStream(target1); //ma1.jpg 쓰기
		
		int cnt1 =0;
		while( (cnt1 = bis.read()) != -1) { //원본 읽어들여서
			bos.write( ( byte)cnt1 ); //ma1.jpg 쓰기
		}
		bos.flush(); bos.close(); bis.close();
		System.out.println(">> byte 이미지복사완료!");
		
		//#3. chat 이미지파일 원본 읽어들여서 쓰기
		//ma.jpg → ma2.jpg
		//Reader > [프로그램] > Writer
		Reader cr = new FileReader(origin); //원본 읽어들여서
		Writer cw = new FileWriter(target2); //ma2.jpg 쓰기
		
		int cnt2=0;
		while( (cnt2 = cr.read()) != -1) { //원본 읽어들여서
			cw.write((char)cnt2); //ma2.jpg쓰기
		}
		cw.flush(); cw.close(); cr.close();
		System.out.println(">> char 이미지 복사완료!");
		    
	}
}
