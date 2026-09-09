package com.office.cafe.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserMemberDao {
	
	final private String CLASS_NAME = "[UserMemberDao] ";
	
	final private JdbcTemplate jdbcTemplate;
	
	public boolean isUser(String u_m_id) {
		System.out.println(CLASS_NAME.concat("isUser()"));
	
		String sql = "SELECT COUNT(*) FROM tbl_user_member "
					+ "WHERE u_m_id = ?";
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class, u_m_id);
		
		return result > 0 ? true : false;
		
	}

	public int insertUserAccount(UserMemberDto userMemberDto) {
		System.out.println(CLASS_NAME.concat("insertUserAccount()"));
		
		String sql = "INSERT into tbl_user_member(u_m_id, "
												+ "u_m_pw, "
												+ "u_m_name, "
												+ "u_m_phone) "
												+ "VALUES(?, ?, ?, ?)";
		
		int result = -1;
		
		try {
			
			result = jdbcTemplate.update(sql,
											userMemberDto.getU_m_id(),
											userMemberDto.getU_m_pw(),
											userMemberDto.getU_m_name(),
											userMemberDto.getU_m_phone());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}

}
