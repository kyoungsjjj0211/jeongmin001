package com.thejoa703.service;

import java.util.List;

import com.thejoa703.dto.Sboard1Dto;

public interface Sboard1Service {
	public int insert(Sboard1Dto dto);
	public List<Sboard1Dto> selectAll() ;
	public Sboard1Dto select(int id);
	 public Sboard1Dto selectUpdateForm(int id) ;
	 public int update(Sboard1Dto dto);
	  public int delete(Sboard1Dto dto);
}
