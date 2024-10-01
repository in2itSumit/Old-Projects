package com.demo.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	private int id;
	private String first_name;
	private String last_name;
	private String designation ;
	
	@Override
	public String toString()
	{
		return "EmployeeDto [ Id : "+id+", FirstName : "+first_name+", LastName : "+last_name+", Designation : "+designation+" ]";
	}
}
