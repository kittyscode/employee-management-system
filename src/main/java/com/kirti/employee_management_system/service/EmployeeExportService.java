package com.kirti.employee_management_system.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirti.employee_management_system.entity.Employee;
import com.kirti.employee_management_system.repository.EmployeeRepository;
import com.kirti.employee_management_system.util.ExcelExporter;

@Service
public class EmployeeExportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ByteArrayInputStream exportEmployees() throws IOException {

        List<Employee> employees = employeeRepository.findAll();

        return ExcelExporter.exportEmployees(employees);

    }

}