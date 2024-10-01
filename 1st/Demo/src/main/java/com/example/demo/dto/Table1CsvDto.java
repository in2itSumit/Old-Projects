package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.CSVEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Data

public class Table1CsvDto {
	private int id;
	private String vcode;
	private List<CSVEntity> csvEntity = new ArrayList<>();
}
