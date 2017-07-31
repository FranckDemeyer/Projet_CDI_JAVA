package com.maville.back.dao.implementations;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.EventDAO;
import com.maville.back.entities.Event;

@Transactional
@Repository("eventDAOI")
public class EventDAOImpl extends GenericDAO<Event, Integer> implements EventDAO {

	public EventDAOImpl() {
		super(Event.class);
	}

}
