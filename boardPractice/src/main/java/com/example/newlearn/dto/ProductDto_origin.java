package com.example.newlearn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"no","productname","img","country","price","kinds","redgdate","id"})
public class ProductDto_origin {

    private int no;
    private String productname;
    private String img;
    private String country;
    private int price;
    private String kinds;
    private String regdate;
    private String id;

}
