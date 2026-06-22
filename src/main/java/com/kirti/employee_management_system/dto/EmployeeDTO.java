package com.kirti.employee_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class EmployeeDTO {
	@NotBlank(message="Name cannot be blank")
	private String name;
	@Email(message="Please enter valid email")
	 @NotBlank(message = "Email cannot be blank")
	private String email;
	@Positive(message="Salay must be greater than zero")
	private Double salary;
	private Long departmentId;
		
	public Long getDepartmentId() {
	    return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
	    this.departmentId = departmentId;
	}
	  public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Double getSalary() {
	        return salary;
	    }

	    public void setSalary(Double salary) {
	        this.salary = salary;
	    }

}
