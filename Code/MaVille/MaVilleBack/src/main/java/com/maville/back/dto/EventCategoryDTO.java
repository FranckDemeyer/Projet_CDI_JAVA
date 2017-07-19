package com.maville.back.dto;

import java.io.Serializable;
import java.util.List;

public class EventCategoryDTO implements Serializable {
	
	/* Variables */
	
	private static final long serialVersionUID = 1L;
	private int eventCategoryId;
	private String name;
	private List<EventDTO> events;
	
	/* Getters and Setters */
	
	public int getEventCategoryId() {
		return eventCategoryId;
	}
	
	public void setEventCategoryId(int eventCategoryId) {
		this.eventCategoryId = eventCategoryId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<EventDTO> getEvents() {
		return events;
	}
	
	public void setEvents(List<EventDTO> events) {
		this.events = events;
	}
	
	/* Methods */
	
	@Override
	public String toString() {
		return "DirectoryCategory > eventCategoryId : " + eventCategoryId + ", name : " + name;
	}
	
}
