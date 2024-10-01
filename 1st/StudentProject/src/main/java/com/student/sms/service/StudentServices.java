package com.student.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.sms.dto.StudentDTO;
import com.student.sms.entity.Student;
import com.student.sms.repo.StudentRepo;
@Component
public class StudentServices {
	@Autowired
	private StudentRepo repo;
	
	public String createStudent(StudentDTO student)
	{
		try {		    
			Student student1=new Student();
			student1.setFirstname(student.getFirstname());
			student1.setLastname(student.getLastname());
			student1.setRollno(student.getRollno());
			student1.setCourse(student.getCourse());
			student1.setEmail(student.getEmail());
			student1.setDob(student.getDob());
			repo.save(student1);
			return "Success";
		}
		catch(Exception ex)
		{
			return "Unsuccess";
		}
	}
	
	public String updateStudent(StudentDTO student)
	{
		try {
			Student student1=repo.getById(student.getRollno());
			
			if(student1==null)
				return "Student Doesnot exist";
			
			if(student.getFirstname() !=null) 
			student1.setFirstname(student.getFirstname());
			
			if(student.getLastname()!=null)
			student1.setLastname(student.getLastname());
			
			if(student.getRollno()!=0)
			student1.setRollno(student.getRollno());
			
			if(student.getCourse()!=null)
			student1.setCourse(student.getCourse());
			
			if(student.getEmail()!=null)
			student1.setEmail(student.getEmail());
			
			if(student.getDob()!=null)
			student1.setDob(student.getDob());
			
			repo.save(student1);
			return "Student Updated Successfully";
		}
		catch(Exception ex)
		{
			return "Unsuccess";
		}
	}
	
	public StudentDTO studentById(StudentDTO student)
	{
			StudentDTO studentNew=new StudentDTO();
			
			Student student1=repo.getById(student.getRollno());
			if(student1==null)return null;
			studentNew.setFirstname(student1.getFirstname());
			studentNew.setLastname(student1.getLastname());
			studentNew.setRollno(student1.getRollno());
			studentNew.setCourse(student1.getCourse());
			studentNew.setEmail(student1.getEmail());
			studentNew.setDob(student1.getDob());
			return studentNew;
	}
	
	public List<StudentDTO> allStudents()
	{
			List<StudentDTO> allStudents=new ArrayList<StudentDTO>();
			
			List<Student> students=repo.findAll();
			if(students==null)return null;
			
			for(Student student:students)
			{
				StudentDTO student1=new StudentDTO();
				student1.setFirstname(student.getFirstname());
				student1.setLastname(student.getLastname());
				student1.setRollno(student.getRollno());
				student1.setCourse(student.getCourse());
				student1.setEmail(student.getEmail());
				student1.setDob(student.getDob());
				allStudents.add(student1);
			}
			return allStudents;
	}
	
	public String deleteStudent(StudentDTO student)
	{
		try {
			repo.deleteById(student.getRollno());
			return "Student deleted successfully";
		}
		catch(Exception ex)
		{
			return "Unsuccess";
		}
	}
	
}
