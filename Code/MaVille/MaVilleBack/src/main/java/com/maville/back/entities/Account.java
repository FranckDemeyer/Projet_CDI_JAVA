package com.maville.back.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name="Account.findAllProfessional", query="SELECT a FROM Account a WHERE a.admin=false"),
	@NamedQuery(name="Account.findAllAdmin", query="SELECT a FROM Account a WHERE a.admin=true")
})
public class Account {
	
	/* Constants */
	
	public final static String FIND_ALL_PROFESSIONAL ="Account.findAllProfessional";
	public final static String FIND_ALL_ADMIN ="Account.findAllAdmin";
	
	/* Variables */

	@Id
	@GeneratedValue
	private int accountId;
	private String username;
	private String password;
	private boolean admin;
	@OneToOne(mappedBy = "account", cascade=CascadeType.ALL)
	private Professional professional;

	/* Constructors */
	
	public Account() {
	}

	public Account(String username, String password, boolean admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public Account(String username, String password, boolean admin, Professional professional) {
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

	public Professional getProfessional() {
		return professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	/* Methods */

	@Override
	public String toString() {
		return "Account > accountId : " + accountId + ", username : " + username + ", password : " + password
				+ ", admin : " + admin + ", professional : " + professional;
	}
}
