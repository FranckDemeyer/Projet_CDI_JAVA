package com.maville.back.dao.implementations;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.EventDAO;
import com.maville.back.entities.Event;

public class EventDAOImpl extends GenericDAO<Event, Integer> implements EventDAO {

	public EventDAOImpl() {
		super(Event.class);
	}

}
