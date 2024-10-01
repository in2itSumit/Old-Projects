package com.demo.producer.entity;

import org.springframework.beans.factory.annotation.Configurable;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Configurable
public class ProducerEntity {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String add;
	public String toString()
	{
		return "{ id : "+id+", name : "+name+", add : "+add+" }";
	}
}
//ProducerRecord<String, String> record = new ProducerRecord<>("baeldung", String.valueOf(i));
//producer.send(record);