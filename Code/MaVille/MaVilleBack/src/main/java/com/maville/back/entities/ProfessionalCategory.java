package com.maville.back.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProfessionalCategory {
	
	/* Variables */
	
	@Id
	@GeneratedValue
	private int professionalCategoryId;
	
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<Professional> professionals;
	
	/* Getters and Setters */
	
	public int getProfessionalCategoryId() {
		return professionalCategoryId;
	}
	
	public void setProfessionalCategoryId(int professionalCategoryId) {
		this.professionalCategoryId = professionalCategoryId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Professional> getProfessionals() {
		return professionals;
	}

	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}

	/* Methods */
	
	@Override
	public String toString() {
		return "Category > professionalCategoryId : " + professionalCategoryId + ", name : " + name;
	}
	
}
