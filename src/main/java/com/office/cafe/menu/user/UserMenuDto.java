package com.office.cafe.menu.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMenuDto {

	private int m_no;
	private String m_name;
	private String m_pay;
	private String m_marketing;
	private String m_reg_date;
	private String m_mod_date;
	
	
}
