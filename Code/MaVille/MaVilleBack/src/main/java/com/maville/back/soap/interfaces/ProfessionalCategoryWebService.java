package com.maville.back.soap.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;

@WebService
public interface ProfessionalCategoryWebService {
	@WebMethod
	void addProfessionalCategory(ProfessionalCategoryDTO category) throws Exception;
	@WebMethod
	void deleteProfessionalCategory(ProfessionalCategoryDTO category);
	@WebMethod
	ProfessionalCategoryDTO findProfessionalCategory(int categoryId);
	@WebMethod
	List<ProfessionalCategoryDTO> findAllProfessionalCategories();
	@WebMethod
	ProfessionalCategoryDTO findProfessionalCategoryByName(String name);
	@WebMethod
	List<ProfessionalDTO> findProfessionalByProfessionalCategory(ProfessionalCategoryDTO category);
	@WebMethod
	ProfessionalCategoryDTO updateProfessionalCategory(ProfessionalCategoryDTO category) throws Exception;
}
