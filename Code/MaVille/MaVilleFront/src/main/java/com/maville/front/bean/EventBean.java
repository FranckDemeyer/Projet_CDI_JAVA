package com.maville.front.bean;

import java.time.LocalDateTime;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.EventDTO;
import com.maville.back.dto.EventHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.EventService;

@ManagedBean(name="event")
@SessionScoped
public class EventBean {
	
	/* Variables */
	
	private EventDTO event = new EventDTO();
	private EventService service = ServiceFactory.getInstance().getEventService();
	
	/* Getters and Setters */
	
	public EventDTO getEvent() {
		return event;
	}
	
	public void setEvent(EventDTO event) {
		this.event = event;
	}
	
	/* Methods */
	
	public EventDTO getEventById(int id) {
		return service.getEventById(id);
	}
	
	public List<EventDTO> getAllEvents() {
		return service.getAllEvents();
	}
	
	public List<EventDTO> getEventsByName(String name) {
		return service.getEventsByName(name);
	}
	
	public List<EventDTO> getEventsByDate(LocalDateTime date) {
		return service.getEventsByDate(date);
	}
	
	public List<EventDTO> getEventsByDateRange(LocalDateTime start, LocalDateTime end) {
		return service.getEventsByDateRange(start, end);
	}
	
	public List<EventHourDTO> getEventHours(EventDTO event) {
		return service.getEventHours(event);
	}
	
	public String add() {
		service.addEvent(event);
		return "event-added";
	}
	
	public String delete() {
		service.deleteEvent(event);
		return "event-deleted";
	}
	
	public String edit(EventDTO event) {
		this.event = event;
		return "event-edit";
	}
	
	public String update() {
		event = service.updateEvent(event);
		return "event-updated";
	}

}
