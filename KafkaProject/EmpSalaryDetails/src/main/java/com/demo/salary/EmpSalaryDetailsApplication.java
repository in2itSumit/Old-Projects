package com.demo.salary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmpSalaryDetailsApplication {

	public static void main(String[] args) 
{
		SpringApplication.run(EmpSalaryDetailsApplication.class, args);
}

}
