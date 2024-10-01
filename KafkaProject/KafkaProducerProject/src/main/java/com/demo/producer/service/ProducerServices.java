package com.demo.producer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.consumer.entity.ConsumerEntity;
import com.demo.producer.dto.ProducerDto;
import com.demo.producer.entity.ProducerEntity;
import com.demo.producer.repository.ProducerRepo;

@Service
public class ProducerServices {
	@Autowired
	private KafkaTemplate<String,ConsumerEntity> template;
	@Autowired
	private ProducerRepo repo;
	
//	public String sendMessageToTopic(String message)
	public String sendMessageToTopic(ProducerDto dto)
	{

		ProducerEntity entity=new ProducerEntity();
		entity.setMessage(dto.getMessage());
		entity.setProducer_add(dto.getProducer_add());
		entity.setProducer_name(dto.getProducer_name());
		repo.save(entity);
//		List<ProducerEntity> list=repo.findAll();
		ConsumerEntity consumer=new ConsumerEntity();
		consumer.setId(entity.getId());
		consumer.setMessage(entity.getMessage());
		consumer.setProducer_add(entity.getProducer_add());
		consumer.setProducer_name(entity.getProducer_name());
		this.template.send("myTopic112", consumer);
		return "Successfull";
	}
}
