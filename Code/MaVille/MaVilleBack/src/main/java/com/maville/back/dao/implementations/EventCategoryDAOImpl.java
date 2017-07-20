package com.maville.back.dao.implementations;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.EventCategoryDAO;
import com.maville.back.entities.EventCategory;

public class EventCategoryDAOImpl extends GenericDAO<EventCategory, Integer> implements EventCategoryDAO {

	public EventCategoryDAOImpl() {
		super(EventCategory.class);
	}

}
