package com.maville.back.soap.implementations;

import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.soap.interfaces.ProfessionalCategoryWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.ProfessionalCategoryWebService")
public class ProfessionalCategoryWebServiceImpl implements ProfessionalCategoryWebService {

	@Override
	public void addProfessionalCategory(ProfessionalCategoryDTO category) throws Exception {
		ServiceFactory.getInstance().getProfessionalCategoryService().addProfessionalCategory(category);
	}
	
	@Override
	public void deleteProfessionalCategory(ProfessionalCategoryDTO category) {
		ServiceFactory.getInstance().getProfessionalCategoryService().deleteProfessionalCategory(category);
	}

	@Override
	public ProfessionalCategoryDTO findProfessionalCategory(int categoryId) {
		return ServiceFactory.getInstance().getProfessionalCategoryService().getProfessionalCategoryById(categoryId);
	}

	@Override
	public List<ProfessionalCategoryDTO> findAllProfessionalCategories() {
		return ServiceFactory.getInstance().getProfessionalCategoryService().getAllProfessionalCategory();
	}

	@Override
	public List<ProfessionalCategoryDTO> findProfessionalCategoriesByName(String name) {
		return ServiceFactory.getInstance().getProfessionalCategoryService().getProfessionalCategoryByName(name);
	}

	@Override
	public List<ProfessionalDTO> findProfessionalByProfessionalCategory(ProfessionalCategoryDTO category) {
		return ServiceFactory.getInstance().getProfessionalCategoryService().getCategoryProfessionals(category);
	}

	@Override
	public ProfessionalCategoryDTO updateProfessionalCategory(ProfessionalCategoryDTO category) throws Exception {
		return ServiceFactory.getInstance().getProfessionalCategoryService().updateProfessionalCategory(category);
	}

}
