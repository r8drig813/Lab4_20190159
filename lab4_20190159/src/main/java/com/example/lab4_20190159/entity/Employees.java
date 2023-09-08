package com.example.lab4_20190159.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    @Column(name = "first_name",nullable = false,length = 25)
    private String first_name;

    @Column(name = "last_name",nullable = false,length = 20)
    private String last_name;

    @Column(name = "job_id",nullable = false,length = 10)
    private String job_id;

    @Column(name = "department_id",nullable = false)
    private Integer department_id;

    /*@Column(name = "",nullable = false,length = 25)
    private String first_name;*/

    @Column(name = "phone_number",nullable = false,length = 20)
    private String phone_number;

    @Column(name = "salary",nullable = false)
    private Double salary;
}
