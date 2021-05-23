package com.example.newlearn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(of = {"no","productname","img","country","price","kinds","redgdate","id"})
public class ProductDto {
    private int    no;
    private String id;
    private String productName;
    private String productPrice;
    private String productOrigin;
    private String productCategory;
    private String fileName;
    private String regdate;
}
