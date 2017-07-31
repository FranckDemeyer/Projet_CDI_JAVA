package com.maville.back.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="event.findDuplicate",
				query="SELECT e FROM Event e WHERE e.name = :name AND e.hours= :hours AND e.lat = :lat AND e.lng = :lng"),
	@NamedQuery(name="event.findByDate",
				query="SELECT e FROM Event e"), // , EventHour eh WHERE e.hours = eh.eventHourId AND (eh.hour >= :datedeb AND eh.hour < :datefin)
	@NamedQuery(name="event.findByName", query="SELECT e FROM Event e WHERE e.name = :name")
})
public class Event {
	
	/* Constants */
	
	public static final String FIND_DUPLICATE = "event.findDuplicate";
	public static final String FIND_BY_DATE = "event.findByDate";
	public static final String FIND_BY_NAME = "event.findByName";
	
	/* Variables */
	
	@Id
	@GeneratedValue
	private int eventId;
	
	private String name;
	private String address;
	private String postalCode;
	private String town;
	private String lat;
	private String lng;
	private String photo;
	private String description;
	
	@ManyToOne
	private EventCategory category;
	
	@OneToMany(mappedBy = "event")
	private List<EventHour> hours;

	/* Getters and Setters */
	
	public int getEventId() {
		return eventId;
	}
	
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getTown() {
		return town;
	}
	
	public void setTown(String town) {
		this.town = town;
	}
	
	public String getLat() {
		return lat;
	}
	
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	public String getLng() {
		return lng;
	}
	
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public EventCategory getCategory() {
		return category;
	}
	
	public void setCategory(EventCategory category) {
		this.category = category;
	}
	
	public List<EventHour> getHours() {
		return hours;
	}

	public void setHours(List<EventHour> hours) {
		this.hours = hours;
	}

	/* Methods */
	
	@Override
	public String toString() {
		return "Event > eventId : " + eventId + ", name : " + name + ", address : " + address + ", postalCode : " + postalCode + ", town : "
				+ town + ", lat : " + lat + ", lng : " + lng + ", photo : " + photo + ", description : " + description;
	}
}
