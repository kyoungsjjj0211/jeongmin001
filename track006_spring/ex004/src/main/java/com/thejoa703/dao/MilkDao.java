package com.thejoa703.dao;

import java.util.List;
import com.thejoa703.dto.MilkDto;

@MyDao
public interface MilkDao {
	public int insert(MilkDto dto);
	public int update(MilkDto dto);
	public int delete(int mno);
	public MilkDto select(int mno);
	public List<MilkDto>selectAll();
}
