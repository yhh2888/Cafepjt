package com.office.cafe.menu.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/menu")
public class UserMenuController {
	
	final private String CLASS_NAME = "[UserMenuController]";
	
	final private UserMenuService UserMenuService;
	
	/*
	 * 메뉴 검색 확인
	 * /user/menu/searchMenuConfirm
	 */

	@GetMapping("/searchMenuConfirm")
	public String searchMenuConfirm() {
		System.out.println(CLASS_NAME.concat(searchMenuConfirm()));
		
		String nextPage = "user/menu/search_menu";
		
		return nextPage;
	}
	
}
