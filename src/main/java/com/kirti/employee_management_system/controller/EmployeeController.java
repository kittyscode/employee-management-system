package com.kirti.employee_management_system.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kirti.employee_management_system.exception.EmployeeNotFoundException;
import com.kirti.employee_management_system.repository.DepartmentRepository;
import com.kirti.employee_management_system.dto.EmployeeDTO;
import com.kirti.employee_management_system.entity.Department;
import com.kirti.employee_management_system.entity.Employee;
import com.kirti.employee_management_system.service.EmployeeService;
import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/employees")
//@CrossOrigin(origins = "*") // Optional: allows requests from frontend
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentRepository departmentRepository;
    
    
    
    // Create Employee
    @PostMapping
    public Employee saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setSalary(employeeDTO.getSalary());
        Department department =
        		departmentRepository.findById(employeeDTO.getDepartmentId())
        	        .orElseThrow(() -> new RuntimeException("Department not found"));

        employee.setDepartment(department);

        return employeeService.saveEmployee(employee);
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(
                employeeService.getEmployees(PageRequest.of(page, size)));
    }
      

//    // Get All Employees
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found with id "+id));
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return "Employee Deleted Successfully!";
    }
    
    @GetMapping("/email/{email}")
    public Employee getEmployeeByEmail(@PathVariable String email) {
    	return employeeService.getEmployeeByEmail(email);
    }
    
    @GetMapping("/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
    	return employeeService.getEmployeeByName(name);
    }
//    @GetMapping("/page")
//    public Page<Employee> getEmployeeWithPagination(@RequestParam int page,@RequestParam int size){
//    	return employeeService.getEmployees(PageRequest.of(page,size));
//    		
//    	}
    @GetMapping("/sort")
    public List<Employee> getEmployeesSorted(){
    	return employeeService.getEmployeeSorted();
    			
    }
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(
            @RequestParam String keyword) {

        return ResponseEntity.ok(
                employeeService.searchEmployees(keyword));
    }
    
    }
    	
    
