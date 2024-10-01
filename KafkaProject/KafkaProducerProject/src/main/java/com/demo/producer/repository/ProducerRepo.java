package com.demo.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.producer.entity.ProducerEntity;

@Repository
public interface ProducerRepo extends JpaRepository<ProducerEntity, Integer>{

}
