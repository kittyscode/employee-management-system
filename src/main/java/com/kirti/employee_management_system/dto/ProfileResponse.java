package com.kirti.employee_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponse {

    private Long employeeId;

    private String username;

    private String fullName;

    private String email;

    private String phone;

    private String address;

    private String designation;

    private String department;

    private Double salary;

    private String role;

    private String status;

    private String joiningDate;
    private String profileImage;

}