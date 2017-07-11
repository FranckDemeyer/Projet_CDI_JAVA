package com.maville.back.service;

import java.util.List;

import com.maville.back.entities.ProfessionalCategory;

public interface ProfessionalCategoryService {
	
	ProfessionalCategory getById(int id);
	
	List<ProfessionalCategory> getAll();
	
	void add(ProfessionalCategory category);
	
	void delete(ProfessionalCategory category);
	
	void update(ProfessionalCategory category);
	
}
