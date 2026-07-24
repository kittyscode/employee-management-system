package com.kirti.employee_management_system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kirti.employee_management_system.dto.ChangePasswordRequest;
import com.kirti.employee_management_system.dto.ProfileResponse;
import com.kirti.employee_management_system.dto.UpdateProfileRequest;
import com.kirti.employee_management_system.entity.Employee;
import com.kirti.employee_management_system.entity.User;
import com.kirti.employee_management_system.repository.UserRepository;
import com.kirti.employee_management_system.service.ProfileService;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;


import com.kirti.employee_management_system.dto.UploadImageResponse;

@Service
public class ProfileServiceImpl implements ProfileService {
	 @Value("${file.upload-dir}")
	    private String uploadDir;


	    private final PasswordEncoder passwordEncoder;
	    private final UserRepository userRepository;
   
    
    public ProfileServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public ProfileResponse getProfile(String username) {

    	User user = userRepository.findByUsername(username)
    	        .orElseThrow(() -> new RuntimeException("User not found"));

    	System.out.println("Username: " + user.getUsername());
    	System.out.println("Employee: " + user.getEmployee());

        Employee employee = user.getEmployee();
        if (employee == null) {
            throw new RuntimeException("Employee is NULL");
        }

        if (employee.getDepartment() == null) {
            throw new RuntimeException("Department is NULL");
        }
        ProfileResponse response = new ProfileResponse();

        response.setEmployeeId(employee.getId());
        response.setUsername(user.getUsername());
        response.setFullName(employee.getName());
        response.setEmail(employee.getEmail());
        response.setPhone(employee.getPhone());
        response.setAddress(employee.getAddress());
        response.setDesignation(employee.getDesignation());
        response.setDepartment(employee.getDepartment().getDepartmentName());
        response.setSalary(employee.getSalary());
        response.setRole(user.getRole());
        response.setStatus(employee.getStatus());
        response.setProfileImage(
                employee.getProfileImage()
        );
        if (employee.getJoiningDate() != null) {
            response.setJoiningDate(employee.getJoiningDate().toString());
        }
      
        return response;
    }

    @Override
    public ProfileResponse updateProfile(
            String username,
            UpdateProfileRequest request
    ) {


        User user = userRepository
                .findByUsername(username)
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );


        Employee employee = user.getEmployee();


        if(employee == null){
            throw new RuntimeException("Employee not found");
        }



        employee.setName(
                request.getFullName()
        );


        employee.setPhone(
                request.getPhone()
        );


        employee.setAddress(
                request.getAddress()
        );



        userRepository.save(user);



        return getProfile(username);

    }

    @Override
    public void changePassword(String username, ChangePasswordRequest request) {

        System.out.println("===== CHANGE PASSWORD =====");
        System.out.println("Username : " + username);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        System.out.println("User Found : " + user.getUsername());
        System.out.println("DB Password : " + user.getPassword());
        System.out.println("Current Password : " + request.getCurrentPassword());

        boolean matches = passwordEncoder.matches(
                request.getCurrentPassword(),
                user.getPassword()
        );

        System.out.println("Password Match : " + matches);

        if (!matches) {
            throw new RuntimeException("Current password incorrect");
        }

        String encodedPassword = passwordEncoder.encode(request.getNewPassword());

        System.out.println("Encoded Password : " + encodedPassword);

        user.setPassword(encodedPassword);

        userRepository.save(user);

        System.out.println("Password Updated Successfully");
    }
//    @Override
//    public UploadImageResponse uploadProfileImage(
//            String username,
//            MultipartFile file
//    ) {
//
//        User user = userRepository
//                .findByUsername(username)
//                .orElseThrow(
//                        () -> new RuntimeException("User not found")
//                );
//
//
//        Employee employee = user.getEmployee();
//
//
//        if(employee == null){
//            throw new RuntimeException("Employee not found");
//        }
//
//
//        // temporary implementation
//        // actual file saving logic will come later
//
//        employee.setProfileImage(
//                file.getOriginalFilename()
//        );
//
//
//        userRepository.save(user);
//
//
//        UploadImageResponse response = new UploadImageResponse();
//
//        response.setMessage("Profile image uploaded successfully");
//
//        response.setFileName(
//                file.getOriginalFilename()
//        );
//
//
//        return response;
//    }
    @Override
    public UploadImageResponse uploadProfileImage(
            String username,
            MultipartFile file
    ) {


        User user = userRepository
                .findByUsername(username)
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );


        Employee employee = user.getEmployee();


        if(employee == null){
            throw new RuntimeException("Employee not found");
        }


        try {


            // create folder if not exists

            Path uploadPath = Paths.get(uploadDir);


            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }



            // generate unique filename

            String originalFileName =
                    file.getOriginalFilename();


            String extension = "";


            if(originalFileName.contains(".")){
                extension =
                  originalFileName.substring(
                    originalFileName.lastIndexOf(".")
                  );
            }



            String fileName =
                    UUID.randomUUID()
                    + extension;



            // save file

            Path filePath =
                    uploadPath.resolve(fileName);



            Files.copy(
                    file.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING
            );



            // save filename in database

            employee.setProfileImage(fileName);


            userRepository.save(user);



            UploadImageResponse response = new UploadImageResponse();

            response.setFileName(fileName);

            response.setImageUrl(
            	    "http://localhost:8082/uploads/profile/" + fileName
            	);

            response.setMessage(
                "Profile image uploaded successfully"
            );

            return response;



        }
        catch(IOException e){

            throw new RuntimeException(
                    "Image upload failed"
            );

        }

    }
}
