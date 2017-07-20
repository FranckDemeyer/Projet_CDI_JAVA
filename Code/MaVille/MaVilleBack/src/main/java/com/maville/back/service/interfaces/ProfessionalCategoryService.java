package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;

public interface ProfessionalCategoryService {
	ProfessionalCategoryDTO getProfessionalCategoryById(int id);

	List<ProfessionalCategoryDTO> getAllProfessionalCategory();
	
	List<ProfessionalCategoryDTO> getProfessionalCategoryByName(String name);
	
	void addProfessionalCategory(ProfessionalCategoryDTO category);

	void deleteProfessionalCategory(ProfessionalCategoryDTO category);

	ProfessionalCategoryDTO updateProfessionalCategory(ProfessionalCategoryDTO category);
	
	List<ProfessionalDTO> getCategoryProfessionals(ProfessionalCategoryDTO professionalCategory);
}
