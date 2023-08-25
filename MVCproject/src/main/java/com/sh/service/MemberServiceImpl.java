package com.sh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.dao.MemberDAO;
import com.sh.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Transactional
    @Override
    public void insertMember(MemberDTO member) {
        memberDAO.insertMember(member);
    }

    @Override
    public MemberDTO getMemberByUsername(String username) {
        return memberDAO.getMemberByUsername(username);
    }

    @Override
    public boolean isValidLogin(String username, String password) {
        return memberDAO.isValidLogin(username, password);
    }
}
