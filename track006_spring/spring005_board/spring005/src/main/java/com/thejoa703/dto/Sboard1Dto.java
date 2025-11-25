package com.thejoa703.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sboard1Dto {
	private int id;
	private int appUserId;
	private String btitle;
	private String bcontent;
	private String bpass;
	private String bfile;
	private int bhit;
	private String bip;
	//private Timestamp createAt;
	 //private LocalDateTime createAt; // CREATE_AT (default: SYSTIMESTAMP)
    private String createAt;
}
