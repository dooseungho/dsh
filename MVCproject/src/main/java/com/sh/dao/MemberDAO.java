package com.sh.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sh.dto.MemberDTO;

@Repository
public class MemberDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insertMember(MemberDTO member) {
        String insertSql = "INSERT INTO member (id, pw) VALUES (?, ?)";
        jdbcTemplate.update(insertSql, member.getId(), member.getPw());
    }
    
    @SuppressWarnings("deprecation")
    public MemberDTO getMemberByUsername(String username) {
        String selectSql = "SELECT * FROM member WHERE id = ?";
        try {
            List<MemberDTO> members = jdbcTemplate.query(selectSql, new Object[]{username}, (rs, rowNum) -> {
                MemberDTO member = new MemberDTO();
                member.setId(rs.getString("id"));
                member.setPw(rs.getString("pw"));
                return member;
            });

            if (members.isEmpty()) {
                return null;
            }
            
            return members.get(0);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public boolean isValidLogin(String username, String password) {
        String sql = "SELECT COUNT(*) FROM member WHERE id = ? AND pw = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);
        return count == 1;
    }
}
