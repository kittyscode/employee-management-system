package com.kirti.employee_management_system.service;


import com.kirti.employee_management_system.dto.ChangePasswordRequest;
import com.kirti.employee_management_system.dto.ProfileResponse;
import com.kirti.employee_management_system.dto.UpdateProfileRequest;
import org.springframework.web.multipart.MultipartFile;
import com.kirti.employee_management_system.dto.UploadImageResponse;

public interface ProfileService {


    ProfileResponse getProfile(String username);



    ProfileResponse updateProfile(
            String username,
            UpdateProfileRequest request
    );



    void changePassword(
            String username,
            ChangePasswordRequest request
    );
    UploadImageResponse uploadProfileImage(
            String username,
            MultipartFile file
    );
}