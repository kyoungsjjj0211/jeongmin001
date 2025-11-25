package com.thejoa703.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thejoa703.dto.Sboard1Dto;
import com.thejoa703.service.Sboard1Service;

@RestController		//@Controller + @ResponseBody
public class SearchController {
	@Autowired Sboard1Service service;
	
	@RequestMapping("/searchTest")
	//@ResponseBody
	public String hi() {
		return "hi";
	}
	
	@RequestMapping("/selectSearch")
	//@ResponseBody
	public List<Sboard1Dto> selectSearch(@RequestParam("search") String search) {
		return service.selectSearch(search);
	}
}


/*
@Controller
public class SearchController {
	@Autowired Sboard1Service service;
	
	@RequestMapping("/searchTest")
	@ResponseBody
	public String hi() {
		return "hi";
	}
}
*/