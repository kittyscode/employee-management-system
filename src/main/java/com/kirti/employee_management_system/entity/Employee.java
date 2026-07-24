package com.kirti.employee_management_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDate;

@Entity

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @Email
    @Column(unique=true)
    private String email;
    private String phone;

    private String address;

    private String designation;

    private LocalDate joiningDate;
    @Positive
    private Double salary;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
    @Column(nullable = false)
    private String status = "Active";
    @Column(name = "profile_image")
    private String profileImage;
   
 }
