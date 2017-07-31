package com.maville.back.soap.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maville.back.dto.EventCategoryDTO;
import com.maville.back.dto.EventDTO;

@WebService
public interface EventCategoryWebService {
	@WebMethod
	public EventCategoryDTO findEventCategoryById(int id);
	@WebMethod
	public List<EventCategoryDTO> findAllEventCategories();
	@WebMethod
	public EventCategoryDTO findEventCategoryByEvent(EventDTO event);
	@WebMethod
	public EventCategoryDTO findEventCategoryByName(String name);
	@WebMethod
	public void addEventCategory(EventCategoryDTO eventCategory);
	@WebMethod
	public void deleteEventCategory(EventCategoryDTO eventCategory);
	@WebMethod
	public EventCategoryDTO updateEventCategory(EventCategoryDTO eventCategory);
	@WebMethod
	public List<EventDTO> findEventsByEventCategory(EventCategoryDTO eventCategory);
}
