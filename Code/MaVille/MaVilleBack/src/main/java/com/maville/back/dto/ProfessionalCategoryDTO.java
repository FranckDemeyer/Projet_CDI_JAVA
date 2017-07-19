package com.maville.back.dto;

import java.io.Serializable;
import java.util.List;

public class ProfessionalCategoryDTO implements Serializable {
	
	/* Variables */
	
	private static final long serialVersionUID = 1L;
	private int professionalCategoryId;
	private String name;
	private List<ProfessionalDTO> professionals;
	
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
	
	public List<ProfessionalDTO> getProfessionals() {
		return professionals;
	}

	public void setProfessionals(List<ProfessionalDTO> professionals) {
		this.professionals = professionals;
	}

	/* Methods */
	
	@Override
	public String toString() {
		return "Category > professionalCategoryId : " + professionalCategoryId + ", name : " + name;
	}
	
}
