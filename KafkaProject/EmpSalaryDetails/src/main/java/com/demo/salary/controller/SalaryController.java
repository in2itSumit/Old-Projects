package com.demo.salary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.salary.dto.SalaryDto;
import com.demo.salary.service.SalaryService;

@RestController
@RequestMapping("/salary/services")
public class SalaryController 
{
	@Autowired
	private SalaryService service;
	
	@GetMapping("/getSal/{eid}")
	public ResponseEntity<SalaryDto> getSalaryByEId(@PathVariable int eid)
	{
		SalaryDto response= service.getSalaryByEId(eid);
		return ResponseEntity.ok(response);
		
	}
	@PostMapping("/saveSal")
	public SalaryDto saveSalaryDetails(@RequestBody SalaryDto salDto)
	{
		SalaryDto response= service.saveSalaryDetails(salDto);
		return response;
		
	}
	
	@GetMapping("/allSal")
	public ResponseEntity<List<SalaryDto>> getAllSalaryDetails()
	{
		return ResponseEntity.ok(service.getAllSalaryDetails());
		
	}
	@PutMapping("/update")
	public ResponseEntity<SalaryDto> updateSalaryDetails(@RequestBody SalaryDto salDto)
	{
		SalaryDto response=service.updateSalaryDetails(salDto);
		return ResponseEntity.ok(response);
	}
	@PatchMapping("/updateP")
	public SalaryDto updateSalaryDetailsByPatchM(@RequestBody SalaryDto salDto)
	{
		SalaryDto response=service.updateSalaryDetails(salDto);
		return response;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<SalaryDto> deleteSalaryDetails(@PathVariable int id)
	{
		SalaryDto response=service.deleteSalaryDetails(id);
		return ResponseEntity.ok(response);
	}
}
