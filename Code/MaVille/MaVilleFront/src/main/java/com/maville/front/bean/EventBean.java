package com.maville.front.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.EventDTO;
import com.maville.back.factories.ServiceFactory;

@ManagedBean(name="event")
@SessionScoped
public class EventBean {
	
	/* Variables */
	
	private EventDTO event = new EventDTO();
	private static Map<Integer, EventDTO> events = new HashMap<>();
	
	/* Getters and Setters */
	
	public EventDTO getEvent() {
		return event;
	}
	
	public void setEvent(EventDTO event) {
		this.event = event;
	}
	
	public static Map<Integer, EventDTO> getEvents() {
		return events;
	}
	
	public static void setEvents(Map<Integer, EventDTO> events) {
		EventBean.events = events;
	}
	
	/* Methods */
	
	private static void addEvent(EventDTO event) {
		events.put(event.getEventId(), event);
	}
	
	private static void deleteEvent(EventDTO event) {
		events.remove(event.getEventId());
	}
	
	private static void updateEvent(EventDTO event) {
		events.put(event.getEventId(), event);
	}
	
	public String add() {
		ServiceFactory.getInstance().getEventService().addEvent(event);
		addEvent(event);
		return "add";
	}
	
	public String delete() {
		ServiceFactory.getInstance().getEventService().deleteEvent(event);
		deleteEvent(event);
		return "delete";
	}
	
	public String update() {
		event = ServiceFactory.getInstance().getEventService().updateEvent(event);
		updateEvent(event);
		return "update";
	}

}
