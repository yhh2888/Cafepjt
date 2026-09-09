package com.office.cafe.menu.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.office.cafe.menu.admin.AdminMenuDto;

@Repository
public class AdminMenuDao {
	final private String CLASS_NAME = "[AdminMenuDao] ";
	
	final private JdbcTemplate jdbcTemplate;
	
	public AdminMenuDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insertMenu(AdminMenuDto adminMenuDto) {
		System.out.println(CLASS_NAME.concat("insertMenu()"));
		
		String sql =  "INSERT INTO "
						+ "tbl_menu("
							+ "m_no, "
							+ "m_name, "
							+ "m_pay, "
							+ "m_marketing, "
							+ "m_reg_date, "
							+ "m_mod_date)"
						+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		int result = -1;
		try {
			result = jdbcTemplate.update(sql, 
											adminMenuDto.getM_no(),
											adminMenuDto.getM_name(),
											adminMenuDto.getM_pay(),
											adminMenuDto.getM_marketing(),
											adminMenuDto.getM_reg_date(),
											adminMenuDto.getM_mod_date()
											);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	public List<AdminMenuDto> selectMenusBySearch(String m_name) {
		System.out.println(CLASS_NAME.concat("selectMenusBySearch()"));
		
		String sql = "SELECT * FROM tbl_menu WHERE m_name LIKE ? ORDER BY m_no DESC";
		
		List<AdminMenuDto> adminMenuDtos = null;
		
		try {
			adminMenuDtos = jdbcTemplate.query(sql, new RowMapper<AdminMenuDto>() {
				@Override
				public AdminMenuDto mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					AdminMenuDto adminMenuDto = new AdminMenuDto();
					
					adminMenuDto.setM_no(rs.getInt("m_no"));
					adminMenuDto.setM_name(rs.getString("m_name"));
					adminMenuDto.setM_pay(rs.getString("m_pay"));
					adminMenuDto.setM_marketing(rs.getString("m_marketing"));
					adminMenuDto.setM_reg_date(rs.getString("m_reg_date"));
					adminMenuDto.setM_mod_date(rs.getString("m_mod_date"));
					
					return adminMenuDto;
				}
				
			}, "%" + m_name + "%");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return adminMenuDtos.size() > 0 ? adminMenuDtos : null;
	}
	
	public AdminMenuDto selectMenuByMNo(int m_no) {
		System.out.println(CLASS_NAME.concat("selectMenuByMNo()"));
		
		String sql = "SELECT * FROM tbl_menu WHERE m_no = ?";
		
		List<AdminMenuDto> adminMenuDtos = null;
		
		try {
			adminMenuDtos = jdbcTemplate.query(sql, new RowMapper<AdminMenuDto>() {
				@Override
				public AdminMenuDto mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					AdminMenuDto adminMenuDto = new AdminMenuDto();
					
					adminMenuDto.setM_no(rs.getInt("m_no"));
					adminMenuDto.setM_name(rs.getString("m_name"));
					adminMenuDto.setM_pay(rs.getString("m_pay"));
					adminMenuDto.setM_marketing(rs.getString("m_marketing"));
					adminMenuDto.setM_reg_date(rs.getString("m_reg_date"));
					adminMenuDto.setM_mod_date(rs.getString("m_mod_date"));
					
					return adminMenuDto;
				}
				
			}, m_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return adminMenuDtos.size() > 0 ? adminMenuDtos.get(0) : null;
	}
	
	public int updateMenu(AdminMenuDto adminMenuDto) {
		System.out.println(CLASS_NAME.concat("updateMenu()"));
		
		List<String> args = new ArrayList<String>();
		
		String sql = "UPDATE tbl_menu SET ";
		
		
		sql += "m_name = ?, ";
		args.add(adminMenuDto.getM_name());
		
		
		sql += "m_pay = ?, ";
		args.add(adminMenuDto.getM_pay());
		
		sql += "m_marketing = ?, ";
		args.add(adminMenuDto.getM_marketing());
		
		sql += "m_reg_date = ? ";
		args.add((adminMenuDto.getM_reg_date()));
		
		sql += "m_mod_date = ? ";
		args.add((adminMenuDto.getM_mod_date()));
		
		sql += "WHERE m_no = ?";
		args.add(Integer.toString(adminMenuDto.getM_no()));
		
		int result = -1;
		try {
			result = jdbcTemplate.update(sql, args.toArray());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
	}
	
	public int deleteMenu(int m_no) {
		System.out.println(CLASS_NAME.concat("deleteMenu()"));
		
		String sql = "DELETE FROM tbl_menu WHERE m_no = ?";
		
		int result = -1;
		
		try {
			result = jdbcTemplate.update(sql, m_no);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
}
