package com.thejoa703.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thejoa703.dto.AppUserDto;
import com.thejoa703.service.AppUserService;

//@Controller //처리 (service) + 화면
@RestController //처리(service) + 나온값

public class AjaxSearchController { //inddouble?email=1@1 있는 값은 1 inddouble?email=9@9 없는 값은 0
	
	@Autowired AppUserService service;
	
	@RequestMapping("/iddouble")
	public Map<String,Object> iddouble(@RequestParam String email){
		Map<String,Object> result = new HashMap<>();
		result.put("cnt", service.iddouble(email));
		return result;
	}
		//전체유저정보 selectAll
		//아이디 주면 해당 유저 정보 찾기 select
		//수정하기 updateAdmin
		//삭제하기 deleteADmin
	
	@RequestMapping("/selectAll") //http://localhost:8181/ex006/selectAll
	public List<AppUserDto> selectAll(){
		return service.selectAll();
	}
	
	@RequestMapping("/select") //http://localhost:8181/ex006/select?appUserId=75 // http://localhost:8181/ex006/select?appUserId=75&mbtiType=1
	public Map<String,Object> select(@RequestParam int appUserId){
		Map<String,Object> result = new HashMap<>();
		result.put("result" , service.select(appUserId));
		return result;
	}
	
	@RequestMapping("/updateAdmin") // http://localhost:8181/ex006/updateAdmin?appUserId=80&mbtiTypeId=2
	public Map<String,Object> updateAdmin(@RequestParam int appUserId, 
										  @RequestParam int mbtiTypeId){
		Map<String, Object> result = new HashMap<>();
		AppUserDto dto = new AppUserDto();
		dto.setAppUserId(appUserId); dto.setMbtiTypeId(mbtiTypeId);
		result.put("result", service.updateAdmin(dto));
		return result;
	}
	
	@RequestMapping("/deleteAdmin") // http://localhost:8181/ex006/deleteAdmin?appUserId=80
	public Map<String,Object> deleteAdmin(@RequestParam int appUserId) {
		Map<String, Object> result = new HashMap<>();
		AppUserDto dto = new AppUserDto();
		dto.setAppUserId(appUserId);
		result.put("result", service.deleteAdmin(dto));
		return result;
	}
//	
//	  @RequestMapping("/updateAdmin") //
//	  http://localhost:8181/ex006/select?appUserId=75&mbtiType=1 public
//	  Map<String,Object> updateAdmin(@RequestParam AppUserDto dto){
//	  Map<String,Object> result = new HashMap<>(); result.put("result" ,
//	  service.updateAdmin(dto) ); return result; }
//	  
//	  @RequestMapping("/deleteAdmin") public Map<String,Object>
//	  deleteAdmin(@RequestParam AppUserDto dto){ Map<String,Object> result = new
//	  HashMap<>(); result.put("result" , service.deleteAdmin(dto) ); return result;
//	  }
//	 
	}
