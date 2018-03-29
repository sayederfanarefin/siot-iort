package com.heyarfan.socialiot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heyarfan.socialiot.model.Type;


public interface TypeRepository extends JpaRepository<Type, Long> {

	Type findById (long id);
    
	Type findByName(String name);
    
}
