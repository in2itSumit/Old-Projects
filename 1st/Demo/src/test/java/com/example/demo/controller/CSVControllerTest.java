package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.CSVDto;
import com.example.demo.entity.CSVEntity;
import com.example.demo.entity.Table1CsvEntity;
import com.example.demo.service.CSVService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CSVControllerTest {
	
	@InjectMocks
	private CSVController csvcon;
	@Mock
	private CSVService csvs;
	@Mock
	private CSVDto dto;
	@Mock
	private CSVEntity entity;
	
	public void setUp() {
		dto = new CSVDto(1001,2024,"Level 1","99999","All industries","Dollars (millions)","H01","Total income","Financial performance","757504","ANZSIC06 divisions A-S (excluding classes K6330, L6711, O7552, O760, O771, O772, S9540, S9601, S9602, and S9603)");
		
	}
	@Test
	public void saveCSV() throws IOException, CsvValidationException, NumberFormatException
	{		
//		String response=csvcon.saveCSV((MultipartFile) dto);
//		assertEquals("Successful",response);
		
		CSVReader reader = null;  
		try  
		{  

		File f=new File("src\\test\\java\\com\\example\\\\demo\\controller\\Book1.csv");
		byte []fb = Files.readAllBytes(f.toPath());
		System.out.println(f.getName());
		System.out.println(fb);
		MultipartFile mf = new MockMultipartFile("f", f.getName(), "text/csv", fb);
		String response=csvcon.saveCSV(mf);
		System.err.println(response);
		assertEquals("Successful",response);
		}  
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}
	}
	
}
