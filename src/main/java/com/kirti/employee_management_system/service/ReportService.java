package com.kirti.employee_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirti.employee_management_system.dto.ReportDTO;
import com.kirti.employee_management_system.repository.DepartmentRepository;
import com.kirti.employee_management_system.repository.EmployeeRepository;

@Service
public class ReportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public ReportDTO getDashboardReport() {


        ReportDTO report = new ReportDTO();

        report.setTotalEmployees(employeeRepository.count());

        report.setTotalDepartments(departmentRepository.count());

        report.setActiveEmployees(employeeRepository.countByStatus("Active"));

        report.setTotalPayroll(employeeRepository.getTotalPayroll());

        return report;
    }
}