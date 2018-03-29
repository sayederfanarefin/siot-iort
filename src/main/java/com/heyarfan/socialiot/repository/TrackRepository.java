package com.heyarfan.socialiot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.heyarfan.socialiot.model.Thing;
import com.heyarfan.socialiot.model.Track;


public interface TrackRepository extends JpaRepository<Track, Long> {

	Track findById (long id);
    
	Track findByName(String name);
    
}
