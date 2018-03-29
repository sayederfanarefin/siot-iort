package com.heyarfan.socialiot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heyarfan.socialiot.model.Component;
import com.heyarfan.socialiot.model.Thing;


public interface ComponentRepository extends JpaRepository<Component, Long> {

	Component findById (long id);
    
	Component findByName(String name);
    
}
