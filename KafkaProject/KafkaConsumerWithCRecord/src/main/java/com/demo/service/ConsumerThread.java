 package com.demo.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import com.demo.entity.ConsumerEntity;
import com.demo.producer.entity.ProducerEntity;
import com.demo.repo.CoRepo;

  
@Service
public class ConsumerThread //implements Runnable { 
{
 
      KafkaConsumer<String, ProducerEntity> consumer1; 

//      @Autowired
      private CoRepo repo;
      
      private ConfigurableApplicationContext ctx;
      
      public List<ConsumerEntity> consumerList=new ArrayList<>();
      
      public ConsumerThread(ConfigurableApplicationContext ctx) 
      {
    	  this.ctx=ctx;
    	  this.repo = ctx.getBean(CoRepo.class);
    	  Properties properties = new Properties(); 
          properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); 
          properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()); 
          properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName()); 
          properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "consumersGroup-1"); 
          properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); 
          properties.setProperty(JsonDeserializer.TRUSTED_PACKAGES, "*");

          consumer1 = new KafkaConsumer<>(properties); 

          // Subscribe Consumer to Our Topics 
          consumer1.subscribe(List.of("topic111"));  
      }
      public ConsumerThread() 
      {}
      
//      public ConsumerThread(String topic1, String bootstrapServer, String groupId) { 
//      	
//          // Create Consumer Properties 
//          Properties properties = new Properties(); 
//          properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer); 
//          properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()); 
//          properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName()); 
//          properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId); 
//          properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); 
//          properties.setProperty(JsonDeserializer.TRUSTED_PACKAGES, "*");
//
//          consumer1 = new KafkaConsumer<>(properties); 
//
//          // Subscribe Consumer to Our Topics 
//          consumer1.subscribe(List.of(topic1));  
//      } 

//      @Override
      public void consume() {
          try {
        	  
              // Poll the data 
          	
              while (true) { 
                  ConsumerRecords<String, ProducerEntity> records = consumer1.poll(Duration.ofMillis(10));  
                  for (ConsumerRecord<String, ProducerEntity> record : records) { 
                  	ConsumerEntity entity=new ConsumerEntity();
                  	entity.setId(record.value().getId());
                  	entity.setAdd(record.value().getAdd());
                      entity.setName(record.value().getName());
                      System.out.println(entity);
                      System.out.println("Inside thread ");
//                      saveToList(entity);
                      repo.save(entity);
                      System.out.println("Saved Data Successfully ");

                  }
              }
          } catch (WakeupException e) { 
              System.out.println("Received shutdown signal"); 
          } finally { 
              consumer1.close(); 
//              latch.countDown(); 
          } 

      }
}      
