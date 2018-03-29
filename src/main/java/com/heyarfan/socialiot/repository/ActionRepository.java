package com.heyarfan.socialiot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heyarfan.socialiot.model.Action;


public interface ActionRepository extends JpaRepository<Action, Long> {

	Action findById (Long id);
    
	Action findByName(String name);
    
}
