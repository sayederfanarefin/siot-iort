package com.heyarfan.socialiot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heyarfan.socialiot.model.Model;


public interface ModelRepository extends JpaRepository<Model, Long> {

	Model findById (long id);
    
	Model findByName(String name);
    
}
