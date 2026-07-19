package com.kirti.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kirti.employee_management_system.entity.Department;
import com.kirti.employee_management_system.service.DepartmentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/departments")
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
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
	    return departmentService.getDepartmentById(id);
	}

	@PutMapping("/{id}")
	public Department updateDepartment(
	        @PathVariable Long id,
	        @RequestBody Department department) {

	    return departmentService.updateDepartment(id, department);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable Long id) {
	    departmentService.deleteDepartment(id);
	}
	@GetMapping("/search")
	public ResponseEntity<List<Department>> searchDepartments(
	        @RequestParam String keyword) {

	    return ResponseEntity.ok(
	            departmentService.searchDepartments(keyword));

	}
	
	
}
