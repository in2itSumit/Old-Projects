package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="csv")

public class CSVEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="snumber")
	private int snumber;
	@Column(name = "year")
	private int year;
	@Column(name = "ianzsioc")
	private String ianzsioc;
	@Column(name = "icnzsioc")
	private String icnzsioc;
	@Column(name = "innzsioc")
	private String innzsioc;
	@Column(name = "units")
	private String units;
	
	@Column(name = "vcode")
	private String vcode;
	@Column(name = "vname")
	private String vname;
	@Column(name = "vcategory")
	private String vcategory;
	@Column(name = "value")
	private String value;
	@Column(name = "icanzsic06")
	private String icanzsic06;

	@ManyToOne()
//    @JoinColumn(name = "id" )
    private Table1CsvEntity entity;
}
