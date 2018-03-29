package com.heyarfan.socialiot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heyarfan.socialiot.model.Tag;
import com.heyarfan.socialiot.model.Thing;


public interface TagRepository extends JpaRepository<Tag, Long> {

	Tag findById (long id);
    
	Tag findByName(String name);
    
}
