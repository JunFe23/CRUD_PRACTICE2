package com.example.newlearn.service;

import com.example.newlearn.dto.ProductDto;

import java.util.List;

public interface BoardService {

    List<ProductDto> getProductList();
    List<ProductDto> getMyProductList(String id);
    ProductDto productBoardDetail(int no);
    int productBoardInsert(ProductDto productDto);
    int productBoardUpdate(ProductDto productDto);
    int productBoardDelete(int no);
    ProductDto getMyProductInfo(int id);
}
