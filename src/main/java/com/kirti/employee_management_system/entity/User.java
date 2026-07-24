package com.kirti.employee_management_system.entity;

import jakarta.persistence.*;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
    @OneToOne
    @JoinColumn(name = "employee_id")
    
    private Employee employee;
    public User() {
    }

    public User(Long id,
            String username,
            String password,
            String role,
            Employee employee) {

    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
    this.employee = employee;
}

    public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}