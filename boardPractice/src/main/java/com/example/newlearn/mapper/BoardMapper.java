package com.example.newlearn.mapper;

import com.example.newlearn.dto.Criteria;
import com.example.newlearn.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //상품 리스트
    List<ProductDto> getProductBoardList();
    //상품 상세 내용 읽기
    ProductDto productBoardDetail(int no);
    //내 상품 읽어오기
    List<ProductDto> getMyProductList(String id);
    //상품 등록하기
    int productBoardInsert(ProductDto productDto);
    //상품 정보 수정하기
    int productBoardUpdate(ProductDto productDto);
    //상품 삭제하기
    int productBoardDelete(int no);
    //수정할 상품 불러오기
    ProductDto getMyProductInfo(int no);


}
