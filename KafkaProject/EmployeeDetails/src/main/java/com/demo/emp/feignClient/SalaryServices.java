package com.demo.emp.feignClient;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.salary.dto.SalaryDto;


@FeignClient(name = "EMPSALARYDETAILS/salary/services") //, url = "/service", configuration = EmpSalaryDetailsApplication.class
@LoadBalancerClient
public interface SalaryServices {
	
	@GetMapping("/getSal/{eid}")
	public SalaryDto getSalaryByEId(@PathVariable int eid);
	@PostMapping("/saveSal")
	public SalaryDto saveSalaryDetails(@RequestBody SalaryDto salDto);
	@GetMapping("/allSal")
	public List<SalaryDto> getAllSalaryDetails();
	@PutMapping("/update")
	public SalaryDto updateSalaryDetails(@RequestBody SalaryDto salDto);
	@PatchMapping("/updateP")
	public SalaryDto updateSalaryDetailsByPatchM(@RequestBody SalaryDto salDto);
	@DeleteMapping("/delete/{id}")
	public SalaryDto deleteSalaryDetails(@PathVariable int id);

}
