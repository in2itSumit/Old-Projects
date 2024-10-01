package com.student.sms.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class StudentDTO {
	private String firstname;
	private String lastname;
	private int rollno;
	private String course;
	private String email;
	private Date dob;
}
