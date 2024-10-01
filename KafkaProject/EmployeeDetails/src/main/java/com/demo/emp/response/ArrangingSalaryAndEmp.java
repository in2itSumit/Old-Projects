package com.demo.emp.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.salary.dto.SalaryDto;

@Component
public class ArrangingSalaryAndEmp {
	
	public SalaryDto getSalAccToId(List<SalaryDto> list,int id)
	{
		for(SalaryDto dto:list)
		{
			if(dto.getEid()==id)return dto;
		}
		return null;
	}
}
