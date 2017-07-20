package com.maville.back.dao.implementations;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.EventHourDAO;
import com.maville.back.entities.EventHour;

public class EventHourDAOImpl extends GenericDAO<EventHour, Integer> implements EventHourDAO {

	public EventHourDAOImpl() {
		super(EventHour.class);
	}

}
