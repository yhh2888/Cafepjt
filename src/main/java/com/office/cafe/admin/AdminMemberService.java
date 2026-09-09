package com.office.cafe.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminMemberService {

    final static public int ACCOUNT_ALREADY_EXIST = 0;
    final static public int ACCOUNT_CREATE_SUCCESS = 1;
    final static public int ACCOUNT_CREATE_FAIL = -1;

    @Autowired
    private AdminMemberDao adminMemberDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입
    public int join(AdminMemberDto dto) {
        boolean isMember = adminMemberDao.isAdminMember(dto.getAmId());

        if (isMember) {
            return ACCOUNT_ALREADY_EXIST;
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(dto.getAmPw());
        dto.setAmPw(encodedPassword);

        int result = adminMemberDao.insertAdminMember(dto);

        return result > 0 ? ACCOUNT_CREATE_SUCCESS : ACCOUNT_CREATE_FAIL;
    }

    // 로그인 검증
    public AdminMemberDto login(String amId, String amPw) {
        AdminMemberDto dto = adminMemberDao.findByAmId(amId);

        if (dto == null) {
            return null; // 아이디 없음
        }

        if (!passwordEncoder.matches(amPw, dto.getAmPw())) {
            return null; // 비밀번호 불일치
        }

        return dto; // 로그인 성공
    }

    // 회원정보 수정
    public int updateInfo(AdminMemberDto dto) {
        return adminMemberDao.updateAdminMember(dto);
    }
}