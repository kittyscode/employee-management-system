package com.kirti.employee_management_system.dto;

public class DepartmentSummaryDTO {

    private Long id;
    private String departmentName;
    private String description;
    private Long employeeCount;

    public DepartmentSummaryDTO(Long id, String departmentName,
                                String description, Long employeeCount) {
        this.id = id;
        this.departmentName = departmentName;
        this.description = description;
        this.employeeCount = employeeCount;
    }

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDescription() {
        return description;
    }

    public Long getEmployeeCount() {
        return employeeCount;
    }
}