package com.maville.back.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="professionalCategory.findByName",
				query="SELECT pc FROM ProfessionalCategory pc WHERE pc.name = :name")
})
public class ProfessionalCategory {
	
	/* Constants */
	
	public static final String FIND_BY_NAME = "professionalCategory.findByName";
	
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
