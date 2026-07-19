package com.kirti.employee_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.kirti.employee_management_system.dto.DepartmentSummaryDTO;
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
	public Department getDepartmentById(Long id) {
	    return departmentRepository.findById(id).orElse(null);
	}

	public Department updateDepartment(Long id, Department department) {
	    Department existing = departmentRepository.findById(id).orElse(null);

	    if (existing != null) {
	        existing.setDepartmentName(department.getDepartmentName());
	        existing.setDescription(department.getDescription());

	        return departmentRepository.save(existing);
	    }

	    return null;
	}

	public void deleteDepartment(Long id) {
	    departmentRepository.deleteById(id);
	}


	public List<DepartmentSummaryDTO> getDepartmentSummary() {
	    return departmentRepository.getDepartmentSummary();
	}
	public List<Department> searchDepartments(String keyword) {
	    return departmentRepository.findByDepartmentNameContainingIgnoreCase(keyword);
	}
	
}
