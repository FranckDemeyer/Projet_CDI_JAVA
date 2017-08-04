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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + professionalCategoryId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessionalCategoryDTO other = (ProfessionalCategoryDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (professionalCategoryId != other.professionalCategoryId)
			return false;
		return true;
	}
	
}
