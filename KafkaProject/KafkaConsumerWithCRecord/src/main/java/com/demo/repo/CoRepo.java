package com.demo.repo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.ConsumerEntity;

@Repository
@Configurable
public interface CoRepo extends JpaRepository<ConsumerEntity, Integer> {

}
