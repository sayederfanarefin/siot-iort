package com.heyarfan.socialiot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heyarfan.socialiot.model.SocialGroup;
import com.heyarfan.socialiot.model.Thing;


public interface SocialGroupRepository extends JpaRepository<SocialGroup, Long> {

	SocialGroup findById (long id);
    
	SocialGroup findByName(String name);
    
}
