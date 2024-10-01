package com.demo.consumer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ConsumerEntity {
	@Id
	
	private int id;
	private String producer_name;
	private String producer_add;
	private String message;
	public ConsumerEntity(String producer_name,String producer_add,String message)
	{
		this.message=message;
		this.producer_name=producer_name;
		this.producer_add=producer_add;
	}
	public String toString()
	{
		return "{ id : "+id+", producer_name : "+producer_name+", producer_add : "+producer_add+", message : "+message+" }";
	}
}
