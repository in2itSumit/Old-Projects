package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Table1CsvEntity;
import com.example.demo.repo.Table1CsvRepo;

@Service
public class Table1CsvService {

	@Autowired
	Table1CsvRepo repo;

	public Table1CsvEntity save(String vc) {
		Table1CsvEntity entity = new Table1CsvEntity();

		entity.setVcode(vc);
		entity.setId(generateId(vc));
		
		Table1CsvEntity en = repo.save(entity);

		return en;
	}

	public int generateId(String vcode) {
		String num = "";
		for (int i = 0; i < vcode.length(); i++) {
			if (i != 0) {
				num += vcode.charAt(i);
			}
		}

		return Integer.parseInt(num);
	}

//	public void addAllCsvs(List<CSVEntity> list)
//	{
//		Table1CsvEntity entity=new Table1CsvEntity();;
//		entity.getCsvEntity().addAll(list);
//	}
//	
//	public Table1CsvEntity findRecordByVcode(String vcode)
//	{
//		
//		String num="";
//		for(int i=0;i<vcode.length();i++)
//		{
//			if(i!=0)
//			{
//				num+=vcode.charAt(i);
//			}
//		}
//		int num1=Integer.parseInt(num);
//		
//		return repo.getById(num1);
//		
//	}
}
