package com.thejoa703.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.thejoa703.service.UserStatusService;

@Controller
@RequestMapping("/admin/user_status") // 기준 경로: 언더바(_) 사용
public class AdminUserStatusController {

    @Autowired
    private UserStatusService userStatusService;

    /**
     * 1. 관리자 페이지 첫 로드 (전체 페이지 리턴)
     * URL: GET /admin/user_status
     */
    @GetMapping
    public String userStatusPage(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "1") int page, 
            Model model) {
        
        // 서비스에서 검색어와 페이지 번호에 맞는 데이터 10건을 가져옴
        Map<String, Object> data = userStatusService.getUserList(keyword, page);
        
        // 데이터와 현재 검색어를 모델에 담아 뷰로 전달
        model.addAllAttributes(data);
        model.addAttribute("keyword", keyword); 
        
        return "admin/user_status"; // src/main/resources/templates/admin/user_status.html
    }

    /**
     * 2. AJAX 비동기 테이블 갱신 전용 (테이블 조각만 리턴)
     * URL: GET /admin/user_status/table
     */
    @GetMapping("/table")
    public String userStatusTable(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "1") int page, 
            Model model) {
        
        Map<String, Object> data = userStatusService.getUserList(keyword, page);
        
        model.addAllAttributes(data);
        model.addAttribute("keyword", keyword);
        
        // Thymeleaf Fragment: user_status.html 파일 내의 id가 userTableArea인 부분만 골라서 보냄
        return "admin/user_status :: #userTableArea";
    }

    /**
     * 3. 회원 정지 해제 처리
     * URL: POST /admin/user_status/activate
     */
    @PostMapping("/activate")
    public String activateUser(@RequestParam int appUserId) {
        userStatusService.activateUser(appUserId);
        // 처리 후 다시 언더바(_) 경로로 리다이렉트
        return "redirect:/admin/user_status";
    }

    /**
     * 4. 회원 활동 정지 처리
     * URL: POST /admin/user_status/suspend
     */
    @PostMapping("/suspend")
    public String suspendUser(
            @RequestParam int appUserId,
            @RequestParam String reason,
            @RequestParam String untilDate) {
        
        userStatusService.suspendUser(appUserId, reason, untilDate);
        // 처리 후 다시 언더바(_) 경로로 리다이렉트
        return "redirect:/admin/user_status";
    }
}