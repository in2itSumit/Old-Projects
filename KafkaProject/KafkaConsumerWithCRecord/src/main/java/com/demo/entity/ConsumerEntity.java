package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerEntity {
	
	@Id
	private int id;
	private String name;
	private String add;
	@Override
	public String toString() {
		return "ConsumerEntity [id=" + id + ", name=" + name + ", add=" + add + "]";
	}
}
