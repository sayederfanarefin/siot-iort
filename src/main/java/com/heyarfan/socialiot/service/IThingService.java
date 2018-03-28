package com.heyarfan.socialiot.service;

import com.heyarfan.socialiot.model.Thing;

public interface IThingService {

	Thing addThing(Thing thing);

	void deleteThing(Thing thing);

	Thing findById(long id);

	Thing findByParentId(long parentId);

	Thing findByName(String name);
}
