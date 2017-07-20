package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;

public interface ProfessionalCategoryService {
<<<<<<< HEAD
	ProfessionalCategoryDTO getProfessionalCategoryById(int id);
	List<ProfessionalCategoryDTO> getAllProfessionalCategory();
	void addProfessionalCategory(ProfessionalCategoryDTO category);
	void deleteProfessionalCategory(ProfessionalCategoryDTO category);
	void updateProfessionalCategory(ProfessionalCategoryDTO category);
=======
	ProfessionalCategoryDTO getById(int id);

	List<ProfessionalCategoryDTO> getAll();
	
	List<ProfessionalCategoryDTO> getProfessionalCategoryByName(String name);
	
	void add(ProfessionalCategoryDTO category);

	void delete(ProfessionalCategoryDTO category);

	void update(ProfessionalCategoryDTO category);
	
	List<ProfessionalDTO> getCategoryProfessionals(ProfessionalCategoryDTO professionalCategory);
>>>>>>> 0a64aa8b9a45cafc693b9a88a4b1a11938b58893
}
