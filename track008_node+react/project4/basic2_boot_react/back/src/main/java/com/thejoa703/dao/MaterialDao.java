package com.thejoa703.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.request.MaterialRequestDto;

import com.thejoa703.dto.response.MaterialResponseDto;




@Mapper
public interface MaterialDao {
	public long insertMaterial(MaterialResponseDto dto);
	public long updateMaterial (MaterialResponseDto dto);
	public long deleteMaterial (long materialid);
	public List<MaterialResponseDto> MaterialList();
	public MaterialResponseDto selectMaterial(long materialid);
	public MaterialResponseDto selectTitle(String materialid);
	public long insert2Material(MultipartFile file, MaterialRequestDto dto);
	public long update2Material(MultipartFile file, MaterialRequestDto dto);
	public List<MaterialResponseDto>  select10(HashMap<String, Object>  para);
	public long selectTotalCnt(String keyword);
	public void insertTrend(Map<String, Object> map);
}
