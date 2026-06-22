package com.kirti.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirti.employee_management_system.entity.Department;
import com.kirti.employee_management_system.service.DepartmentService;



@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public Department saveDepartment(@RequestBody Department department){
				return departmentService.saveDepartment(department);
			}
	@GetMapping
	public List<Department> getAllDepartments(){
		return departmentService.getAllDepartment();
	}
}
