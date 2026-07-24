package com.kirti.employee_management_system.controller;
import org.springframework.web.multipart.MultipartFile;
import com.kirti.employee_management_system.dto.UploadImageResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.kirti.employee_management_system.dto.ProfileResponse;
import com.kirti.employee_management_system.dto.UpdateProfileRequest;
import com.kirti.employee_management_system.service.ProfileService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kirti.employee_management_system.dto.ChangePasswordRequest;
import org.springframework.web.multipart.MultipartFile;
import com.kirti.employee_management_system.dto.UploadImageResponse;
@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins="http://localhost:5173")
public class ProfileController {


    private final ProfileService profileService;


    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }



    @GetMapping
    public ProfileResponse getProfile(Authentication authentication){

        String username = authentication.getName();

        return profileService.getProfile(username);
    }



    @PutMapping
    public ProfileResponse updateProfile(
            Authentication authentication,
            @RequestBody UpdateProfileRequest request
    ){

        String username = authentication.getName();

        return profileService.updateProfile(
                username,
                request
        );
    }

//    @PutMapping("/change-password")
//    public ResponseEntity<?> changePassword(
//            Authentication authentication,
//            @RequestBody ChangePasswordRequest request
//    ){
//
//        String username = authentication.getName();
//
//        profileService.changePassword(
//                username,
//                request
//        );
//
//        return ResponseEntity.ok(
//                "Password changed successfully"
//        );
//    }
    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(
            Authentication authentication,
            @RequestBody ChangePasswordRequest request
    ) {

        System.out.println("========= CONTROLLER =========");

        System.out.println(authentication);

        System.out.println(request.getCurrentPassword());
        System.out.println(request.getNewPassword());

        String username = authentication.getName();

        System.out.println(username);

        profileService.changePassword(username, request);

        return ResponseEntity.ok("Password changed successfully");
    }
    @PostMapping("/upload-image")
    public UploadImageResponse uploadProfileImage(
            Authentication authentication,
            @RequestParam("file") MultipartFile file
    ) {

    	String username = authentication.getName();


        return profileService.uploadProfileImage(
                username,
                file
        );
    }
}