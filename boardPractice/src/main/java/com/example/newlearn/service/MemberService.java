package com.example.newlearn.service;

import com.example.newlearn.dto.MemberDto;
import com.example.newlearn.dto.ProductDto;

import java.util.List;

public interface MemberService {

    boolean memberCheck(String id, String pw);
    MemberDto getMember();
    int memberInsert(MemberDto memberDto);
    int memberUpdate(MemberDto memberDto);
}
