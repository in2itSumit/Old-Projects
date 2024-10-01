package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "table1csv")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table1CsvEntity 
{
	
	@Id
	private int id;
	@Column(unique = true)
	private String vcode;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "entity", cascade = CascadeType.ALL)
	private List<CSVEntity> csvEntity = new ArrayList<>();
}
