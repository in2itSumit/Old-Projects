package com.student.sms.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String firstname;
	private String lastname;
	@Id
	private int rollno;
	private String course;
	private String email;
	private Date dob;
	
}
