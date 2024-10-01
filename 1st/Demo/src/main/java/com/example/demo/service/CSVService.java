package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CSVDto;
import com.example.demo.entity.CSVEntity;
import com.example.demo.exceptionHandler.WrongRequestException;
import com.example.demo.repo.CSVRepo;

@Service
public class CSVService {
	@Autowired
	private CSVRepo repo;
	@Autowired
	private Table1CsvService table1Services;
	
	public String saveCsvData(CSVDto dto)
	{
		try {
			
		CSVEntity entity=new CSVEntity();
		entity.setInnzsioc(dto.getIndustry_name_NZSIOC());
		entity.setIanzsioc(dto.getIndustry_aggregation_NZSIOC());
		entity.setIcanzsic06(dto.getIndustry_code_ANZSIC06());
		entity.setIcnzsioc(dto.getIndustry_code_NZSIOC());
		entity.setYear(dto.getYear());
		entity.setUnits(dto.getUnits());
		entity.setValue(dto.getValue());
		entity.setVcategory(dto.getVariable_category());
		entity.setVcode(dto.getVariable_code());
		entity.setVname(dto.getVariable_name());
//		entity.setEntity(dto.getEntity());
		entity.setEntity(table1Services.save(dto.getVariable_code()));  //creating and storing Table1CsvService's object
		repo.save(entity);
		
		return "Success";
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return "Unsuccess";
		}
		
	}
	public List<CSVDto> getPage(int pn,int pageSize) throws WrongRequestException
	{
		
		PageRequest paging=PageRequest.of(pn, pageSize);
		Page<CSVEntity> page=repo.findAll(paging);
		int able=isAbleToSend(page.getNumberOfElements());
//		if(!check(page.getNumberOfElements(),pn,pageSize))
		
		//if(page.getNumberOfElements()<=0)
		if(able<=0)
			throw new WrongRequestException("You did wrong request");
		else {
		List<CSVEntity> list=page.getContent();
		List<CSVDto> dtoList=new ArrayList<>();
		for(CSVEntity csv:list)
		{
			CSVDto dto=new CSVDto();
			dto.setSerial_number(csv.getSnumber());
			dto.setIndustry_aggregation_NZSIOC(csv.getIanzsioc());
			dto.setIndustry_code_ANZSIC06(csv.getIcanzsic06());
			dto.setIndustry_code_NZSIOC(csv.getIcnzsioc());
			dto.setIndustry_name_NZSIOC(csv.getInnzsioc());
			dto.setUnits(csv.getUnits());
			dto.setValue(csv.getValue());
			dto.setVariable_category(csv.getVcategory());
			dto.setVariable_code(csv.getVcode());
			dto.setVariable_name(csv.getVname());
			dto.setYear(csv.getYear());
			dtoList.add(dto);
		}
		return dtoList;
		}
	}
	public List<CSVDto> getPageWithSort(int pn,int pageSize,String sortBy) throws WrongRequestException
	{
		
		String[] str=sortBy.split(",");
		PageRequest paging=null;
		
		if(str[1].trim().equals("desc"))
		 paging=PageRequest.of(pn, pageSize,Sort.by(str[0]).descending());
		else if(str[1].trim().equals("asc"))
			 paging=PageRequest.of(pn, pageSize,Sort.by(str[0]).ascending());
		Page<CSVEntity> page=repo.findAll(paging);
//		if(!check(page.getNumberOfElements(),pn,pageSize))
//		if(page.getNumberOfElements()<=0)
		
		int able=isAbleToSend(page.getNumberOfElements());

		if(able<=0)
			throw new WrongRequestException("You did wrong request");
		
		List<CSVEntity> list=page.getContent();
		List<CSVDto> dtoList=new ArrayList<>();
		for(CSVEntity csv:list)
		{
			
			CSVDto dto=new CSVDto();
			dto.setSerial_number(csv.getSnumber());
			dto.setIndustry_aggregation_NZSIOC(csv.getIanzsioc());
			dto.setIndustry_code_ANZSIC06(csv.getIcanzsic06());
			dto.setIndustry_code_NZSIOC(csv.getIcnzsioc());
			dto.setIndustry_name_NZSIOC(csv.getInnzsioc());
			dto.setUnits(csv.getUnits());
			dto.setValue(csv.getValue());
			dto.setVariable_category(csv.getVcategory());
			dto.setVariable_code(csv.getVcode());
			dto.setVariable_name(csv.getVname());
			dto.setYear(csv.getYear());
			dtoList.add(dto);
		}
		return dtoList;
	}
	public List<CSVDto> getPageWithSearchByVcode(Optional<String> searchVal,int pn,int pageSize)throws WrongRequestException
	{
		
		
		PageRequest paging=PageRequest.of(pn, pageSize);
		List<CSVDto> dtoList=new ArrayList<>();

			Page<CSVEntity> page= page=repo.searchByVcode(searchVal.get(),paging);
			
			int able=isAbleToSend(page.getNumberOfElements());

			if(able<=0)
				throw new WrongRequestException("You did wrong request");
			
			for(CSVEntity csv:page)
			{
				CSVDto dto=new CSVDto();
				dto.setSerial_number(csv.getSnumber());
				dto.setIndustry_aggregation_NZSIOC(csv.getIanzsioc());
				dto.setIndustry_code_ANZSIC06(csv.getIcanzsic06());
				dto.setIndustry_code_NZSIOC(csv.getIcnzsioc());
				dto.setIndustry_name_NZSIOC(csv.getInnzsioc());
				dto.setUnits(csv.getUnits());
				dto.setValue(csv.getValue());
				dto.setVariable_category(csv.getVcategory());
				dto.setVariable_code(csv.getVcode());
				dto.setVariable_name(csv.getVname());
				dto.setYear(csv.getYear());
				dtoList.add(dto);
			}
		
		
		return dtoList;
	}
	
	public List<CSVDto> getPageWithSearchByIndustry_aggregation_nzsioc(String ianzsioc,int pn,int pageSize)throws WrongRequestException
	{
		
		
		PageRequest paging=PageRequest.of(pn, pageSize);
		List<CSVDto> dtoList=new ArrayList<>();
//		if(!searchVal.isEmpty())
//		{
			Page<CSVEntity> page= page=repo.findByIanzsioc(ianzsioc.trim(),paging);
			
			int able=isAbleToSend(page.getNumberOfElements());

			if(able<=0)
				throw new WrongRequestException("You did wrong request");
			
			
			for(CSVEntity csv:page)
			{
				
				CSVDto dto=new CSVDto();
				dto.setSerial_number(csv.getSnumber());
				dto.setIndustry_aggregation_NZSIOC(csv.getIanzsioc());
				dto.setIndustry_code_ANZSIC06(csv.getIcanzsic06());
				dto.setIndustry_code_NZSIOC(csv.getIcnzsioc());
				dto.setIndustry_name_NZSIOC(csv.getInnzsioc());
				dto.setUnits(csv.getUnits());
				dto.setValue(csv.getValue());
				dto.setVariable_category(csv.getVcategory());
				dto.setVariable_code(csv.getVcode());
				dto.setVariable_name(csv.getVname());
				dto.setYear(csv.getYear());
				dtoList.add(dto);
			}
//		}
//		else {
//			dtoList=getPage(pn, pageSize);
//		}
		
		
		
		return dtoList;
	}
	
	public int isAbleToSend(int total)
	{
		
//		if(pageNo==0)return total;
//		else if(total-((pageNo)*pageSize)>0)return total-((pageNo)*pageSize);
//		else  return 0;
		if(total>0)return 1;
		else return 0;
		
	}

	
}
