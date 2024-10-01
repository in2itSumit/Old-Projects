package com.demo.salary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.salary.dto.SalaryDto;
import com.demo.salary.entity.Salary;
import com.demo.salary.repo.SalaryRepo;

@Service
public class SalaryService {
	@Autowired
	private SalaryRepo repo;
	
	public SalaryDto getSalaryByEId(int eid) {
		Salary sal=repo.getById(eid);
		SalaryDto salDto=new SalaryDto(sal.getEid(),sal.getBase(),sal.getHra(),sal.getInternetA());
//		return ResponseEntity.ok(salDto);
		return salDto;
		
	}
	public SalaryDto saveSalaryDetails(SalaryDto dto) {
		
		Salary sal=new Salary(dto.getEid(),dto.getBase(),dto.getHra(),dto.getInternetA());
		Salary savedSal=repo.save(sal);
		SalaryDto salDto=new SalaryDto(savedSal.getEid(),savedSal.getBase(),savedSal.getHra(),savedSal.getInternetA());
		
//		return ResponseEntity.ok(salDto);
		return salDto;
		
	}
	public List<SalaryDto> getAllSalaryDetails()
	{
		List<Salary> allSal=repo.findAll();
		List<SalaryDto> allSalDto=new ArrayList();
		for(Salary sal:allSal)
		{
			SalaryDto salDto=new SalaryDto();
			salDto.setEid(sal.getEid());
			salDto.setBase(sal.getBase());
			salDto.setHra(sal.getHra());
			salDto.setInternetA(sal.getInternetA());
			
			allSalDto.add(salDto);
		}
		return allSalDto;
	}
	public SalaryDto updateSalaryDetails(SalaryDto dto)
	{
		Salary sal=repo.getById(dto.getEid());
		
		if(dto.getBase()!=0)sal.setBase(dto.getBase());
		if(dto.getHra()!=0)sal.setHra(dto.getHra());
		if(dto.getInternetA()!=0)sal.setInternetA(dto.getInternetA());
		
		Salary updatedSal=repo.save(sal);
		SalaryDto salDto=new SalaryDto(updatedSal.getEid(),updatedSal.getBase(),updatedSal.getHra(),updatedSal.getInternetA());
		return salDto;
	}
	public SalaryDto deleteSalaryDetails(int id)
	{
		Salary sal=repo.getById(id);
		repo.delete(sal);
		SalaryDto dto=new SalaryDto(sal.getEid(),sal.getBase(),sal.getHra(),sal.getInternetA());
		return dto;
	}
}