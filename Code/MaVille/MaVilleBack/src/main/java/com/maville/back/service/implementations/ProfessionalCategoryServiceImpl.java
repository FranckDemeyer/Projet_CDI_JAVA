package com.maville.back.service.implementations;

import java.util.List;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.service.interfaces.ProfessionalCategoryService;

public class ProfessionalCategoryServiceImpl implements ProfessionalCategoryService {
	
	@Override
	public ProfessionalCategoryDTO getProfessionalCategoryById(int id) {
		return null;
	}
	
	@Override
	public List<ProfessionalCategoryDTO> getAllProfessionalCategory() {
		return null;
	}
	
	@Override
<<<<<<< HEAD
	public void addProfessionalCategory(ProfessionalCategoryDTO category) {
=======
	public List<ProfessionalCategoryDTO> getProfessionalCategoryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(ProfessionalCategoryDTO category) {
>>>>>>> 0a64aa8b9a45cafc693b9a88a4b1a11938b58893

	}

	@Override
	public void deleteProfessionalCategory(ProfessionalCategoryDTO category) {

	}
	
	@Override
	public void updateProfessionalCategory(ProfessionalCategoryDTO category) {

	}

	@Override
	public List<ProfessionalDTO> getCategoryProfessionals(ProfessionalCategoryDTO professionalCategory) {
		// TODO Auto-generated method stub
		return null;
	}
}
