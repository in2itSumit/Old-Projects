package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.CSVController;
import com.example.demo.dto.CSVDto;
import com.example.demo.entity.CSVEntity;
import com.example.demo.repo.CSVRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CSVServiceTest {
	
	@InjectMocks
	private CSVService csvs;
	@Mock
	private CSVRepo repo;
	
	
	@Test
	public void save()
	{
		
		CSVDto dto = new CSVDto(1001,2024,"Level 1","99999","All industries","Dollars (millions)","H01","Total income","Financial performance","757504","ANZSIC06 divisions A-S (excluding classes K6330, L6711, O7552, O760, O771, O772, S9540, S9601, S9602, and S9603)");
		CSVEntity entity=new CSVEntity();
		entity.setSnumber(dto.getSerial_number());
		entity.setIanzsioc(dto.getIndustry_aggregation_NZSIOC());
		entity.setIcanzsic06(dto.getIndustry_code_ANZSIC06());
		entity.setIcnzsioc(dto.getIndustry_code_NZSIOC());
		entity.setUnits(dto.getUnits());
		entity.setValue(dto.getValue());
		entity.setVcategory(dto.getVariable_category());
		entity.setVcode(dto.getVariable_code());
		entity.setVname(dto.getVariable_name());

		entity.setYear(dto.getYear());
		entity.setInnzsioc(dto.getIndustry_name_NZSIOC());
		
		when(repo.save(any(CSVEntity.class))).thenReturn(entity);
		String response = null;
		try {
			response=csvs.saveCsvData(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(response, "Success");
	}
	
}
