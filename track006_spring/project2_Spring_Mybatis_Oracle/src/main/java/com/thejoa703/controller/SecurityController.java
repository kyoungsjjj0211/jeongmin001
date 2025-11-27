package com.thejoa703.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.AppUserDto;
import com.thejoa703.service.AppUserService;

@Controller
@RequestMapping("/security/*")
public class SecurityController {
	
	@Autowired AppUserService service;
	
	//////////////////////////
	//@RequestMapping("/mypage") public String mypage() { return "member/mypage2"; }
	
		@RequestMapping("/mypage") public String mypage(Principal principal, Model model) {
			System.out.println("...............@@@@@@@@@@@@@@" + principal);
			System.out.println("...............@@@@@@@@@@@@@@" + principal.getName());
			String email = principal.getName();
			model.addAttribute("dto", service.selectEmail(email));
					return "member/mypage2"; 
		}
		///////////////////
		
	@RequestMapping("/all")
	public String all() { return "member/all"; }
	
	@RequestMapping("/member")
	public String member() { return "member/member"; }
	
	@RequestMapping("/admin")
	public String admin() { return "member/admin"; }
	/////////////////////////
	@RequestMapping("/login")
	public String login() { return "member/login"; }
	
	@RequestMapping("/fail")
	public String fail() { return "member/fail"; } //알림창
	/////////////////////////////
	
	//join
	@RequestMapping(value="/join")
	public String join_get() { return "member/join"; }
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')") //1. 안에 있는 권한중
	//@PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN)") //2. 로그인 + ADMIN 권한이 있다면
	//@PreAuthorize("isAnonymous()") //3. 아무나 글쓰기 가능하게 (로그인하지 않은 사용자 , 회원가입)
	//@PreAuthorize("isAuthenticated()") //4. 로그인했다면
	@PreAuthorize("isAnonymous()")
	@RequestMapping(value="/join"
				, method=RequestMethod.POST
				, headers=("content-type=multipart/*"))
	public String join_post(
			@RequestParam("file") MultipartFile file, AppUserDto dto, RedirectAttributes rttr) {
		String result = "회원가입 실패";
		if( service.insert3(file, dto)  > 0 ) {  result ="회원가입 성공"; }
		rttr.addFlashAttribute("success" , result); 
		return "redirect:/security/login"; }
}
