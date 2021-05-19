package com.example.newlearn.mapper;

import com.example.newlearn.dto.Criteria;
import com.example.newlearn.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 읽기
    List<ProductDto> getProductBoardList();
    // 자세히 읽기
    ProductDto productBoardDetail(int no);
    // 삽입하기
    int productBoardInsert(ProductDto productDto);
    // 수정하기
    int productBoardUpdate(ProductDto productDto);
    //삭제하기
    int productBoardDelete(int no);


}
