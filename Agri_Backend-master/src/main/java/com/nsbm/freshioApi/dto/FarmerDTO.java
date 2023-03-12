package com.nsbm.freshioApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FarmerDTO {
    private int farmer_id;
    private String farmer_name;
    private String farmer_password;
    private String farmer_contact;
    private String farmer_image;
    private String fertilizer;
    private String status;
}
