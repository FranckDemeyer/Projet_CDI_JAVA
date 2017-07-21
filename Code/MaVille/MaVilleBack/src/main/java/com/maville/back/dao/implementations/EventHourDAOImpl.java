package com.maville.back.dao.implementations;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.EventHourDAO;
import com.maville.back.entities.EventHour;

@Transactional
@Repository("eventHourDAO")
public class EventHourDAOImpl extends GenericDAO<EventHour, Integer> implements EventHourDAO {

	public EventHourDAOImpl() {
		super(EventHour.class);
	}

}
