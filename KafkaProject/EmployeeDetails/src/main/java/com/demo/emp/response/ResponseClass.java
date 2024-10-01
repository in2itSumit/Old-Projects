package com.demo.emp.response;

import org.springframework.stereotype.Component;

import com.demo.emp.dto.EmployeeDto;
import com.demo.salary.dto.SalaryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseClass {
	
	
	private EmployeeDto emp;
	private SalaryDto sal;
}
