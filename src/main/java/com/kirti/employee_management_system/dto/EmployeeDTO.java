package com.kirti.employee_management_system.dto;

import java.time.LocalDate;

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
	private String phone;

	private String address;

	private String designation;

	private LocalDate joiningDate;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	private String status;

	private String profileImage;
		
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
