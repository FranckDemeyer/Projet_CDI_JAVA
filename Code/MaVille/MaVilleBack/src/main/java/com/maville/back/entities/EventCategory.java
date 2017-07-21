package com.maville.back.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EventCategory {
	
	/* Variables */
	
	@Id
	@GeneratedValue
	private int eventCategoryId;
	
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<Event> events;
	
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
	
	public List<Event> getEvents() {
		return events;
	}
	
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	/* Methods */
	
	@Override
	public String toString() {
		return "DirectoryCategory > eventCategoryId : " + eventCategoryId + ", name : " + name;
	}
	
}
