package com.nsbm.freshioApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpertDTO {
    private int expert_id;
    private String expert_name;
    private String expert_password;
    private String expert_title;
    private String expert_desc;
    private String expert_contact;
    private String expert_mail;
    private String expert_img;
    private String status;
}
