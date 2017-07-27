package com.maville.back.service.implementations;

import java.util.List;

import com.maville.back.dto.EventCategoryDTO;
import com.maville.back.dto.EventDTO;
import com.maville.back.service.interfaces.EventCategoryService;

public class EventCategoryServiceImpl implements EventCategoryService {

	@Override
	public EventCategoryDTO getEventCategoryById(int id) {
		EventCategoryDTO eventCategory = null;
		// TODO 
		return eventCategory;
	}

	@Override
	public List<EventCategoryDTO> getAllEventCategories() {
		List<EventCategoryDTO> listEventCategories = null;
		// TODO 
		return listEventCategories;
	}

	@Override
	public EventCategoryDTO getEventCategoryByEvent(EventDTO event) {
		EventCategoryDTO category = null;
		// TODO 
		return category;
	}

	@Override
	public EventCategoryDTO getEventCategoryByName(String name) {
		EventCategoryDTO category = null;
		return category;
	}

	@Override
	public void addEventCategory(EventCategoryDTO eventCategory) {
		// TODO 
	}

	@Override
	public void deleteEventCategory(EventCategoryDTO eventCategory) {
		// TODO 
	}

	@Override
	public EventCategoryDTO updateEventCategory(EventCategoryDTO eventCategory) {
		return null;
	}

	@Override
	public List<EventDTO> getEventsByEventCategory(EventCategoryDTO eventCategory) {
		List<EventDTO> listEvents = null;
		// TODO 
		return listEvents;
	}

}
