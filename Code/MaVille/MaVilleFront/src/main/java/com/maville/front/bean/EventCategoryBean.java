package com.maville.front.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.EventCategoryDTO;
import com.maville.back.dto.EventDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.EventCategoryService;

@ManagedBean(name="eventCategory")
@SessionScoped
public class EventCategoryBean implements Serializable {

	/* Variables */
	
	private static final long serialVersionUID = 1L;
	private EventCategoryDTO category = new EventCategoryDTO();
	private EventCategoryService service = ServiceFactory.getInstance().getEventCategoryService();

	/* Getters and Setters */
	
	public EventCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(EventCategoryDTO category) {
		this.category = category;
	}

	/* Methods */
	
	public EventCategoryDTO getEventCategoryById(int id) {
		return service.getEventCategoryById(id);
	}
	
	public List<EventCategoryDTO> getAllEventCategories() {
		return service.getAllEventCategories();
	}
	
	public EventCategoryDTO getEventCategoriesByEvent(EventDTO event) {
		return service.getEventCategoryByEvent(event);
	}
	
	public EventCategoryDTO getEventCategoryByName(String name) {
		return service.getEventCategoryByName(name);
	}
	
	public List<EventDTO> getEventsByEventCategory(EventCategoryDTO category) {
		return service.getEventsByEventCategory(category);
	}
	
	public String add() {
		service.addEventCategory(category);
		return "ecategory-added";
	}
	
	public String delete() {
		service.deleteEventCategory(category);
		return "ecategory-deleted";
	}
	
	public String edit(EventCategoryDTO category) {
		this.category = category;
		return "ecategory-edit";
	}
	
	public String update() {
		category = service.updateEventCategory(category);
		return "ecategory-updated";
	}
	
}
