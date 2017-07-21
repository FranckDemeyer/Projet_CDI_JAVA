package com.maville.back.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="professional.getCategoryProfessionals", query="SELECT p FROM Professional p WHERE p.category=:professionalCategory")
public class Professional {
	
	/* Constants */
	
	public static String GET_CATEGORY_PROFESSIONALS = "professional.getCategoryProfessionals";
	
	/* Variables */
	
	@Id
	@GeneratedValue
	private int professionalId;
	
	private String bussinessName;
	private String name;
	private String address;
	private String postalCode;
	private String town;
	private String phone;
	private String lat;
	private String lng;
	
	@ManyToOne
	private ProfessionalCategory category;
	private boolean connected;
	
	@OneToOne
	@JoinColumn(name="account_id", referencedColumnName="accountId")
	private Account account;
	
	/* Constructors */
	
	public Professional() {
	}
	
	public Professional(String bussinessName, String name, String address, String postalCode, String town, String phone,
			String lat, String lng, boolean connected) {
		this.bussinessName = bussinessName;
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.town = town;
		this.phone = phone;
		this.lat = lat;
		this.lng = lng;
		this.connected = connected;
	}
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

	public ProfessionalCategory getCategory() {
		return category;
	}
	
	public void setCategory(ProfessionalCategory category) {
		this.category = category;
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	/* public Methods */
	
	@Override
	public String toString() {
		return "Professional > professionalId : " + professionalId + ", bussinessName : " + bussinessName + ", name : "
				+ name + ", address : " + address + ", postalCode : " + postalCode + ", town : " + town + ", phone : "
				+ phone + ", lat : " + lat + ", lng : " + lng + ", category : " + category + ", connected : "
				+ connected;
	}
}
