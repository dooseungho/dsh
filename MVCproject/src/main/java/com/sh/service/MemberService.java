package com.sh.service;

import com.sh.dto.MemberDTO;

public interface MemberService {
    void insertMember(MemberDTO member);
    MemberDTO getMemberByUsername(String username);
    boolean isValidLogin(String username, String password);
}
