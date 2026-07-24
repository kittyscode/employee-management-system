package com.kirti.employee_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kirti.employee_management_system.dto.ReportDTO;
import com.kirti.employee_management_system.service.ReportService;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:5173") 
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/dashboard")
    public ReportDTO getDashboardReport() {

        System.out.println("REPORT API HIT");

        return reportService.getDashboardReport();
    }
}