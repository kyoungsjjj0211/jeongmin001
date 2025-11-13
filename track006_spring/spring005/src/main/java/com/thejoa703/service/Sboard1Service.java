package com.thejoa703.service;

import java.util.List;

import com.thejoa703.dao.MbtiDao;
import com.thejoa703.dto.Sboard1Dto;

public interface Sboard1Service {
		public int insert(Sboard1Dto dto); // board insert 기능
		public int update(Sboard1Dto dto); // board update 기능
		public int delete(Sboard1Dto dto); // board delete 기능
		public List<Sboard1Dto> selectAll(); // board 전체
		public Sboard1Dto       select(int id); // board 상세보기 (조회수 올리기 + 해당글가져오기)
		public Sboard1Dto       selectUpdateForm(int id);
		
}
