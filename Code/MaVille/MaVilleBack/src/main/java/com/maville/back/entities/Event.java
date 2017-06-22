package com.maville.back.entities;
import java.util.List;
public class Event {
	/* Variables */
	private int id;
	private String name;
	private String address;
	private String postalCode;
	private String town;
	private String lat;
	private String lng;
	private Category category;
	private List<EventHour> hours;
	private String photo;
	private String description;
	/* Getters and Setters */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<EventHour> getHours() {
		return hours;
	}
	public void setHours(List<EventHour> hours) {
		this.hours = hours;
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
	/* Methods */
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", address=" + address + ", postalCode=" + postalCode + ", town="
				+ town + ", lat=" + lat + ", lng=" + lng + ", category=" + category + ", photo=" + photo
				+ ", description=" + description + "]";
	}
}
