package com.kirti.employee_management_system.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirti.employee_management_system.service.EmployeeExportService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeExportController {

    @Autowired
    private EmployeeExportService employeeExportService;

    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> exportEmployees()
            throws IOException {

        ByteArrayInputStream excelFile =
                employeeExportService.exportEmployees();

        HttpHeaders headers = new HttpHeaders();

        headers.add(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=employees.xlsx"
        );

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(
                        MediaType.parseMediaType(
                                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(excelFile));
    }

}