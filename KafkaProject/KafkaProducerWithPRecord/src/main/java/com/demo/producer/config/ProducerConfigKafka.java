package com.demo.producer.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.demo.producer.entity.ProducerEntity;


@Configuration
public class ProducerConfigKafka {

    @Bean
    public KafkaProducer<String, ProducerEntity> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
    	Properties configProps=new Properties();
        configProps.put(
          ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
          "localhost:9092");
        configProps.put(
          ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
          StringSerializer.class);
        configProps.put(
          ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, 
          JsonSerializer.class);
        return new KafkaProducer<>(configProps);
    }

//    @Bean
//    public KafkaTemplate<String, ProducerEntity> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
}


