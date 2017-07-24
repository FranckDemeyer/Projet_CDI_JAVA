package com.maville.back.dto;

import java.io.Serializable;

public class AccountDTO implements Serializable {

	/* Variables */

	private static final long serialVersionUID = 1L;
	private int accountId;
	private String username;
	private String password;
	private boolean admin;
	private ProfessionalDTO professional;

	public AccountDTO() {
	}

	public AccountDTO(String username, String password, boolean admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public AccountDTO(String username, String password, boolean admin, ProfessionalDTO professional) {
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.professional = professional;
	}
	
	/* Getters and Setters */

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public ProfessionalDTO getProfessional() {
		return professional;
	}

	public void setProfessional(ProfessionalDTO professional) {
		this.professional = professional;
	}

	/* Methods */

	@Override
	public String toString() {
		return "Account > accountId : " + accountId + ", username : " + username + ", password : " + password + ", admin : " + admin;
	}
}
