package com.demo.consumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.consumer.entity.ConsumerEntity;
import com.demo.consumer.repo.ConsumerRepo;

@Service
public class ConsumerService {
	@Autowired
	private ConsumerRepo repo;
	
//	Logger logger=LoggerFactory.getLogger(ConsumerService.class);
	
	@KafkaListener(topics="myTopic112", groupId="consumersGroup-1")
	public boolean consume(ConsumerEntity msg)
	{
		try 
		{
//			logger.info("Consumer cosume the message : "+msg);
//			ConsumerEntity entity=new ConsumerEntity(msg.getId(),msg.getProducer_name(),msg.getProducer_add(),msg.getMessage());
			repo.save(msg);
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
//		KafkaConsumer<String, String> consumer=new KafkaConsumer<>();
		return true;
	}
}
