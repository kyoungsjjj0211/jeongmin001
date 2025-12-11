package com.thejoa703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.Sboard2Dto;
import com.thejoa703.service.Sboard2Service;

@Controller
@RequestMapping("/board")
public class Sboard2Controller {

@Autowired
private Sboard2Service service;

	
// /board/list
@GetMapping("/list")
public String list (Model model) {
	model.addAttribute("list", service.selectAll()); //처리
	return "board/list";
	}
// /board/write(글쓰기 폼)
@GetMapping("/write") public String write_get() {return "board/write";}

// /board/write (글쓰기 기능)
@PostMapping("/write") public String write_post(
		MultipartFile file
		,Sboard2Dto dto
		, RedirectAttributes rttr ) {
	String result ="글쓰기 실패";
	if(service.insert(file, dto) > 0) {result="글쓰기 성공!";}
	rttr.addFlashAttribute("success" , result);
	return "redirect:/board/list";
}
// /board/detail (상세보기)
@GetMapping("/detail")
public String detail (int id, Model model) {
	model.addAttribute("dto", service.select(id)); //처리
	return "board/detail";
	}
// /board/edit (수정폼)
@GetMapping("/edit")
public String edit_get (int id, Model model) {
	model.addAttribute("dto", service.selectUpdateForm(id)); //처리
	return "board/edit";
	}
// /board/edit (수정기능)
@PostMapping("/edit")
public String edit_post (
	MultipartFile file ,Sboard2Dto dto , RedirectAttributes rttr ) {
	String result ="글쓰기 실패";
	if(service.update(file, dto) > 0) {result="글쓰기 성공!";}
	rttr.addFlashAttribute("success" , result);
	return "redirect:/board/detail?id=" + dto.getId();
	}
// /board/delete (삭제폼)
@GetMapping("/delete")
public String delete_get() {
	return "board/delete";
	}
// /board/delete (삭제기능)
@PostMapping("/delete")
public String delete_post (Sboard2Dto dto , RedirectAttributes rttr ) {
	String result ="글삭제 실패";
	if(service.delete(dto) > 0) {result="글삭제 성공!";}
	rttr.addFlashAttribute("success" , result);
	return "redirect:/board/list";
	}
}
