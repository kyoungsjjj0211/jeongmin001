package com.thejoa703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.AppUserDto;
import com.thejoa703.service.AppUserService;

@Controller
public class QuestController {
	
@Autowired AppUserService service;

	@RequestMapping("/list.users")
	public String list() {
			return "users_board/list";
	}
	@RequestMapping(value="/join.users", method=RequestMethod.GET)
	public String join_get() {
		return "users_board/join";
	}
	@RequestMapping(value="/join.users", method=RequestMethod.POST)
	public String join_post(AppUserDto dto, RedirectAttributes rttr) {
		String result="회원가입 실패";
		if (service.insert(dto) > 0) {result = "회원가입 성공";}
		rttr.addFlashAttribute("success", result);
		return "users_board/join";
	}
	@RequestMapping(value="/login.users", method=RequestMethod.GET)
	public String login_get() {
		return "users_board/login";
	}
	@RequestMapping(value="/login.users", method=RequestMethod.POST)
	public String login_post(AppUserDto dto, RedirectAttributes rttr) {
		String result="로그인 실패";
		if(service.login(dto) > 0 ) {result ="로그인 성공";}
		rttr.addFlashAttribute("success", result);
		return "users_board/login";
	}
	@RequestMapping("/mypage.users")
	public String Mypage() {
		return "users_board/mypage";
	}
	@RequestMapping(value="/edit.users", method=RequestMethod.GET)
	public String edit_get() {
		return "users_board/edit";
	}
	@RequestMapping(value="/edit.users" , method=RequestMethod.POST)
	public String edit_post(AppUserDto dto, RedirectAttributes rttr) {
		String result="정보수정 실패";
		if(service.update(dto) > 0 ) {result = "정보수정 성공";}
		rttr.addFlashAttribute("success", result);
		return "users_board/edit";}
	
	@RequestMapping("/delete.users")
	public String delete() {
		return "users_board/delete";
	}
	

}



///list.users            /view/member/list
///join.users             /view/member/join.jsp    (회원가입)
///join.users             회원가입 기능후 /login.users 로 이동  (회원가입기능-post)
///login.quest            /view/member/login.jsp    (로그인폼)
///login.quest           로그인 기능후 /mypage.users   (로그인기능-post)
///mypage.quest            /view/member/mypagen.jsp    (로그인폼)
///edit.users              /view/member/edit.jsp    (수정하기폼)
///edit.users            수정기능 후 /mypage.users   
///delete.users           삭제 기능후 list.users

