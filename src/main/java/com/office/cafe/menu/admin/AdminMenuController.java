package com.office.cafe.menu.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.office.cafe.menu.admin.util.UploadFileService;
import com.office.cafe.menu.admin.AdminMenuService;

@Controller
@RequestMapping("/menu/admin")
public class AdminMenuController {
	
	final private String CLASS_NAME = "[AdminMenuController]";
	
	final private AdminMenuService adminMenuService;
	final private UploadFileService uploadFileService;
	
	public AdminMenuController(AdminMenuService adminMenuService, UploadFileService uploadFileService) {
		this.adminMenuService = adminMenuService;
		this.uploadFileService = uploadFileService;
	}
	
	@GetMapping("/registerMenuForm")
	public String registerMenuForm(HttpSession session) {
		System.out.println(CLASS_NAME.concat("registerMenuForm()"));
		
		if (session.getAttribute("loginedAdminMemberId") == null) {
			return "redirect:/admin/menu/loginForm";
		}
		
		String nextPage = "admin/menu/register_menu_form";
		
		return nextPage;
	}
	
	@PostMapping("/registerMenuConfirm")
	public String registerMenuConfirm(AdminMenuDto adminMenuDto,
			@RequestParam("file") MultipartFile file) {
		System.out.println(CLASS_NAME.concat("registerMenuConfirm()"));
		
		String nextPage = "admin/menu/register_menu_ok";
		
		// SAVE FILE
//		UploadFileService uploadFileService = new UploadFileService();
		String savedFileName = uploadFileService.upload(file);
		
		if (savedFileName != null) {
			int result = adminMenuService.registerMenuConfirm(adminMenuDto);
			
			if (result <= 0)
				nextPage = "admin/menu/register_menu_ng";
			
		} else {
			nextPage = "admin/menu/register_menu_ng";
			
		}
		
		return nextPage;
	}
	
	@GetMapping("/searchMenuConfirm")
	public ModelAndView searchMenuConfirm(
			@RequestParam("m_name") String m_name) {
		System.out.println(CLASS_NAME.concat("searchMenuConfirm()"));
		
		String nextPage = "admin/menu/search_menu";
		
		List<AdminMenuDto> adminMenuDtos = adminMenuService.searchMenuConfirm(m_name);
		
		ModelAndView modelAndView = new ModelAndView();
		// 뷰 설정
		modelAndView.setViewName(nextPage);
		
		// 데이터 주입
		modelAndView.addObject("adminMenuDtos", adminMenuDtos);
		
		return modelAndView;
	}
	
	@GetMapping("/menuDetail")
	public String menuDetail(
			@RequestParam("m_no") int m_no, 
			Model model,
			HttpSession session) {
		System.out.println(CLASS_NAME.concat("menuDetail()"));
		
		String nextPage = "admin/menu/menu_detail";
		
		AdminMenuDto adminMenuDto = adminMenuService.menuDetail(m_no);
		model.addAttribute("adminMenuDto", adminMenuDto);
		
		return nextPage;
	}
	
	@GetMapping("/modifyMenuForm")
	public String modifyMenuForm(
			@RequestParam("m_no") int m_no, 
			Model model, 
			HttpSession session) {
		System.out.println(CLASS_NAME.concat("modifyMenuForm()"));
		
		if (session.getAttribute("loginedAdminMemberId") == null) {
			return "redirect:/admin/menu/loginForm";
		}
		
		String nextPage = "admin/menu/modify_menu_form";
		
		AdminMenuDto adminMenuDto = adminMenuService.modifyMenuForm(m_no);
		model.addAttribute("adminMenuDto", adminMenuDto);
		
		return nextPage;
	}
	
	@PostMapping("/modifyMenuConfirm")
	public String modifyMenuConfirm(
			AdminMenuDto adminMenuDto,
			@RequestParam("file") MultipartFile file) {
		System.out.println(CLASS_NAME.concat("modifyMenuConfirm()"));
		
		String nextPage = "admin/menu/modify_menu_ok";
		
		if (!file.getOriginalFilename().equals("")) {
			String savedFileName = uploadFileService.upload(file);
		}
		
		int result = adminMenuService.modifyMenuConfirm(adminMenuDto);
		
		if (result <= 0)
			nextPage = "admin/menu/modify_menu_ng";
		
		return nextPage;
	}
	
	@GetMapping("/deleteMenuForm")
	public String deleteMenuForm(
			@RequestParam("m_no") int m_no,
			HttpSession session) {
		System.out.println(CLASS_NAME.concat("deleteMenuForm()"));
		
		if (session.getAttribute("loginedAdminMemberId") == null) {
			return "redirect:/admin/menu/loginForm";
		}
		
		String nextPage = "admin/menu/delete_menu_ok";
		
		int result = adminMenuService.deleteMenuConfirm(m_no);
		
		if (result <= 0)
			nextPage = "admin/menu/delete_menu_ng";
		
		return nextPage;	
	}
	
}
