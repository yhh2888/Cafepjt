package com.office.cafe.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AdminMemberController {

    @Autowired
    private AdminMemberService adminMemberService;

    // 회원가입 폼
    @GetMapping("/admin/join")
    public String joinForm() {
        return "admin/join";
    }

    // 회원가입 처리
    @PostMapping("/admin/join")
    public String join(AdminMemberDto dto, RedirectAttributes redirectAttributes) {
        int result = adminMemberService.join(dto);

        if (result == AdminMemberService.ACCOUNT_ALREADY_EXIST) {
            redirectAttributes.addFlashAttribute("message", "이미 존재하는 아이디입니다.");
            return "redirect:/admin/join";
        }

        return "redirect:/admin/login";
    }

    // 로그인 폼
    @GetMapping("/admin/login")
    public String loginForm() {
        return "admin/login";
    }

    // 로그인 처리
    @PostMapping("/admin/login")
    public String login(@RequestParam String amId, @RequestParam String amPw,
                         HttpSession session, RedirectAttributes redirectAttributes) {

        AdminMemberDto dto = adminMemberService.login(amId, amPw);

        if (dto == null) {
            redirectAttributes.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "redirect:/admin/login";
        }

        session.setAttribute("adminMember", dto);
        return "redirect:/admin/main";
    }

    // 로그아웃
    @GetMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }

    // 회원정보 수정 폼
    @GetMapping("/admin/myinfo")
    public String myInfoForm(HttpSession session) {
        AdminMemberDto dto = (AdminMemberDto) session.getAttribute("adminMember");
        return dto == null ? "redirect:/admin/login" : "admin/myinfo";
    }

    // 회원정보 수정 처리
    @PostMapping("/admin/myinfo")
    public String myInfo(AdminMemberDto dto, HttpSession session) {
        adminMemberService.updateInfo(dto);
        session.setAttribute("adminMember", dto);
        return "redirect:/admin/myinfo";
    }
}