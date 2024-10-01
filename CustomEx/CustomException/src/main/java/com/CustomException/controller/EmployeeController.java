package com.CustomException.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomException.allExClasses.DataEntryMissing;
import com.CustomException.allExClasses.DataNotExistException;
import com.CustomException.allExClasses.IllegalAgeException;
import com.CustomException.allExClasses.IllegalDateException;
import com.CustomException.allExClasses.IllegalNameException;
import com.CustomException.allExClasses.IllegalSalaryException;
import com.CustomException.allExClasses.Illegal_Id_Exception;
import com.CustomException.dto.EmployeeDTO;
import com.CustomException.services.EmployeeService;
import com.CustomException.validation.EmployeeValidator;

@RestController
@RequestMapping("/emp/services")
public class EmployeeController {
	@Autowired
	private EmployeeValidator validator;
	@Autowired
	private EmployeeService empService;
	
	
	
	@PostMapping("create")
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO emp) throws IllegalAgeException //c
, Illegal_Id_Exception, IllegalNameException, IllegalDateException, IllegalSalaryException, DataEntryMissing
	{

		return empService.saveEmp(emp);
	}
	
	@GetMapping("byId/{id}")
	public EmployeeDTO fetchEmpById(@PathVariable int id) throws Illegal_Id_Exception, DataNotExistException, DataEntryMissing

	{		
		EmployeeDTO empDto=null;
		if(validator.validateId(id))
		{
			empDto=empService.fetchEmpById(id);		
		}
		return empDto;
	}
	
	@GetMapping("all")
	public List<EmployeeDTO> fetchAll()  throws DataNotExistException //r
	{
		 return empService.fetchAll();

		 
	}
	
	@PutMapping("update")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO empDto) throws Illegal_Id_Exception, IllegalSalaryException, DataNotExistException, DataEntryMissing
	{
		return empService.update(empDto);
	}
	
	@DeleteMapping("delete/{id}")
	public EmployeeDTO deleteEmp(@PathVariable int id) throws Illegal_Id_Exception //d
, DataNotExistException, DataEntryMissing
{
		EmployeeDTO empDto=null;
		if(validator.validateId(id))
		{
			empDto=empService.fetchEmpById(id);
			if(empDto==null)
			{
				throw new DataNotExistException("Employee with id "+id+"does not exist");
			}	
		}
		
			empService.deleteEmp(id);
			return empDto;
		
		
	}
}
