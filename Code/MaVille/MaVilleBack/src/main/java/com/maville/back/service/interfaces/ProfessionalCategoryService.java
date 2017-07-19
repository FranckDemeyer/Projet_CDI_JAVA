package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.ProfessionalCategoryDTO;

public interface ProfessionalCategoryService {
	ProfessionalCategoryDTO getProfessionalCategoryById(int id);
	List<ProfessionalCategoryDTO> getAllProfessionalCategory();
	void addProfessionalCategory(ProfessionalCategoryDTO category);
	void deleteProfessionalCategory(ProfessionalCategoryDTO category);
	void updateProfessionalCategory(ProfessionalCategoryDTO category);
}
