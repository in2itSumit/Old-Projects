package com.demo.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class EmpSalaryDetails1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmpSalaryDetails1Application.class, args);
	}


//	@Bean
//	public RestTemplate restTemplate() {
//		 
//		RestTemplate template = new RestTemplate();
//		HttpClient httpClient = HttpClientBuilder.create().build();
//		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//		template.setRequestFactory(requestFactory);
// 
//		return template;
// 
//	}
	
	
}
