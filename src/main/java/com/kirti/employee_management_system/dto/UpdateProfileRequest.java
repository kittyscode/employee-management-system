package com.kirti.employee_management_system.dto;


import lombok.Data;


@Data
public class UpdateProfileRequest {


    private String fullName;

    private String phone;

    private String address;

}