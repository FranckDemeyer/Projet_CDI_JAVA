package com.maville.back.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {

	/* Variables */

	@Id
	@GeneratedValue
	private int accountId;
	private String username;
	private String password;
	private boolean admin;
	@OneToOne(mappedBy = "account")
	private Professional professional;

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

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	/* Methods */

	@Override
	public String toString() {
		return "Account > accountId : " + accountId + ", username : " + username + ", password : " + password + ", admin : " + admin;
	}
}
