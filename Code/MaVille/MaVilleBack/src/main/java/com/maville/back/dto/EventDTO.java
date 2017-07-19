package com.maville.back.dto;

import java.io.Serializable;
import java.util.List;

public class EventDTO implements Serializable {
	
	/* Variables */
	
	private static final long serialVersionUID = 1L;
	private int eventId;
	private String name;
	private String address;
	private String postalCode;
	private String town;
	private String lat;
	private String lng;
	private String photo;
	private String description;
	private EventCategoryDTO category;
	private List<EventHourDTO> hours;

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
	
	public EventCategoryDTO getCategory() {
		return category;
	}
	
	public void setCategory(EventCategoryDTO category) {
		this.category = category;
	}
	
	public List<EventHourDTO> getHours() {
		return hours;
	}

	public void setHours(List<EventHourDTO> hours) {
		this.hours = hours;
	}

	/* Methods */
	
	@Override
	public String toString() {
		return "Event > eventId : " + eventId + ", name : " + name + ", address : " + address + ", postalCode : " + postalCode + ", town : "
				+ town + ", lat : " + lat + ", lng : " + lng + ", photo : " + photo + ", description : " + description;
	}
}
