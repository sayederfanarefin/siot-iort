package com.heyarfan.socialiot.service.interfaces;

import com.heyarfan.socialiot.model.Thing;

public interface ISocialGroupService {

	Thing addThing(Thing thing);

	void deleteThing(Thing thing);

	Thing findById(long id);

	

	Thing findByName(String name);
}
