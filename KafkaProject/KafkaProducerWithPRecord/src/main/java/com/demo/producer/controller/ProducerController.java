package com.demo.producer.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.producer.entity.ProducerEntity;
import com.demo.producer.service.ProducerService;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	@Autowired
	ProducerService service;
	@PostMapping("produce")
	public String publish(@RequestBody ProducerEntity entity) throws InterruptedException, ExecutionException
	{
		
		return service.produceMessage(entity);
	}
}
