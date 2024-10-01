package com.demo.emp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeEntity {
	@Id
	private int id;
	private String first_name;
	private String last_name;
	private String designation ;
	
	@Override
	public String toString()
	{
		return "Employee [ Id : "+id+", FirstName : "+first_name+", LastName : "+last_name+", Designation : "+designation+" ]";
	}
}
