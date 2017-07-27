package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.EventCategoryDTO;
import com.maville.back.dto.EventDTO;

public interface EventCategoryService {

	public EventCategoryDTO getEventCategoryById(int id);
	
	public List<EventCategoryDTO> getAllEventCategories();
	
	public List<EventDTO> getEventbyCategory(EventCategoryDTO category);
	
	public List<EventCategoryDTO> getEventCategoryByName(String name);
	
	public void addEventCategory(EventCategoryDTO eventCategory);
	
	public void deleteEventCategory(EventCategoryDTO eventCategory);
	
	public EventCategoryDTO updateEventCategory(EventCategoryDTO eventCategory);
	
}
