package com.example.newlearn.dto;

import com.example.newlearn.paging.Criteria;
import com.example.newlearn.paging.PaginationInfo;
import lombok.Data;

@Data
public class CommonDto extends Criteria {
    /** 페이징 정보 */
    private PaginationInfo paginationInfo;
}
