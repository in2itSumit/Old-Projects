package com.CustomException.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CustomException.allExClasses.DataEntryMissing;
import com.CustomException.allExClasses.DataNotExistException;
import com.CustomException.allExClasses.IllegalAgeException;
import com.CustomException.allExClasses.IllegalDateException;
import com.CustomException.allExClasses.IllegalNameException;
import com.CustomException.allExClasses.IllegalSalaryException;
import com.CustomException.allExClasses.Illegal_Id_Exception;
import com.CustomException.dto.EmployeeDTO;
import com.CustomException.entity.Employee;
import com.CustomException.repo.EmployeeRepo;
import com.CustomException.validation.EmployeeValidator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeService {
	@Autowired
	private EmployeeRepo emprepo;
	@Autowired
	private EmployeeValidator validator;
	
	public EmployeeDTO saveEmp(EmployeeDTO dto) throws IllegalDateException, DataEntryMissing, Illegal_Id_Exception, IllegalNameException, IllegalSalaryException, IllegalAgeException {
		validator.validateId(dto.getE_id());
		validator.validateF_Name(dto.getE_first_name());
		validator.validateL_Name(dto.getE_last_name());
		validator.validateJDate(dto.getJoining_date());
		validator.validateSalary(dto.getE_salary());
		validator.validateAge(dto.getE_age());
		return empToDtoConverter(emprepo.save(dtoToEmpConverter(dto)));
	}
	
	public EmployeeDTO fetchEmpById(int id) throws DataNotExistException {
			try
			{
				return empToDtoConverter(emprepo.getById(id));
			}
			catch(Exception ex)
			{
				throw new DataNotExistException("Employee with id "+id+" does not exist");
			}
	}
	public List<EmployeeDTO> fetchAll() throws DataNotExistException {

		List<EmployeeDTO> employees=new ArrayList<>();
		
			List<Employee> allEmployees=emprepo.findAll();
			if(allEmployees==null)throw new DataNotExistException("There are not any records for Employees");
			for(Employee emp:allEmployees)
			{
				employees.add(empToDtoConverter(emp));
			}
			return employees;
		
	}
	public EmployeeDTO update(EmployeeDTO dto) throws DataNotExistException {
		Employee emp=null;
		try {
			validator.validateId(dto.getE_id());
			emp=emprepo.getById(dto.getE_id());
		}catch(Illegal_Id_Exception | DataEntryMissing e) {}
		
		if(emp==null) {
			throw new DataNotExistException("Employee with id "+dto.getE_id()+" does not exist");
		}
		
		try {
			validator.validateF_Name(dto.getE_first_name());
			emp.setE_first_name(dto.getE_first_name());
		}catch(IllegalNameException | DataEntryMissing e) {}
		try {
			validator.validateL_Name(dto.getE_last_name());
			emp.setE_last_name(dto.getE_last_name());
		}catch(IllegalNameException | DataEntryMissing e) {}
		try {
			validator.validateAge(dto.getE_age());
			emp.setE_age(dto.getE_age());
		}catch(IllegalAgeException | DataEntryMissing e) {}
		try {
			validator.validateSalary(dto.getE_salary());
			emp.setE_salary(dto.getE_salary());
		}catch(IllegalSalaryException | DataEntryMissing e) {}
		try {
			validator.validateJDate(dto.getJoining_date());
			emp.setJoining_date(dto.getJoining_date());
		}catch(IllegalDateException | DataEntryMissing e) {}
		
		return empToDtoConverter(emprepo.save(emp));
		
	}
	
	public EmployeeDTO deleteEmp(int id) throws DataNotExistException {
		EmployeeDTO dto=null;
		try {
			dto=empToDtoConverter(emprepo.getById(id));
		}catch(Exception ex)
		{
			throw new DataNotExistException("Employee with id "+id+" does not exist");
		}
		emprepo.deleteById(id);
			return dto;
		
	}
	public Employee dtoToEmpConverter(EmployeeDTO dto)
	{
		return new Employee(dto.getE_id(),dto.getE_first_name(),dto.getE_last_name(),dto.getJoining_date(),dto.getE_salary(),dto.getE_age());
	}
	public EmployeeDTO empToDtoConverter(Employee emp)
	{
		return new EmployeeDTO(emp.getE_id(),emp.getE_first_name(),emp.getE_last_name(),emp.getJoining_date(),emp.getE_salary(),emp.getE_age());
	}
	
}
