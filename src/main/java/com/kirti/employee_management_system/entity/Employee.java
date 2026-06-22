package com.kirti.employee_management_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @Email
    @Column(unique=true)
    private String email;
    @Positive
    private Double salary;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
    
//    // Default Constructor
//    public Employee() {
//    }
//
//    public Department getDepartment() {
//		return department;
//	}
//
//	
//
//	// Parameterized Constructor
//    public Employee(Long id, String name, String email, Double salary) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.salary = salary;
//    }
//
//    // Getters and Setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
////
//    public void setName(String name) {
//        this.name = name;
//    }
//   
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Double salary) {
//        this.salary = salary;
//    }
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}

	
   
 }
