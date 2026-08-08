# Employee Management System — Backend

A RESTful backend application for managing employees, departments, and organizational reports.

The application is built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL** and provides REST APIs that are consumed by a React frontend.

---

## 🚀 Project Overview

The Employee Management System backend provides APIs for managing employee and department information.

The application currently supports:

- Employee CRUD operations
- Department CRUD operations
- Employee status management
- Department assignment
- Employee pagination
- Dashboard statistics
- Total payroll calculation
- MySQL database integration
- REST API integration with React frontend
- CORS configuration

---

## ✨ Key Features

### 👨‍💼 Employee Management

- Add employee
- View all employees
- View employee by ID
- Update employee
- Delete employee
- Pagination
- Employee status management

Employee information includes:

- Name
- Email
- Salary
- Department
- Status
- Joining date

---

### 🏢 Department Management

- Add department
- View all departments
- View department by ID
- Update department
- Delete department
- Assign employees to departments

---

### 📊 Dashboard Reports

The backend provides dashboard statistics including:

- Total employees
- Total departments
- Active employees
- Total payroll

Example API:

GET /api/reports/dashboard
