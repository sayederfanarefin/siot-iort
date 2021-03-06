package com.heyarfan.socialiot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heyarfan.socialiot.model.Thing;


public interface ThingRepository extends JpaRepository<Thing, Long> {

    Thing findById (long id);
    
    Thing findByName(String name);
    
    Thing findByMacAddress(String mac);
}
