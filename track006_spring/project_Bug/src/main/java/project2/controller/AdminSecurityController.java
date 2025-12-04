package project2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import project2.dto.AppUserDto;
import project2.service.AdminSecurityService;

@Controller
@RequestMapping("/security/admin")
public class AdminSecurityController {

    @Autowired
    private AdminSecurityService adminService;

    // 관리자 전용 페이지
    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String adminList() {
        return "admin/list";
    }

    // 전체 유저 조회
    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/selectAll", method=RequestMethod.GET)
    @ResponseBody
    public List<AppUserDto> selectAll(){
        return adminService.selectAll();
    }

    // 특정 유저 조회
    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/select", method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> select(@RequestParam int appUserId){
        Map<String,Object> result = new HashMap<>();
        result.put("result", adminService.select(appUserId));
        return result;
    }

    // 유저 삭제
    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/deleteAdmin", method=RequestMethod.POST)
	@PreAuthorize("isAuthenticated()")
    @ResponseBody
    public Map<String,Object> deleteAdmin(@RequestParam int appUserId,
    									  @RequestParam String email){
        Map<String,Object> result = new HashMap<>();
        AppUserDto dto = new AppUserDto();
        dto.setEmail(email);
        dto.setAppUserId(appUserId);
        int cnt = adminService.delete(dto);
        result.put("result", cnt);
        return result;
    }
    
    
}
