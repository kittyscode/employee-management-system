package com.kirti.employee_management_system.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kirti.employee_management_system.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findByEmail(String email);
	List<Employee> findByName(String name);
	public Page<Employee> findAll(Pageable pageable);
}
