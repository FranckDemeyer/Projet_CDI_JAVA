package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.EventCategoryDTO;
import com.maville.back.dto.EventDTO;

public interface EventCategoryService {

	public EventCategoryDTO getEventCategoryById(int id);
	
	public List<EventCategoryDTO> getAllEventCategories();
	
	public EventCategoryDTO getEventCategoryByEvent(EventDTO event);
	
	public EventCategoryDTO getEventCategoryByName(String name);
	
	public void addEventCategory(EventCategoryDTO eventCategory);
	
	public void deleteEventCategory(EventCategoryDTO eventCategory);
	
	public EventCategoryDTO updateEventCategory(EventCategoryDTO eventCategory);
	
	public List<EventDTO> getEventsByEventCategory(EventCategoryDTO eventCategory);
}
