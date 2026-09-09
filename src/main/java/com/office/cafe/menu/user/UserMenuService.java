package com.office.cafe.menu.user;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserMenuService {

	
	final private String CLASS_NAME = "[UserMenuService]";
	final private UserMenuDao userMenuDao;
	
	
	public List<UserMenuDto> searchMenuConfirm(String m_name) {
		System.out.println(CLASS_NAME.concat("searchMenuConfirm()"));
		
		
		return userMenuDao.selectMenusBySearch(m_name);
	}



	public List<UserMenuDto> listMenuConfirm() {
		System.out.println(CLASS_NAME.concat("listMenuConfirm"));
		
		return userMenuDao.selectMenus();
	}



	public UserMenuDto menuDetail(int m_no) {
		System.out.println(CLASS_NAME.concat("menuDetail()"));
		
		return userMenuDao.selectMenuByMNo(m_no);
	}

}
