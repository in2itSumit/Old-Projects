package com.demo.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {
	private int eid;
	private int base;
	private int hra;
	private int internetA;
	
	@Override
	public String toString()
	{
		return "SalaryDto [ Base : "+base+", HRA : "+hra+", InternetAllowance : "+internetA +" ]";
	}
}
