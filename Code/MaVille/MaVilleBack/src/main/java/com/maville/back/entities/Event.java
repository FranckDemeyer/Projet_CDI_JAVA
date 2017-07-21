package com.maville.back.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Event {
	
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
