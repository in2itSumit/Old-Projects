
package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Table1CsvEntity;

@Repository
public interface Table1CsvRepo  extends JpaRepository<Table1CsvEntity, Integer>
{
}
