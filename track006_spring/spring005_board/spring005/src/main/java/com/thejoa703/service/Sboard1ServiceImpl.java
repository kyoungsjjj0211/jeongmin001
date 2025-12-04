package com.thejoa703.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dao.Sboard1Dao;
import com.thejoa703.dto.Sboard1Dto;

@Service
public class Sboard1ServiceImpl implements Sboard1Service {

	@Autowired Sboard1Dao dao;
	
	
	public int insert(Sboard1Dto dto) {  
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dao.insert(dto); 
		
	}

	
	public List<Sboard1Dto> selectAll() {  return dao.selectAll(); }

	public Sboard1Dto select(int id) {  
		dao.updateHit(id);
		
		return dao.select(id); 
	
	}

	
	
	

	public int update(Sboard1Dto dto) {  return dao.update(dto); }

	public int delete(Sboard1Dto dto) { return dao.delete(dto);}

	public Sboard1Dto selectUpdateForm(int id) {  return dao.select(id); }


	public int insert2(MultipartFile file, Sboard1Dto dto) {
		if(!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			String uploadPath = "C:/file/";
			File img = new File(uploadPath + fileName);
			try {
				file.transferTo(img);
				dto.setBfile(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return dao.insert2(dto);
	}


	public int update2(MultipartFile file, Sboard1Dto dto) {
		if(!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			String uploadPath = "C:/file/";
			File img = new File(uploadPath + fileName);
			try {
				file.transferTo(img);
				dto.setBfile(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dao.update2(dto);
	}

	/* Search - Ajax */
	public List<Sboard1Dto> selectSearch(String keyword){
		HashMap<String, String> para = new HashMap<>();
		para.put("search", "%" + keyword + "%");
		
		return dao.selectSearch(para);
	}

	
}
