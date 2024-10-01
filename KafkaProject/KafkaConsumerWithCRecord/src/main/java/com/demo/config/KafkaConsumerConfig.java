//package com.demo.config;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//import java.util.UUID;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import com.demo.entity.ProducerEntity;
//
//@EnableKafka
//@Configuration
//@Configurable
//public class KafkaConsumerConfig {
//
//    @Bean
//    public KafkaConsumer<String, ProducerEntity> consumerFactory() 
//    {
////        Map<String, Object> props = new HashMap<>();
////        props.put(
////          ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
////        props.put(
////          ConsumerConfig.GROUP_ID_CONFIG, 
////          "consumersGroup-1");
////        props.put(
////          ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
////          StringDeserializer.class);
////        props.put(
////          ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
////          JsonDeserializer.class);
////        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
////        return new DefaultKafkaConsumerFactory<>(props);
//    	Properties props=new Properties();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName()); 
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "consumersGroup-1");
//        System.out.println("heeheeheehee");
////        return new DefaultKafkaConsumerFactory<>(props);
//        return new KafkaConsumer<>(props);
//    }
////
//////    @Bean
//////    public KafkaConsumer<String, ProducerEntity> kafkaConsumerFactory() {
//////   
//////    	KafkaConsumer<String, ProducerEntity> factory = new KafkaConsumer<>(consumerFactory());
////////        factory.setConsumerFactory(consumerFactory());
//////        return factory;
//////    }
//
//	
//	
////    public KafkaConsumerConfig() {
////        this("topic111", defaultKafkaConsumer());
////    }
////    @Bean
////    static KafkaConsumer<String, ProducerEntity> defaultKafkaConsumer() {
////        Properties props = new Properties();
////        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
////        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "test_group_id");
////        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
////        props.put("enable.auto.commit", "true");
////        props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
////        props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
////        System.out.println("Heeheeheeheehee");
////        return new KafkaConsumer<>(props);
////    }
//}
