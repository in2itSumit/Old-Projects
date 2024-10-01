package com.student.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.sms.dto.StudentDTO;
import com.student.sms.service.StudentServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/student/services")
public class StudentController {
	@Autowired
	private StudentServices service;
	
	
	@PostMapping("/add")
	public String createStudent(@RequestBody StudentDTO student) {
		String response=service.createStudent(student);
		return response;
	}
	
	@PostMapping("/update")
	public String updateStudent(@RequestBody StudentDTO student) {
		String response=service.updateStudent(student);
		return response;
	}
	
	@PostMapping("/byRollno")
	public StudentDTO studentById(@RequestBody StudentDTO student) {
		StudentDTO response=service.studentById(student);
		return response;
	}
	
	@PostMapping("/all")
	public List<StudentDTO> allStudents() {
		List<StudentDTO> response=service.allStudents();
		return response;
	}
	
	@PostMapping("/delete")
	public String deleteStudent(@RequestBody StudentDTO student) {
		String response=service.deleteStudent(student);
		return response;
	}
	
}
