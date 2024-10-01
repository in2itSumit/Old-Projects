package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CSVDto {
	
	private int serial_number;
	private int year;
	private String industry_aggregation_NZSIOC;
	private String industry_code_NZSIOC;
	private String industry_name_NZSIOC;
	private String units;
	private String variable_code;
	private String variable_name;
	private String variable_category;
	private String value;
	private String industry_code_ANZSIC06;
	//private Table1CsvEntity entity;
	
//	public CSVDto(int serial_number, int year, String industry_aggregation_NZSIOC, String industry_code_NZSIOC,
//			String industry_name_NZSIOC, String units, String variable_code, String variable_name,
//			String variable_category, String value, String industry_code_ANZSIC06) {
//		super();
//		this.serial_number = serial_number;
//		this.year = year;
//		this.industry_aggregation_NZSIOC = industry_aggregation_NZSIOC;
//		this.industry_code_NZSIOC = industry_code_NZSIOC;
//		this.industry_name_NZSIOC = industry_name_NZSIOC;
//		this.units = units;
//		this.variable_code = variable_code;
//		this.variable_name = variable_name;
//		this.variable_category = variable_category;
//		this.value = value;
//		this.industry_code_ANZSIC06 = industry_code_ANZSIC06;
//	}
}
