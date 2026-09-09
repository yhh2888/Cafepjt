package com.office.cafe.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminMemberDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 아이디 중복확인
    public boolean isAdminMember(String amId) {
        String sql = "SELECT COUNT(*) FROM tbl_admin_member WHERE a_m_id = ?";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, amId);
        return result > 0;
    }

    // 회원가입
    public int insertAdminMember(AdminMemberDto dto) {
        String sql = "INSERT INTO tbl_admin_member (a_m_id, a_m_pw, a_m_name, a_m_phone) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, dto.getAmId(), dto.getAmPw(), dto.getAmName(), dto.getAmPhone());
    }

    // 아이디로 조회 (로그인, 정보수정용)
    public AdminMemberDto findByAmId(String amId) {
        String sql = "SELECT * FROM tbl_admin_member WHERE a_m_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(AdminMemberDto.class), amId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // 회원정보 수정
    public int updateAdminMember(AdminMemberDto dto) {
        String sql = "UPDATE tbl_admin_member SET a_m_pw = ?, a_m_name = ?, a_m_phone = ? WHERE a_m_id = ?";
        return jdbcTemplate.update(sql, dto.getAmPw(), dto.getAmName(), dto.getAmPhone(), dto.getAmId());
    }
}