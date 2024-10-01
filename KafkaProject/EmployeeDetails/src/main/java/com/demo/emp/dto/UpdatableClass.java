package com.demo.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatableClass {
	
	private int id;
	private String designation ;
	private int base;
	private int hra;
	private int internetA;
	
}
