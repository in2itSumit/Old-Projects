package com.student.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.sms.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
