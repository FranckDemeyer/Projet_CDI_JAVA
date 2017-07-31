package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;

public interface ProfessionalService {

	public ProfessionalDTO getProfessionalById(int id);
	
	public List<ProfessionalDTO> getAllProfessionals();
	
	public List<ProfessionalDTO> getProfessionalsByName(String name);
	
	public List<ProfessionalDTO> getProfessionalsByCategory(ProfessionalCategoryDTO category);
	
	public List<ProfessionalDTO> getProfessionalsByCoord(String lat, String lng, double radius);
	
	public void addProfessional(ProfessionalDTO professional);
	
	public void deleteProfessional(ProfessionalDTO professional);
	
	public ProfessionalDTO updateProfessional(ProfessionalDTO professional);
}
