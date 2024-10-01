//package com.example.demo.service;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.demo.controller.CSVController;
//import com.example.demo.dto.CSVDto;
//import com.example.demo.entity.CSVEntity;
//import com.example.demo.repo.CSVRepo;
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//public class Table1CsvServiceTest {
//
//}
//
//	@InjectMocks
//	private CSVService csvs;
//	@Mock
//	private CSVRepo repo;
//	
//	
//	@Test
//	public void save()
//	{
//		
//		CSVDto dto = new CSVDto(1001,2024,"Level 1","99999","All industries","Dollars (millions)","H01","Total income","Financial performance","757504","ANZSIC06 divisions A-S (excluding classes K6330, L6711, O7552, O760, O771, O772, S9540, S9601, S9602, and S9603)");
//		CSVEntity entity=new CSVEntity();
//		entity.setSerial_number(dto.getSerial_number());
//		entity.setIndustry_aggregation_NZSIOC(dto.getIndustry_aggregation_NZSIOC());
//		entity.setIndustry_code_ANZSIC06(dto.getIndustry_code_ANZSIC06());
//		entity.setIndustry_code_NZSIOC(dto.getIndustry_code_NZSIOC());
//		entity.setUnits(dto.getUnits());
//		entity.setValue(dto.getValue());
//		entity.setVariable_category(dto.getVariable_category());
//		entity.setVariable_code(dto.getVariable_code());
//		entity.setVariable_name(dto.getVariable_name());
//		entity.setEntity(dto.getEntity());
//		entity.setYear(dto.getYear());
//		entity.setIndustry_name_NZSIOC(dto.getIndustry_name_NZSIOC());
//		
//		when(repo.save(any(CSVEntity.class))).thenReturn(entity);
//		String response = null;
//		try {
//			response=csvs.saveCsvData(dto);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		assertEquals(response, "Success");
//	}
//	
//}
