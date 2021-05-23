package com.example.newlearn.service;

import com.example.newlearn.dto.ProductDto;
import com.example.newlearn.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;

    @Override
    public List<ProductDto> getProductList() {
        return boardMapper.getProductBoardList();
    }

    @Override
    public List<ProductDto> getMyProductList(String id) {
        return boardMapper.getMyProductList(id);
    }

    @Override
    public ProductDto productBoardDetail(int no) {
        return boardMapper.productBoardDetail(no);
    }

    @Override
    public int productBoardInsert(ProductDto productDto) {
        return boardMapper.productBoardInsert(productDto);
    }

    @Override
    public int productBoardUpdate(ProductDto productDto) {
        return boardMapper.productBoardUpdate(productDto);
    }

    @Override
    public int productBoardDelete(int no) {
        return boardMapper.productBoardDelete(no);
    }
}
