package com.nsbm.freshioApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int user_id;
    private String user_name;
    private String user_password;
    private String status;
}
