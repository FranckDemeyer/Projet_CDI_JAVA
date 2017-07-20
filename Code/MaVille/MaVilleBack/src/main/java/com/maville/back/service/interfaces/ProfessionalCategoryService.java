package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;

public interface ProfessionalCategoryService {
	ProfessionalCategoryDTO getById(int id);

	List<ProfessionalCategoryDTO> getAll();
	
	List<ProfessionalCategoryDTO> getProfessionalCategoryByName(String name);
	
	void add(ProfessionalCategoryDTO category);

	void delete(ProfessionalCategoryDTO category);

	ProfessionalCategoryDTO update(ProfessionalCategoryDTO category);
	
	List<ProfessionalDTO> getCategoryProfessionals(ProfessionalCategoryDTO professionalCategory);
}
