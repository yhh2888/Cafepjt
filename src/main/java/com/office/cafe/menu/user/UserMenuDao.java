package com.office.cafe.menu.user;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserMenuDao {
	
	final private String CLASS_NAME = "[UserMenuDao]";
	final private JdbcTemplate jdbcTemplate;


	public List<UserMenuDto> selectMenusBySearch(String m_name) {
		System.out.println(CLASS_NAME.concat("selectMenusBySearch()"));
		
		String sql = "SELECT * FROM tbl_menu "
					+ "WHERE m_name LIKE ? ORDER BY m_no desc";
		
		List<UserMenuDto> userMenuDtos = null;
		
		try {
			
			RowMapper<UserMenuDto> rowMapper = 
					BeanPropertyRowMapper.newInstance(UserMenuDto.class);
			
			userMenuDtos = jdbcTemplate.query(sql, rowMapper, "%" + m_name + "%");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userMenuDtos.size() > 0 ? userMenuDtos : null;
	}


	public List<UserMenuDto> selectMenus() {
		System.out.println(CLASS_NAME.concat("selectMenus()"));
		
		String sql = "select * from tbl_menu";
		
		List<UserMenuDto> userMenuDtos = 
				jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UserMenuDto.class));
		
		return userMenuDtos;
	}


	public UserMenuDto selectMenuByMNo(int m_no) {
		System.out.println(CLASS_NAME.concat("selectMenuByMNo()"));
		
		String sql = "SELECT * FROM tbl_menu "
					+ "WHERE m_no = ?";
		
		List<UserMenuDto> userMenuDtos = null;
		
		try {
			RowMapper<UserMenuDto> rowMapper = 
					BeanPropertyRowMapper.newInstance(UserMenuDto.class);
			
			userMenuDtos = jdbcTemplate.query(sql, rowMapper, m_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userMenuDtos.size() > 0 ? userMenuDtos.get(0) : null;
	}
	
}
