package com.nsbm.freshioApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private int product_id;
    private String product_title;
    private String product_desc;
    private String product_img;
    private String product_price;
    private String fertilizer;
    private String status;
    private String farmer_name;
    private String farmer_contact;
}
