package com.demo.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.RestTemplate;

import com.demo.emp.dto.EmployeeAndSalaryDto;
import com.demo.emp.dto.EmployeeDto;
import com.demo.emp.dto.UpdatableClass;
import com.demo.emp.feignClient.SalaryServices;
import com.demo.emp.response.ArrangingSalaryAndEmp;
import com.demo.emp.response.ResponseClass;
import com.demo.emp.services.EmployeeService;
import com.demo.salary.dto.SalaryDto;

@RestController
@RequestMapping("/emp/services")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@Autowired
	private ResponseClass response;
	@Autowired
	private ArrangingSalaryAndEmp arrange;
	
	@Autowired
	private SalaryServices sal;
	
//	private RestTemplate restTemplate = new RestTemplate();
//	@Autowired
//	private RestTemplate restTemplate1;
	
	@PostMapping("/save")
	public ResponseClass setEmployee(@RequestBody EmployeeAndSalaryDto data)
	{
		EmployeeDto empDto=new EmployeeDto();
		empDto.setId(data.getId());
		empDto.setFirst_name(data.getFirst_name());
		empDto.setLast_name(data.getLast_name());
		empDto.setDesignation(data.getDesignation());
		
		SalaryDto salDto=new SalaryDto();
		salDto.setEid(data.getId());
		salDto.setBase(data.getBase());
		salDto.setHra(data.getHra());
		salDto.setInternetA(data.getInternetA());
		
		
		EmployeeDto savedEmp=service.saveEmployee(empDto);
		
		
//		SalaryDto savedSal=restTemplate.postForObject("http://localhost:2220/salary/services/saveSal",salDto,SalaryDto.class);
		SalaryDto savedSal=sal.saveSalaryDetails(salDto);
		response.setEmp(savedEmp);
		response.setSal(savedSal);
		
		return response;
	}
	
	@GetMapping("/fetch/{id}")		
	public ResponseClass getEmployee(@PathVariable(name="id") int id)
	{
		EmployeeDto fetchedDto=service.getEmployee(id);
		
		
//		SalaryDto saldto=restTemplate.getForObject("http://localhost:2220/salary/services/getSal/"+id,SalaryDto.class);
//		ResponseEntity<SalaryDto> saldto=restTemplate.exchange("http://localhost:2220/salary/services/getSal/"+id, HttpMethod.GET,null,SalaryDto.class);  
		SalaryDto saldto=sal.getSalaryByEId(id); 
		response.setEmp(fetchedDto);
//		response.setSal(saldto.getBody());
		response.setSal(saldto);
		return response;
	}
	@GetMapping("/all")		
	public List<ResponseClass> getAllEmployee()
	{
		
		List<EmployeeDto> empDtoList=service.getAllEmp();
//		ResponseEntity<List<SalaryDto>> saldto=restTemplate.exchange("http://localhost:2220/salary/services/allSal", HttpMethod.GET,null, new ParameterizedTypeReference<List<SalaryDto>>() {});
		List<SalaryDto> salDto=sal.getAllSalaryDetails();
//		List<SalaryDto> salDto=(List<SalaryDto>)saldto.getBody();
//		ResponseEntity<List<User>> responseEntity = restTemplate.exchange(BASE_URL,HttpMethod.GET,null,new ParameterizedTypeReference<List<User>>() {});
		List<ResponseClass> responseList=new ArrayList<>();
		
		for(EmployeeDto dto:empDtoList)
		{
			ResponseClass response=new ResponseClass();
			 SalaryDto dto1=arrange.getSalAccToId(salDto, dto.getId());
			 response.setEmp(dto);
			 response.setSal(dto1);
			 responseList.add(response);
			 
		}
		
		ResponseClass temp=null;
		
		for(int i=0;i<responseList.size();i++)
		{
			for(int j=0;j<responseList.size()-1;j++)
			{
				if(responseList.get(j).getEmp().getId()>responseList.get(j+1).getEmp().getId())
				{
					temp=responseList.get(j);
					responseList.set(j,responseList.get(j+1));
					responseList.set(j+1,temp);
				}
			}
		}
		
		return responseList;
	}
	
	@PutMapping("/update")		
	public ResponseClass updateEmployeeDetails(@RequestBody UpdatableClass data)
	{
		EmployeeDto dto=new EmployeeDto();
		dto.setDesignation(data.getDesignation());
		dto.setId(data.getId());
		EmployeeDto updatedEmpDto=service.updateEmployee(dto);

		Map<String,Integer> key=new HashMap<String,Integer>();
		key.put("eid", data.getId());
		
		SalaryDto saldto=new SalaryDto();
		saldto.setEid(data.getId());
		saldto.setBase(data.getBase());
		saldto.setHra(data.getHra());
		saldto.setInternetA(data.getInternetA());
		
//		restTemplate.put("http://localhost:2220/salary/services/update", saldto, key);
		SalaryDto updatedSalDto=sal.updateSalaryDetails(saldto);
//		SalaryDto updatedSalDto=restTemplate.getForObject("http://localhost:2220/salary/services/getSal/"+data.getId(),SalaryDto.class);
		
		ResponseClass response=new ResponseClass();
		response.setEmp(updatedEmpDto);
		response.setSal(updatedSalDto);
		
		return response;
	}
	
	@PatchMapping("/update")
	public ResponseClass updateEmployeeDetailsByPatch(@RequestBody UpdatableClass data)
	{
		EmployeeDto dto=new EmployeeDto();
		dto.setDesignation(data.getDesignation());
		dto.setId(data.getId());
		EmployeeDto updatedEmpDto=service.updateEmployee(dto);
		
		
		
		SalaryDto saldto=new SalaryDto();
		saldto.setEid(data.getId());
		saldto.setBase(data.getBase());
		saldto.setHra(data.getHra());
		saldto.setInternetA(data.getInternetA());
//		SalaryDto updatedSalDto=restTemplate1.patchForObject("http://localhost:2220/salary/services/updateP", saldto, SalaryDto.class);
		SalaryDto updatedSalDto=sal.updateSalaryDetailsByPatchM(saldto);
//		SalaryDto updatedSalDto=restTemplate.getForObject("http://localhost:2220/salary/services/getSal/"+data.getId(),SalaryDto.class);
		
		ResponseClass response=new ResponseClass();
		response.setEmp(updatedEmpDto);
		response.setSal(updatedSalDto);
		
		return response;
	}
	
	@DeleteMapping("/delete/{id}")		
	public ResponseClass deleteEmployeeDetails(@PathVariable int id)
	{
		
		ResponseEntity<EmployeeDto> delEmpDto=service.deleteEmployee(id);
		if(delEmpDto==null)return null;
		
		Map<String,Integer> key=new HashMap<String,Integer>();
		key.put("id", id);
//		SalaryDto deletedSalDto=null;
		
//		try
//		{
//			deletedSalDto=restTemplate.getForObject("http://localhost:2220/salary/services/getSal/"+id,SalaryDto.class);
//		}
//		catch(Exception ex)
//		{
//			
//		}
//			restTemplate.delete("http://localhost:2220/salary/services/delete/"+id,key);
			
			SalaryDto deletedSalDto=sal.deleteSalaryDetails(id);
			ResponseClass response=new ResponseClass();
			response.setEmp(delEmpDto.getBody());
			response.setSal(deletedSalDto);
			return response;
		
	}
}
