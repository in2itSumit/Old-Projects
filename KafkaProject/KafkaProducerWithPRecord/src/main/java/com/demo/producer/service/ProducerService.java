package com.demo.producer.service;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.producer.entity.ProducerEntity;

@Service
public class ProducerService {
	@Autowired
	KafkaProducer<String, ProducerEntity> producer;
	public String produceMessage(ProducerEntity entity) throws InterruptedException, ExecutionException
	{
		ProducerRecord<String, ProducerEntity> record1 = new ProducerRecord<>("topic111", entity);
		
		producer.send(record1);
		System.out.println(record1.value());
		return "Success";

	}
}
