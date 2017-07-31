package com.maville.back.soap.implementations;

import java.util.List;

import com.maville.back.dto.EventCategoryDTO;
import com.maville.back.dto.EventDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.EventCategoryService;
import com.maville.back.soap.interfaces.EventCategoryWebService;

public class EventCategoryWebServiceImpl implements EventCategoryWebService {
	
	private EventCategoryService service = ServiceFactory.getInstance().getEventCategoryService();

	@Override
	public EventCategoryDTO findEventCategoryById(int id) {
		return service.getEventCategoryById(id);
	}

	@Override
	public List<EventCategoryDTO> findAllEventCategories() {
		return service.getAllEventCategories();
	}

	@Override
	public EventCategoryDTO findEventCategoryByEvent(EventDTO event) {
		return service.getEventCategoryByEvent(event);
	}

	@Override
	public EventCategoryDTO findEventCategoryByName(String name) {
		return service.getEventCategoryByName(name);
	}

	@Override
	public void addEventCategory(EventCategoryDTO eventCategory) {
		service.addEventCategory(eventCategory);
	}

	@Override
	public void deleteEventCategory(EventCategoryDTO eventCategory) {
		service.deleteEventCategory(eventCategory);
	}

	@Override
	public EventCategoryDTO updateEventCategory(EventCategoryDTO eventCategory) {
		return service.updateEventCategory(eventCategory);
	}

	@Override
	public List<EventDTO> findEventsByEventCategory(EventCategoryDTO eventCategory) {
		return service.getEventsByEventCategory(eventCategory);
	}

}
