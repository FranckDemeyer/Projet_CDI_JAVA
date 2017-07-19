package com.maville.back.dto;

import java.io.Serializable;

public class ProfessionalDTO implements Serializable {
	
	/* private Variables */
	
	private static final long serialVersionUID = 1L;
	private int professionalId;
	private String bussinessName;
	private String name;
	private String address;
	private String postalCode;
	private String town;
	private String phone;
	private ProfessionalCategoryDTO category;
	private boolean connected;
	private AccountDTO account;

	/* Getters and Setters */
	
	public int getProfessionalId() {
		return professionalId;
	}
	
	public void setProfessionalId(int professionalId) {
		this.professionalId = professionalId;
	}
	
	public String getBussinessName() {
		return bussinessName;
	}
	
	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
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
	
	public ProfessionalCategoryDTO getCategory() {
		return category;
	}
	
	public void setCategory(ProfessionalCategoryDTO category) {
		this.category = category;
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	/* public Methods */
	
	@Override
	public String toString() {
		return "Professional > professionalId : " + professionalId + ", bussinessName : " + bussinessName + ", name : " + name  + ", address : " + address + ", postalCode : " + postalCode +
				", town : " + town + ", phone : " + phone + ", connected : " + connected;
	}
}
