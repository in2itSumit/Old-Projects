package com.demo.emp.dto;

import org.springframework.stereotype.Component;

import com.demo.salary.dto.SalaryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmployeeAndSalaryDto {
	private int id;
	private String first_name;
	private String last_name;
	private String designation ;
	private int base;
	private int hra;
	private int internetA;
}
