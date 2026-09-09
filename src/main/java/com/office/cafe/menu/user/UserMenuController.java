package com.office.cafe.menu.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/menu")
public class UserMenuController {
	
	final private String CLASS_NAME = "[UserMenuController]";
	
	final private UserMenuService userMenuService;
	
	/*
	 * 메뉴 검색
	 * /user/menu/searchMenuConfirm
	 */

	@GetMapping("/searchMenuConfirm")
	public String searchMenuConfirm(@RequestParam(value="m_name", required=false) String m_name, 
									Model model) {
		System.out.println(CLASS_NAME.concat("searchMenuConfirm()"));
		
		String nextPage = "user/menu/search_menu";
		
		// 메뉴 검색
		List<UserMenuDto> userMenuDtos = userMenuService.searchMenuConfirm(m_name);
		model.addAttribute("userMenuDtos", userMenuDtos);
		
		return nextPage;
	}
	
	/*
	 * 메뉴 리스트
	 * /user/menu/listMenuConfirm
	 */
	
	@GetMapping("/listMenuConfirm")
	public String listMenuConfirm(Model model) {
		System.out.println(CLASS_NAME.concat("listMenuConfirm()"));
		
		String nextPage = "user/menu/list_menu";
		
		List<UserMenuDto> userMenuDtos = userMenuService.listMenuConfirm();
		model.addAttribute("userMenuDtos", userMenuDtos);
		
		return nextPage;
	}
	
	
	/*
	 * 메뉴 디테일 리스트
	 * /menuDetail
	 */
	@GetMapping("/menuDetail")
	public String menuDetail(@RequestParam("m_no") int m_no, Model model) {
		System.out.println(CLASS_NAME.concat("menuDetail()"));
		
		String nextPage = "user/menu/menu_detail";
		
		UserMenuDto userMenuDto = userMenuService.menuDetail(m_no);
		model.addAttribute("userMenuDto", userMenuDto);
		
		return nextPage;
		
	}
}
	
	
	
	
	
	
	
