package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;

public interface ProfessionalService {

	public ProfessionalDTO getProfessionalById(int id);
	
	public List<ProfessionalDTO> getAllProfessional();
	
	public List<ProfessionalDTO> getProfessionalByName(String name);
	
	public List<ProfessionalDTO> getProfessionalByCategory(ProfessionalCategoryDTO category);
	
	public List<ProfessionalDTO> getProfessionalByCoord(String lat, String lng, double radius);
	
	public void addProfessional(ProfessionalDTO professional);
	
	public void deleteProfessional(ProfessionalDTO professional);
	
	public void updateProfessional(ProfessionalDTO professional);
}
