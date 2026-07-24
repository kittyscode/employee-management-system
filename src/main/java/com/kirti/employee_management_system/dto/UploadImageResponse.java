package com.kirti.employee_management_system.dto;

import lombok.Data;

@Data
public class UploadImageResponse {

    private String message;

    private String fileName;

    private String imageUrl;

}