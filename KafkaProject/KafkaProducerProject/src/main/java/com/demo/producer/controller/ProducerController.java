package com.demo.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.producer.dto.ProducerDto;
import com.demo.producer.service.ProducerServices;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	@Autowired
	private ProducerServices publisher;

	@PostMapping("publish")
	public String publishMsg(@RequestBody ProducerDto dto) {
//		System.out.println(msg);
		String response="";
		try {
			
			response=publisher.sendMessageToTopic(dto);
		
//			return ResponseEntity.ok("message published Successfully ...");
				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(response.equals("Successfull"))
			return "message published Successfully ...";
		else
			return "Unsuccess";
	}
	
}
