package com.kirti.employee_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirti.employee_management_system.entity.Department;
import com.kirti.employee_management_system.repository.DepartmentRepository;
import java.util.*;
@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
		
	}
	public List<Department> getAllDepartment(){
		return departmentRepository.findAll();
	}
}
