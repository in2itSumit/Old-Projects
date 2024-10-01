package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import com.demo.service.ConsumerThread;


@EnableAutoConfiguration
@EnableSpringConfigured
@ComponentScan
public class KafkaConsumerWithCRecordApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(KafkaConsumerWithCRecordApplication.class, args);

		new ConsumerThread(ctx).consume();		
//		ConsumerThread t1=new ConsumerThread(ctx);
//		Thread tt1=new Thread(t1,"Thread-1");
//		tt1.start();
		
//		ConsumerThread bean = ctx.getBean(ConsumerThread.class);
//		bean.run();
		
	}

}
