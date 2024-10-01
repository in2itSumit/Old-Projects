package com.CustomException.validation;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.CustomException.allExClasses.DataEntryMissing;
import com.CustomException.allExClasses.IllegalAgeException;
import com.CustomException.allExClasses.IllegalDateException;
import com.CustomException.allExClasses.IllegalNameException;
import com.CustomException.allExClasses.IllegalSalaryException;
import com.CustomException.allExClasses.Illegal_Id_Exception;

@Component
public class EmployeeValidator {
	
	
	public boolean validateId(int id) throws Illegal_Id_Exception,DataEntryMissing
	{
		if(id==0) throw new DataEntryMissing("id is empty");
		if(id<=0)
		{
			throw new Illegal_Id_Exception("Wrong ID entered");
		}
		return true;
	}
	public boolean validateAge(int age) throws IllegalAgeException,DataEntryMissing
	{
		if(age==0) throw new DataEntryMissing("Age is empty");
		if(age<18)
		{
			throw new IllegalAgeException("You are under age");
		}
		return true;
	}
	public boolean validateSalary(int salary) throws IllegalSalaryException,DataEntryMissing
	{
		if(salary==0) throw new DataEntryMissing("salary is empty");
		if(salary<=0)
		{
			throw new IllegalSalaryException("Wrong salary entered");
		}
		return true;
	}
	
	
	public boolean validateF_Name(String name) throws IllegalNameException, DataEntryMissing
	{
		if(name==null) throw new DataEntryMissing("name is empty");
		for(int i=0;i<name.length();i++)
		{
			if(!(name.charAt(i)>='a'&& name.charAt(i)<='z' || name.charAt(i)>='A'&& name.charAt(i)<='Z'))
			{
				throw new IllegalNameException("Wrong Name entered");
			}
		}
		return true;
	}
	public boolean validateL_Name(String name) throws IllegalNameException, DataEntryMissing
	{
		if(name==null) throw new DataEntryMissing("name is empty");
		for(int i=0;i<name.length();i++)
		{
			if(!(name.charAt(i)>='a'&& name.charAt(i)<='z' || name.charAt(i)>='A'&& name.charAt(i)<='Z'))
			{
				throw new IllegalNameException("Wrong Name entered");
			}
		}
		return true;
	}
	
	public boolean validateJDate(LocalDate jdate)throws IllegalDateException, DataEntryMissing
	{
		if(jdate==null) throw new DataEntryMissing("Date is empty");
			LocalDate currDate=LocalDate.now();
			if(currDate.isAfter(jdate))
			{
				throw new IllegalDateException("Wrong Date entered");
				
			}
			
			return true;
	}
}
