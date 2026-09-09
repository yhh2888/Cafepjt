package com.office.cafe.menu.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.office.cafe.admin.AdminMemberDao;

@Service
public class AdminMenuService {
	
	final private String CLASS_NAME = "[AdminMenuService]";
	
	final static public int MENU_REGISTER_SUCCESS 	= 1;
	final static public int MENU_REGISTER_FAIL 		= -1;
	
	final private AdminMenuDao adminMenuDao;
	
	public AdminMenuService(AdminMenuDao adminMenuDao) {
		this.adminMenuDao = adminMenuDao;
	}
	
	public int registerMenuConfirm(AdminMenuDto adminMenuDto) {
		System.out.println(CLASS_NAME.concat("registerMenuConfirm()"));
	
		int result = adminMenuDao.insertMenu(adminMenuDto);
		
		if (result > 0) {
			return MENU_REGISTER_SUCCESS;
		} else {
			return MENU_REGISTER_FAIL;
		}
	}
	
	public List<AdminMenuDto> searchMenuConfirm(String m_name) {
		System.out.println(CLASS_NAME.concat("searchMenuConfirm()"));
		
		return adminMenuDao.selectMenusBySearch(m_name);
		
	}
	
	public AdminMenuDto menuDetail(int m_no) {
		System.out.println(CLASS_NAME.concat("menuDetail()"));

		return adminMenuDao.selectMenuByMNo(m_no);
		
	}
	
	public AdminMenuDto modifyMenuForm(int m_no) {
		System.out.println(CLASS_NAME.concat("modifyMenuForm()"));
		
		return menuDetail(m_no);
		
	}
	
	public int modifyMenuConfirm(AdminMenuDto adminMenuDto) {
		System.out.println(CLASS_NAME.concat("modifyMenuConfirm()"));
		
		return adminMenuDao.updateMenu(adminMenuDto);
	}
	
	public int deleteMenuConfirm(int m_no) {
		System.out.println(CLASS_NAME.concat("deleteMenuConfirm()"));
		
		int result = adminMenuDao.deleteMenu(m_no);
		
		return result;
		
	}
	
	
}	
