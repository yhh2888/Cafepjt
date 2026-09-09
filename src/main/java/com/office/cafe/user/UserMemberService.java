package com.office.cafe.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserMemberService {

	final private String CLASS_NAME = "[UserMemberService] ";
	
	final static public int USER_ACCOUNT_ALREADY_EXIST = 0;
	final static public int USER_ACCOUNT_CREATE_SUCCESS = 1;
	final static public int USER_ACCOUNT_CREATE_FAIL = -1;

	final private UserMemberDao userMemberDao;
	final PasswordEncoder passwordEncoder;

	public int createAccountConfirm(UserMemberDto userMemberDto) {
		System.out.println(CLASS_NAME.concat("createAccountConfirm"));
		
		boolean isMember = userMemberDao.isUser(userMemberDto.getU_m_id());
		
		if (!isMember) {
			
			String encodedPassword = passwordEncoder.encode(userMemberDto.getU_m_pw());
			userMemberDto.setU_m_pw(encodedPassword);
			
			int result = userMemberDao.insertUserAccount(userMemberDto);
			
			if (result > 0)
				return USER_ACCOUNT_CREATE_SUCCESS;
			else
				return USER_ACCOUNT_CREATE_FAIL;
			
		} else {
			return USER_ACCOUNT_ALREADY_EXIST;
		}
		
	}
}
