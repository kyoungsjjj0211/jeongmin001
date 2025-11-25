package com.thejoa703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.Sboard1Dto;
import com.thejoa703.service.Sboard1Service;

@Controller
public class QuestController {
	
	@Autowired Sboard1Service service;
	
	@RequestMapping("/list.quest")
	public String list(Model model) {
		model.addAttribute("list", service.selectAll());
		return "quest_board/list";
	}
	
	@RequestMapping(value="/write.quest", method=RequestMethod.GET)
	public String write() {
		
		return "quest_board/write";
	}
	
	@RequestMapping(value="/write.quest", method=RequestMethod.POST)
	public String write_post(Sboard1Dto dto, RedirectAttributes rttr) {
		String result = "글쓰기 실패";
		
		if(service.insert(dto)>0) {result = "글쓰기 성공"; }
		rttr.addFlashAttribute("success", result);
		return "redirect:/list.quest";
	}
	
	@RequestMapping("/detail.quest")
	public String detail(int id, Model model) {
		model.addAttribute("dto", service.select(id));
		
		return "quest_board/detail";
	}
	
	@RequestMapping(value="/edit.quest", method=RequestMethod.GET)
	public String edit(int id, Model model) {
		model.addAttribute("dto", service.selectUpdateForm(id));
		return "quest_board/edit";
	}
	
	@RequestMapping(value="/edit.quest", method=RequestMethod.POST)
	public String edit_post(Sboard1Dto dto, RedirectAttributes rttr) {
		String result = "비밀번호를 확인해주세요";
		
		if(service.update(dto)>0) {result = "수정 성공"; }
		rttr.addFlashAttribute("success", result);
		return "redirect:/detail.quest?id=" + dto.getId();
	}
	
	@RequestMapping(value="/delete.quest", method=RequestMethod.GET) 
	public String delete() {
		
		return "quest_board/delete";
	}
	
	@RequestMapping(value="/delete.quest", method=RequestMethod.POST)
	public String delete_post(Sboard1Dto dto, RedirectAttributes rttr) {
		String result = "비밀번호를 확인해주세요";
		
		if(service.delete(dto) > 0) {result="삭제 성공";}
		rttr.addFlashAttribute("success", result);
		return "redirect:/list.quest";
	}
	
	//
	@RequestMapping(value="/upload.quest", method=RequestMethod.POST)
	public String upload_post(@RequestParam("file") MultipartFile file, Sboard1Dto dto, RedirectAttributes rttr) {
		String result = "글쓰기 실패";
		
		if(service.insert2(file, dto)>0) {result = "글쓰기 성공"; }
		rttr.addFlashAttribute("success", result);
		return "redirect:/list.quest";
	}
	
	@RequestMapping(value="/updateEdit.quest", method=RequestMethod.POST)
	public String updateEdit_post(@RequestParam("file") MultipartFile file, Sboard1Dto dto, RedirectAttributes rttr) {
		String result = "비밀번호를 확인해주세요";
		
		if(service.update2(file, dto)>0) {result = "수정 성공"; }
		rttr.addFlashAttribute("success", result);
		return "redirect:/detail.quest?id=" + dto.getId();
	}
	
}
/*
/list.quest			/view/quest_board/list.jsp	
/write.quest		/view/quest_board/write.jsp 	(글쓰기form)
/detail.quest		/view/quest_board/detail.jsp	(상세보기)
/edit.quest			/view/quest_board/edit.jsp		(수정하기form)
/delete.quest		/view/quest_board/delete.jsp	(삭제하기form)

 



 */