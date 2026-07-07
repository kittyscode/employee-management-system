package com.kirti.employee_management_system.dto;

public class ReportDTO {
	 private Long totalEmployees;
	    private Long totalDepartments;
	    private Long activeEmployees;
	    private Double totalPayroll;
		public Long getTotalEmployees() {
			return totalEmployees;
		}
		public void setTotalEmployees(Long totalEmployees) {
			this.totalEmployees = totalEmployees;
		}
		public Long getTotalDepartments() {
			return totalDepartments;
		}
		public void setTotalDepartments(Long totalDepartments) {
			this.totalDepartments = totalDepartments;
		}
		public Long getActiveEmployees() {
			return activeEmployees;
		}
		public void setActiveEmployees(Long activeEmployees) {
			this.activeEmployees = activeEmployees;
		}
		public Double getTotalPayroll() {
			return totalPayroll;
		}
		public void setTotalPayroll(Double totalPayroll) {
			this.totalPayroll = totalPayroll;
		}
}
