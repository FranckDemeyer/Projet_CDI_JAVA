package com.maville.back.soap.implementations;

import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.EventCategoryDTO;
import com.maville.back.dto.EventDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.soap.interfaces.EventCategoryWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.EventCategoryWebService")
public class EventCategoryWebServiceImpl implements EventCategoryWebService {
	
	@Override
	public EventCategoryDTO findEventCategoryById(int id) {
		return ServiceFactory.getInstance().getEventCategoryService().getEventCategoryById(id);
	}

	@Override
	public List<EventCategoryDTO> findAllEventCategories() {
		return ServiceFactory.getInstance().getEventCategoryService().getAllEventCategories();
	}

	@Override
	public EventCategoryDTO findEventCategoryByEvent(EventDTO event) {
		return ServiceFactory.getInstance().getEventCategoryService().getEventCategoryByEvent(event);
	}

	@Override
	public EventCategoryDTO findEventCategoryByName(String name) {
		return ServiceFactory.getInstance().getEventCategoryService().getEventCategoryByName(name);
	}

	@Override
	public void addEventCategory(EventCategoryDTO eventCategory) {
		ServiceFactory.getInstance().getEventCategoryService().addEventCategory(eventCategory);
	}

	@Override
	public void deleteEventCategory(EventCategoryDTO eventCategory) {
		ServiceFactory.getInstance().getEventCategoryService().deleteEventCategory(eventCategory);
	}

	@Override
	public EventCategoryDTO updateEventCategory(EventCategoryDTO eventCategory) {
		return ServiceFactory.getInstance().getEventCategoryService().updateEventCategory(eventCategory);
	}

	@Override
	public List<EventDTO> findEventsByEventCategory(EventCategoryDTO eventCategory) {
		return ServiceFactory.getInstance().getEventCategoryService().getEventsByEventCategory(eventCategory);
	}

}
