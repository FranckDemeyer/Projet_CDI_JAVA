package com.maville.back.dto;

import java.io.Serializable;
import java.util.List;

public class DirectoryDTO implements Serializable {
	
	/* Variables */
	
	private static final long serialVersionUID = 1L;
	private int directoryId;
	private String name;
	private String address;
	private String postalCode;
	private String town;
	private String phone;
	private String mail;
	private String lat;
	private String lng;
	private String photo;
	private String website;
	private String description;
	private DirectoryCategoryDTO category;
	private List<DirectoryHourDTO> hours;
	
	/* Getters and Setters */
	
	public int getDirectoryId() {
		return directoryId;
	}
	
	public void setDirectoryId(int directoryId) {
		this.directoryId = directoryId;
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
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
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
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public DirectoryCategoryDTO getCategory() {
		return category;
	}
	
	public void setCategory(DirectoryCategoryDTO category) {
		this.category = category;
	}
	
	public List<DirectoryHourDTO> getHours() {
		return hours;
	}

	public void setHours(List<DirectoryHourDTO> hours) {
		this.hours = hours;
	}

	/* Methods */
	
	@Override
	public String toString() {
		return "Annuaire > directoryId : " + directoryId + ", name : " + name + ", address : " + address + ", postalCode : " + postalCode
				+ ", town : " + town + ", phone : " + phone + ", mail : " + mail + ", lat : " + lat + ", lng : " + lng
				+ ", photo : " + photo + ", website : " + website + ", description : " + description;
	}
}
