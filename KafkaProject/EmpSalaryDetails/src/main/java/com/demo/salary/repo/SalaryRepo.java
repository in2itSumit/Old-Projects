package com.demo.salary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.salary.entity.Salary;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, Integer>{

}
