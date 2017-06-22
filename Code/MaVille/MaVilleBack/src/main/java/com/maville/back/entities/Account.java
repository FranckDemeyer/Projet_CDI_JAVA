package com.maville.back.entities;
public class Account {
	/* Variables */
	private int id;
	private String username;
	private String password;
	private boolean admin;
	private Professional professional;
	/* Getters and Setters */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin
				+ ", professional=" + professional + "]";
	}
}
