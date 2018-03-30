package com.heyarfan.socialiot.service;

import java.awt.Image;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.heyarfan.socialiot.exception.ThingAlreadyExistException;
import com.heyarfan.socialiot.model.Thing;
import com.heyarfan.socialiot.repository.ThingRepository;
import com.heyarfan.socialiot.service.interfaces.IActionService;
import com.heyarfan.socialiot.service.interfaces.IThingService;



@Service
@Transactional
public class ActionService implements IActionService {

	@Autowired
	ThingRepository thingRepository;


	@Autowired
    private PasswordEncoder passwordEncoder;

	
	public Thing addThing(Thing thing) {
		// TODO Auto-generated method stub
		
		
		
		if (macExist(thing.getMacAddress())) {
            throw new ThingAlreadyExistException("There is a Thing with this mac adress: " + thing.getMacAddress());
        }
        
        final Thing thing_ = new Thing();

        thing_.setMacAddress(thing.getMacAddress());
        thing_.setPublicKey(passwordEncoder.encode(thing.getPublicKey()));
        thing_.setName(thing.getName());
        thing_.setTags(thing.getTags());
        thing_.setSocilGroups(thing.getSocilGroups());
        
		return thingRepository.save(thing_);
	}

	private boolean macExist(final String mac) {
        return thingRepository.findByMacAddress(mac) != null;
    }



    public void saveRegisteredThing(final Thing thing) {
    	thingRepository.save(thing);
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
