package com.heyarfan.socialiot.service.interfaces;

import com.heyarfan.socialiot.model.Thing;

public interface IThingService {

	Thing addThing(Thing thing);

	void deleteThing(Thing thing);

	Thing findById(long id);

	public void saveRegisteredThing(final Thing thing) ;

	Thing findByName(String name);
}
