package com.demo.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProducerDto {
	private String producer_name;
	private String producer_add;
	private String message;
	public String toString()
	{
		return "{ producer_name : "+producer_name+", producer_add : "+producer_add+", message : "+message+" }";
	}
}
