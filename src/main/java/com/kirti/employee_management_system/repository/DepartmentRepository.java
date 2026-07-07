package com.kirti.employee_management_system.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.kirti.employee_management_system.dto.DepartmentSummaryDTO;
import com.kirti.employee_management_system.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{
	  @Query("""
		        SELECT new com.kirti.employee_management_system.dto.DepartmentSummaryDTO(
		            d.id,
		            d.departmentName,
		            d.description,
		            COUNT(e.id)
		        )
		        FROM Department d
		        LEFT JOIN d.employees e
		        GROUP BY d.id, d.departmentName, d.description
		    """)
		    List<DepartmentSummaryDTO> getDepartmentSummary();
}
