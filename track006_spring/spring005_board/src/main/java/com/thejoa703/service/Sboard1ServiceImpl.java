package com.thejoa703.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thejoa703.dao.Sboard1Dao;
import com.thejoa703.dto.Sboard1Dto;

@Service   // component-scan  ★★★★★★★★★★★★★★★★
public class Sboard1ServiceImpl  implements Sboard1Service{ 
	   @Autowired  Sboard1Dao   dao;
	   public int insert(Sboard1Dto dto)   {    //이미지관련....업로드처리, 중간단위에서 필요중간로직 
		   try { dto.setBip(  InetAddress.getLocalHost().getHostAddress()  ); } 
		   catch (UnknownHostException e) { e.printStackTrace(); }
		   return dao.insert(dto); 
	   } 
	   public List<Sboard1Dto> selectAll() { return dao.selectAll(); }
	   public Sboard1Dto select(int id)    { dao.updateHit(id);   return dao.select(id); }
	   public Sboard1Dto selectUpdateForm(int id) { return dao.select(id); }
	   public int update(Sboard1Dto dto)   { return dao.update(dto); }
	   public int delete(Sboard1Dto dto)   { return dao.delete(dto); }	
	 
}
