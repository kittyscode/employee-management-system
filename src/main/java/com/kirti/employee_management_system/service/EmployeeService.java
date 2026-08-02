package com.kirti.employee_management_system.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.kirti.employee_management_system.entity.Employee;
import com.kirti.employee_management_system.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
//	private static final Integer Long = null;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	private static final Logger logger=
			LoggerFactory.getLogger(EmployeeService.class);
	
	public Employee saveEmployee(Employee employee) {
		logger.info("Saving employee :{}",employee.getName());
		
		Employee savedEmployee=employeeRepository.save(employee);
		
		logger.info("Employee saved successfully with id:{}",
				savedEmployee.getId());
		return savedEmployee;
	}
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	

	  // Get Employee By ID
//    public Employee getById(Long id) {
//        return employeeRepository.findById(id).orElse(null);
//    }

	public Optional<Employee> findById(Long id) {
	    return employeeRepository.findById(id);
	}
//    public Employee findById(Long id) {
//        return employeeRepository.findById(id).orElse(null);
//    }
	public Employee update(Long id, Employee employeeDetails) {

	    Employee employee = employeeRepository.findById(id).orElse(null);

	    if (employee != null) {

	        employee.setName(employeeDetails.getName());
	        employee.setEmail(employeeDetails.getEmail());
	        employee.setPhone(employeeDetails.getPhone());
	        employee.setAddress(employeeDetails.getAddress());
	        employee.setDesignation(employeeDetails.getDesignation());
	        employee.setJoiningDate(employeeDetails.getJoiningDate());
	        employee.setSalary(employeeDetails.getSalary());
	        employee.setDepartment(employeeDetails.getDepartment());
	        employee.setStatus(employeeDetails.getStatus());
	        employee.setProfileImage(employeeDetails.getProfileImage());

	        return employeeRepository.save(employee);
	    }

	    return null;
	}
    // Delete Employee
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
    
    public Employee getEmployeeByEmail(String email) {
    	return employeeRepository.findByEmail(email);
    }
    public List<Employee> getEmployeeByName(String name) {
    	return employeeRepository.findByName(name);
    }
    public Page<Employee> getEmployees(Pageable pageable)
    {
    	return employeeRepository.findAll(pageable);
    }
    public List<Employee> getEmployeeSorted(){
    	return employeeRepository.findAll(
    			Sort.by("name").descending());
    }
   
    public List<Employee> searchEmployees(String keyword) {

        return employeeRepository.findByNameContainingIgnoreCase(keyword);

    }
   
    
	
}
