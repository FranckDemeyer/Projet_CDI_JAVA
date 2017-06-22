package com.maville.back.entities;
import java.util.List;
public class Directory {
	/* Variables */
	private int id;
	private String name;
	private String address;
	private String postalCode;
	private String town;
	private String phone;
	private String mail;
	private String lat;
	private String lng;
	private List<DirectoryHour> hours;
	private String photo;
	private String website;
	private String description;
	private Category category;
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
	public List<DirectoryHour> getHours() {
		return hours;
	}
	public void setHours(List<DirectoryHour> hours) {
		this.hours = hours;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	/* Methods */
	@Override
	public String toString() {
		return "Annuaire [id=" + id + ", name=" + name + ", address=" + address + ", postalCode=" + postalCode
				+ ", town=" + town + ", phone=" + phone + ", mail=" + mail + ", lat=" + lat + ", lng=" + lng
				+ ", hours=" + hours + ", photo=" + photo + ", website=" + website + ", description=" + description
				+ "]";
	}
}
