package com.office.cafe.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/member")
public class UserMemberController {

	final private String CLASS_NAME = "[UserMemberController] ";
	
	final private UserMemberService userMemberService;
	
	/*
	 * 사용자 회원 가입 양식
	 * /user/member/createAccountForm
	 */
	@GetMapping("/createAcountForm")
	public String createAcountForm() {
		System.out.println(CLASS_NAME.concat("createAcountForm()"));
		
		String nextPage = "user/member/create_account_form";
		
		return nextPage;	
		
	}
	
	/*
	 * 사용자 회원 가입 확인
	 * /user/member/createAccountConfirm
	 */
	@PostMapping("/createAccountConfirm")
	public String createAccountConfirm(UserMemberDto userMemberDto) {
		System.out.println(CLASS_NAME.concat("createAccountConfirm()"));
		
		String nextPage = "user/member/create_account_ok";
		
		int result = userMemberService.createAccountConfirm(userMemberDto);
		
		if (result <= 0)
			nextPage = "user/member/crate_account_ng";
		
		return nextPage;
			
	}
	
	
}
