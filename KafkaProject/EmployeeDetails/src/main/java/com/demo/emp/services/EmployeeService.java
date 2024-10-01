package com.demo.emp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.emp.dto.EmployeeDto;
import com.demo.emp.entity.EmployeeEntity;
import com.demo.emp.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	
	public EmployeeDto saveEmployee(EmployeeDto dto)
	{
		EmployeeEntity emp=new EmployeeEntity(dto.getId(),dto.getFirst_name(),dto.getLast_name(),dto.getDesignation());
		
		EmployeeEntity saved=repo.save(emp);
		EmployeeDto savedDto=new EmployeeDto(saved.getId(),saved.getFirst_name(),saved.getLast_name(),saved.getDesignation());
		return savedDto;
	}
	
	public EmployeeDto getEmployee(int id)
	{
//		EmployeeEntity emp=new EmployeeEntity(dto.getId(),dto.getFirst_name(),dto.getLast_name(),dto.getSalary(),dto.getDesignation());
		
		EmployeeEntity saved=repo.getById(id);
		EmployeeDto fetchedDto=new EmployeeDto(saved.getId(),saved.getFirst_name(),saved.getLast_name(),saved.getDesignation());
		return fetchedDto;
	}
	
	public List<EmployeeDto> getAllEmp()
	{
		
		List<EmployeeEntity> listEmp=repo.findAll();
		List<EmployeeDto> empDtos=new ArrayList<>();
		for(EmployeeEntity entity:listEmp)
		{
			EmployeeDto dto=new EmployeeDto();
			dto.setFirst_name(entity.getFirst_name());
			dto.setLast_name(entity.getLast_name());
			dto.setId(entity.getId());
			dto.setDesignation(entity.getDesignation());
			empDtos.add(dto);
		}
		
		return empDtos;
	}
	
	public EmployeeDto updateEmployee(EmployeeDto dto)
	{
		EmployeeEntity emp=repo.getById(dto.getId());
		
		if(emp==null)return null;
		
		emp.setDesignation(dto.getDesignation());
		
		EmployeeEntity saved=repo.save(emp);
		EmployeeDto savedDto=new EmployeeDto(saved.getId(),saved.getFirst_name(),saved.getLast_name(),saved.getDesignation());
		return savedDto;
	}
	public ResponseEntity<EmployeeDto> deleteEmployee(int id)
	{
		EmployeeEntity entity=repo.getById(id);
		if(entity==null)return null;
		
		EmployeeDto deletedDto=new EmployeeDto(entity.getId(),entity.getFirst_name(),entity.getLast_name(),entity.getDesignation());
		
		repo.deleteById(id);
		
//		
//		try {
//			EmployeeEntity entity1=repo.getById(id);
//		}
//		catch(Exception ex)
//		{
			return ResponseEntity.ok(deletedDto);
//		}
//		return null;
	}
}
