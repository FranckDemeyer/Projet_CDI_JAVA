package com.maville.back.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="EventCategory.getCategoryByName", query="select ec from EventCategory ec where ec.name = :name")
})
public class EventCategory {
	
	public static final String GET_CATEGORY_BY_NAME = "EventCategory.getCategoryByName";
	
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
