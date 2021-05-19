package com.example.newlearn.service;

import com.example.newlearn.dto.MemberDto;
import com.example.newlearn.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="memberService")
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberMapper memberMapper;

    @Override
    public boolean memberCheck(String id, String pw) {
        String dbPass=memberMapper.memberCheck(id);
        return dbPass!=null&&dbPass.equals(pw);
    }

    @Override
    public MemberDto getMember() {
        return null;
    }

    @Override
    public int memberInsert(MemberDto memberDto) {
        return memberMapper.memberInsert(memberDto);
    }

    @Override
    public int memberUpdate(MemberDto memberDto) {
        return 0;
    }
}
