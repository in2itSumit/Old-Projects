package com.demo.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ProducerConfiguration {
	@Bean
	public NewTopic createTopic()
	{
		return TopicBuilder.name("myTopic112").partitions(2).replicas(1).build();
	}
//	@Bean
//	public ProducerFactory<String, ProducerDto> producerProducerFactory() {
//		Properties configProps=new Properties();
//	    configProps.put(
//	      ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, 
//	      JsonSerializer.class);
//	    return new DefaultKafkaProducerFactory<>(configProps);
//	}
//
//	@Bean
//	public KafkaTemplate<String, Greeting> greetingKafkaTemplate() {
//	    return new KafkaTemplate<>(greetingProducerFactory());
//	}
} 