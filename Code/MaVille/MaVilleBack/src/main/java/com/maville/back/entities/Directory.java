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
	@NamedQuery(name="directory.getDirectoryByCoord", query="SELECT d FROM Directory d WHERE d.lat > :latMin AND d.lat < :latMax AND d.lng > :lngMin AND d.lng < :lngMax"),
	@NamedQuery(name="directory.getDirectoryByName", query="SELECT d FROM Directory d WHERE d.name = :name"),
	@NamedQuery(name="directory.getDirectoryByCategory", query="SELECT d FROM Directory WHERE d.category = :category")
})
public class Directory {
	
	/* Constants */
	
	public static final String GET_DIRECTORY_BYCOORD = "directory.getDirectoryByCoord";
	public static final String GET_DIRECTORY_BYNAME = "directory.getDirectoryByName";
	public static final String GET_DIRECTORY_BYCATEGORY = "directory.getDirectoryByCategory";
	
	/* Variables */
	
	@Id
	@GeneratedValue
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
	@ManyToOne
	private DirectoryCategory category;
	@OneToMany(mappedBy = "directory")
	private List<DirectoryHour> hours;
	
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
	
	public DirectoryCategory getCategory() {
		return category;
	}
	
	public void setCategory(DirectoryCategory category) {
		this.category = category;
	}
	
	public List<DirectoryHour> getHours() {
		return hours;
	}

	public void setHours(List<DirectoryHour> hours) {
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
