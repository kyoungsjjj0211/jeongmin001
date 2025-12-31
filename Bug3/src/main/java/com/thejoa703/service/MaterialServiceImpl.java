package com.thejoa703.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dao.MaterialDao;
import com.thejoa703.dto.MaterialDto;


@Service
public class MaterialServiceImpl implements MaterialService {
	 @Autowired MaterialDao dao;
	 @Autowired PasswordEncoder pwencoder;

	@Override public int insertMaterial(MaterialDto dto) {	
		try {
			return dao.insertMaterial(dto);
		}catch(DataAccessException e) {e.printStackTrace();
		return 0;
		}
	}

	@Override
	public int updateMaterial(MaterialDto dto) {
		try {
			return dao.updateMaterial(dto);
		}catch(DataAccessException e) {
			e.printStackTrace();
			return 0;
			}
	}
	@Override
	public int deleteMaterial(int materialid) {
		try{
			return dao.deleteMaterial(materialid);
		}catch (DataAccessException e) {
			e.printStackTrace();
		return 0;
		}
	}
	@Override
	public List<MaterialDto> MaterialList() {
		try{
			return dao.MaterialList();
		}catch (DataAccessException e) {
			e.printStackTrace();	
			return null;
		}
	}
	@Override
	public MaterialDto selectMaterial(int materialid) {
		try {
			return dao.selectMaterial(materialid);
		}catch(DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	public MaterialDto findIntegratedMaterial(String inputName) {
	    MaterialDto dto = dao.selectTitle(inputName);
	    if (dto != null) return dto;
	    List<MaterialDto> allMaterials = dao.MaterialList();
	    for (MaterialDto m : allMaterials) {
	        // 예: 입력값이 "유기농 사과"이고 DB에 "사과"가 있다면 매칭
	        if (inputName.contains(m.getTitle())) {
	            return m; 
	        }
	    }
	    return null;
	}
	
	
	@Override
	public MaterialDto selectTitle(String title) {
	try {
		return dao.selectTitle(title);
	}catch(DataAccessException e) {
		e.printStackTrace();
		return null;
	}
}

	@Override
	public int insert2Material(MultipartFile file, MaterialDto dto) {
	    // 1. file이 null이 아니고 비어있지 않을 때만 로직 실행
	    if(file != null && !file.isEmpty()) { 
	        String fileName   = file.getOriginalFilename(); 
	        String uploadPath = "C:/file/";
	        
	        // 폴더가 없으면 생성하는 코드 추가 (안전장치)
	        File folder = new File(uploadPath);
	        if(!folder.exists()) folder.mkdirs();

	        File img = new File(uploadPath + fileName);
	        try { 
	            file.transferTo(img); 
	            dto.setImageurl(fileName); 
	        } catch (IOException e) { e.printStackTrace(); }
	    } else {
	        // 2. 파일을 안 올렸을 때 기본 이미지 설정 (선택사항)
	        if(dto.getImageurl() == null || dto.getImageurl().isEmpty()) {
	            dto.setImageurl("defult.png");
	        }
	    }
	    return dao.insertMaterial(dto);
	}
	
	@Override
	public int update2Material(MultipartFile file, MaterialDto dto) {
	    // 1. 새 파일이 업로드 되었는지 확인
	    if (file != null && !file.isEmpty()) {
	        String fileName = file.getOriginalFilename();
	        String uploadPath = "C:/file/";
	        
	        File folder = new File(uploadPath);
	        if (!folder.exists()) folder.mkdirs();

	        File img = new File(uploadPath + fileName);
	        try {
	            file.transferTo(img);
	            dto.setImageurl(fileName); // 새 파일명 세팅
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        MaterialDto existingMaterial = dao.selectMaterial(dto.getMaterialid()); 
	        if (existingMaterial != null) {
	            dto.setImageurl(existingMaterial.getImageurl()); // 기존 파일명 유지
	        }
	    }

	    // 3. 최종 업데이트 실행
	    return dao.updateMaterial(dto);
	}

	/*
	 * @Override public List<MaterialDto> select10(int pstartno) { HashMap<String,
	 * Object> para = new HashMap(); int start=(pstartno-1)*10 + 1;
	 * para.put("start", start); para.put("end", start + 10 -1); return
	 * dao.select10(para); }
	 */
	@Override
	public List<MaterialDto> select10(int pstartno, String keyword) {
	    HashMap<String, Object> para = new HashMap<>();
	    para.put("start", (pstartno - 1) * 10 + 1);
	    para.put("end", pstartno * 10);
	    para.put("keyword", keyword); // MyBatis XML에서 #{keyword}로 쓰기 위해 담음
	    
	    return dao.select10(para);
	}
	
	/*
	 * @Override public int selectTotalCnt() {return dao.selectTotalCnt();}
	 */
	@Override
	public int selectTotalCnt(String keyword) {
	    return dao.selectTotalCnt(keyword); // DAO에도 keyword 전달
	}
	@Autowired
    private MaterialDao materialDao;
	
	@Override
	public void saveTrendData(int materialId, String keyword, String jsonResponse) {
	    // 1. 변수명이 중복되지 않게 map이라는 이름을 사용
	    // 2. HashMap<> 앞에 타입을 명시 (Java 11 기준)
	    Map<String, Object> map = new java.util.HashMap<String, Object>(); 
	    
	    map.put("materialId", materialId);
	    map.put("keyword", keyword);
	    map.put("periodData", jsonResponse);
	    
	    // 3. 필드명이 materialDao인지 확인 (에러창에 materialMapper를 못찾는다고 나옴)
	    materialDao.insertTrend(map);
	    }
		
	}

