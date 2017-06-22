package com.maville.back.entities;
public class Professional {
	/* Variables */
	private int id;
	private String bussinessName;
	private String lastName;
	private String firstName;
	private String address;
	private String postalCode;
	private String Town;
	private Category category;
	private boolean connected;
	/* Getters and Setters */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBussinessName() {
		return bussinessName;
	}
	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
		return Town;
	}
	public void setTown(String town) {
		Town = town;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean isConnected() {
		return connected;
	}
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	/* Methods */
	@Override
	public String toString() {
		return "Professional [id=" + id + ", bussinessName=" + bussinessName + ", lastName=" + lastName + ", firstName="
				+ firstName + ", address=" + address + ", postalCode=" + postalCode + ", Town=" + Town + ", category="
				+ category + ", connected=" + connected + "]";
	}
}
