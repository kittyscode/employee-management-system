package com.kirti.employee_management_system.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kirti.employee_management_system.entity.Employee;
public class ExcelExporter {

    public static ByteArrayInputStream exportEmployees(List<Employee> employees)
            throws IOException {

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Employees");

        // Header Row
        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("First Name");
        header.createCell(2).setCellValue("Last Name");
        header.createCell(3).setCellValue("Email");
        header.createCell(4).setCellValue("Phone");
        header.createCell(5).setCellValue("Department");

        int rowNumber = 1;

        for (Employee employee : employees) {

            Row row = sheet.createRow(rowNumber++);

            row.createCell(0).setCellValue(employee.getId());

            row.createCell(1).setCellValue(employee.getFirstName());

            row.createCell(2).setCellValue(employee.getLastName());

            row.createCell(3).setCellValue(employee.getEmail());

            row.createCell(4).setCellValue(employee.getPhone());

            if (employee.getDepartment() != null) {

                row.createCell(5).setCellValue(
                        employee.getDepartment().getDepartmentName());

            } else {

                row.createCell(5).setCellValue("");

            }

        }

        // Auto Size Columns
        for (int i = 0; i < 6; i++) {

            sheet.autoSizeColumn(i);

        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        workbook.write(out);

        workbook.close();

        return new ByteArrayInputStream(out.toByteArray());

    }

}