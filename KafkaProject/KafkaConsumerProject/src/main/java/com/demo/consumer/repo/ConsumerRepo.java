package com.demo.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.consumer.entity.ConsumerEntity;

@Repository
public interface ConsumerRepo extends JpaRepository<ConsumerEntity, Integer>{

}
