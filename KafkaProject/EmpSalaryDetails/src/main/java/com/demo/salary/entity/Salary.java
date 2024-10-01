package com.demo.salary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Salary 
{
	@Id
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
