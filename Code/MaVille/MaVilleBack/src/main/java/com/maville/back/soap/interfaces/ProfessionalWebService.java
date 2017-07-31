package com.maville.back.soap.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;

@WebService
public interface ProfessionalWebService {
	@WebMethod
	void addProfessional(ProfessionalDTO professional) throws Exception;
	@WebMethod
	void deleteProfessional(ProfessionalDTO professional);
	@WebMethod
	ProfessionalDTO findProfessional(int professionalId);
	@WebMethod
	List<ProfessionalDTO> findAllProfessionals();
	@WebMethod
	List<ProfessionalDTO> findProfessionalsByName(String name);
	@WebMethod
	List<ProfessionalDTO> findProfessionalsByCategory(ProfessionalCategoryDTO category);
	@WebMethod
	List<ProfessionalDTO> findProfessionalsByCoord(String lat, String lng, double radius);
	@WebMethod
	ProfessionalDTO updateProfessional(ProfessionalDTO professional) throws Exception;
}
