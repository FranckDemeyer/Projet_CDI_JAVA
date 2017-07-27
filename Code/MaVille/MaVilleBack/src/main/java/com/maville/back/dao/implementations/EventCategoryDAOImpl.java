package com.maville.back.dao.implementations;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.EventCategoryDAO;
import com.maville.back.entities.Event;
import com.maville.back.entities.EventCategory;

@Transactional
@Repository("eventCategoryDAOI")
public class EventCategoryDAOImpl extends GenericDAO<EventCategory, Integer> implements EventCategoryDAO {

	public EventCategoryDAOImpl() {
		super(EventCategory.class);
	}

	@Override
	public List<Event> getEventbyCategory(EventCategory category) {
		return super.find(category.getEventCategoryId()).getEvents();
	}

	
	
}
