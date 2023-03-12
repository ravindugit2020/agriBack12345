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
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
