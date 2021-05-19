package com.example.newlearn.mapper;

import com.example.newlearn.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    String memberCheck(String id);
    MemberDto getMember();
    int memberInsert(MemberDto memberDto);
    int memberUpdate(MemberDto memberDto);
}
