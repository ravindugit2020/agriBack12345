package com.nsbm.freshioApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int farmer_id;
    private String farmer_name;
    private String farmer_password;
    private String farmer_contact;
    private String farmer_image;
    private String fertilizer;
    private String status;
}
