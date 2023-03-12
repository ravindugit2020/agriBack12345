package com.nsbm.freshioApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Problem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int problem_id;

    private String problem_title;
    private String problem_desc;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    private String status;
    private String farmer_name;
    private String farmer_image;
}
