package com.example.newlearn.service;

import com.example.newlearn.paging.Criteria;
import com.example.newlearn.dto.ProductDto;
import com.example.newlearn.mapper.BoardMapper;
import com.example.newlearn.paging.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    @Override
    public ProductDto getMyProductInfo(int no) {
        return boardMapper.getMyProductInfo(no);
    }

    @Override
    public List<ProductDto> getProductList(ProductDto params) {
        List<ProductDto> productList = Collections.emptyList();

        int productTotalCount = boardMapper.selectProductTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(productTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (productTotalCount > 0) {
            productList = boardMapper.selectProductList(params);
        }

        return productList;
    }
}
