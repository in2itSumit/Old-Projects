package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.CSVDto;
import com.example.demo.entity.CSVEntity;
import com.example.demo.entity.Table1CsvEntity;
import com.example.demo.exceptionHandler.WrongRequestException;
import com.example.demo.service.CSVService;
import com.example.demo.service.Table1CsvService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/csvServices")
public class CSVController {
	@Autowired
	private CSVService service;
	
	@Autowired
	private Table1CsvService table1;
	
	
	@PostMapping("save")
	public String saveCSV(@RequestParam("file") MultipartFile csvFile) throws IOException, CsvValidationException, NumberFormatException
	{
			List<CSVDto> dataDtos = new ArrayList<>();
			
			
			
			try (CSVReader reader = new CSVReader(new InputStreamReader(csvFile.getInputStream(), StandardCharsets.UTF_8))) 
			{
	          String[] data;
	          reader.readNext();
	          while ((data = reader.readNext()) != null) {
	        	
	        	CSVDto dto = new CSVDto();
				dto.setYear(Integer.parseInt(data[0]));
				dto.setIndustry_aggregation_NZSIOC(data[1]);
				dto.setIndustry_code_NZSIOC(data[2]);
				dto.setIndustry_name_NZSIOC(data[3]);
				dto.setUnits(data[4]);
				dto.setVariable_code(data[5]);
				dto.setVariable_name(data[6]);
				dto.setVariable_category(data[7]);
				dto.setValue(data[8]);
				dto.setIndustry_code_ANZSIC06(data[9]);
				
				dataDtos.add(dto);
	          }
	          for(CSVDto dto:dataDtos)
				{
	        	
	        	
//	        	  Table1CsvEntity en=table1.save(dto.getVariable_code());
//					dto.setEntity(en);
					service.saveCsvData(dto);
					
				}
	         
	          }catch(Exception ex) 
			{
	          ex.printStackTrace();
	          return "Unsuccessful";
			}
			return "Successful";
	}
	//HttpServletRequest req/*,HttpServletResponse res*/,
	@GetMapping("/getPage")
	public List<CSVDto> getPage(@RequestParam(value="pn", defaultValue="0") int pn,@RequestParam(value="ps", defaultValue="1") int ps) throws WrongRequestException
	{
		
		//return service.getPage((Integer)req.getAttribute("pn"),ps);
		if(pn<=0)throw new WrongRequestException("Page must be greater than 0");
		else
			return service.getPage(pn-1,ps);
	}
	@GetMapping("/getPageWithSorting")
	public List<CSVDto> getPageWithSort(@RequestParam(value="pn", defaultValue="0") int pn,@RequestParam(value="ps", defaultValue="1") int ps,@RequestParam(value="sortBy", defaultValue="snumber,asc") Optional<String> sortBy) throws WrongRequestException
	{
		String str=new String(sortBy.get());
		if(!(str.contains("desc") || str.contains("asc"))) str=str+",asc";
		
		else if((str.contains("asc") || str.contains("desc")) && !str.contains(",")) str="snumber,"+str;
			
		if(pn<=0)throw new WrongRequestException("Page must be greater than 0");
		else {
			return service.getPageWithSort(pn-1,ps,str);
		}
	}
	@GetMapping("/getPageByVcode")
	public List<CSVDto> getPageWithSearchByVcode(@RequestParam(value="searchVal", defaultValue="H01") Optional<String> searchVal,@RequestParam(value="pn", defaultValue="0") int pn,@RequestParam(value="ps", defaultValue="1") int ps) throws WrongRequestException
	{
		//return service.getPageWithSearch(searchVal,(Integer)req.getAttribute("pn"),ps);
		if(pn<=0)throw new WrongRequestException("Page must be greater than 0");
		else
			return service.getPageWithSearchByVcode(searchVal,pn-1,ps);
	}
	@GetMapping("/getPageIndustry_aggregation_nzsioc")
	public List<CSVDto> getPageWithSearchByIndustry_aggregation_nzsioc(@RequestParam(value="searchVal",defaultValue="Level 1") Optional<String> searchVal,@RequestParam(value="pn", defaultValue="0") int pn,@RequestParam(value="ps", defaultValue="1") int ps) throws WrongRequestException
	{
		//return service.getPageWithSearch(searchVal,(Integer)req.getAttribute("pn"),ps);
		if(pn<=0)throw new WrongRequestException("Page must be greater than 0");
		else
			return service.getPageWithSearchByIndustry_aggregation_nzsioc(searchVal.get().trim(),pn-1,ps);
	}
}//getPageWithSearchByIndustry_aggregation_nzsioc(String industry_aggregation_nzsioc,int pn,int pageSize)