package com.heyarfan.socialiot.service;

import java.awt.Image;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyarfan.socialiot.model.Thing;
import com.heyarfan.socialiot.repository.ThingRepository;


@Service
@Transactional
public class ThingService implements IThingService {

	@Autowired
	ThingRepository thingRepository;

	@Override
	public Thing addThing(Thing thing) {
		// TODO Auto-generated method stub
		return thingRepository.save(thing);
	}

	@Override
	public void deleteThing(Thing thing) {
		// TODO Auto-generated method stub
		thingRepository.delete(thing);
	}

	@Override
	public Thing findById(long id) {
		// TODO Auto-generated method stub
		return thingRepository.findById(id);
	}

	

	@Override
	public Thing findByName(String name) {
		// TODO Auto-generated method stub
		return thingRepository.findByName(name);
	}

}
