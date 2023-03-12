package com.nsbm.freshioApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class CountingDTO {
    private String all;
    private String chemical;
    private String natural;
    private String both;


}
