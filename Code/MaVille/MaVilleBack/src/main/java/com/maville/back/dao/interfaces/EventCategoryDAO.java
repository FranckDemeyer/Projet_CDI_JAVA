package com.maville.back.dao.interfaces;

import java.util.List;

import com.maville.back.dao.generics.AbstractDAO;
import com.maville.back.entities.Event;
import com.maville.back.entities.EventCategory;

public interface EventCategoryDAO extends AbstractDAO<EventCategory, Integer> {

	public List<Event> getEventbyCategory(EventCategory category);

}
