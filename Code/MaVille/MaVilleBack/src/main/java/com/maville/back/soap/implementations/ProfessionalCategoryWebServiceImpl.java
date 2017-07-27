package com.maville.back.soap.implementations;

import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.ProfessionalCategoryService;
import com.maville.back.soap.interfaces.ProfessionalCategoryWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.ProfessionalCategoryWebService")
public class ProfessionalCategoryWebServiceImpl implements ProfessionalCategoryWebService {
	
	private ProfessionalCategoryService service = ServiceFactory.getInstance().getProfessionalCategoryService();

	@Override
	public void addProfessionalCategory(ProfessionalCategoryDTO category) throws Exception {
		service.addProfessionalCategory(category);
	}
	
	@Override
	public void deleteProfessionalCategory(ProfessionalCategoryDTO category) {
		service.deleteProfessionalCategory(category);
	}

	@Override
	public ProfessionalCategoryDTO findProfessionalCategory(int categoryId) {
		return service.getProfessionalCategoryById(categoryId);
	}

	@Override
	public List<ProfessionalCategoryDTO> findAllProfessionalCategories() {
		return service.getAllProfessionalCategories();
	}

	@Override
	public ProfessionalCategoryDTO findProfessionalCategoryByName(String name) {
		return service.getProfessionalCategoryByName(name);
	}

	@Override
	public List<ProfessionalDTO> findProfessionalByProfessionalCategory(ProfessionalCategoryDTO category) {
		return service.getProfessionalsByProfessionalCategory(category);
	}

	@Override
	public ProfessionalCategoryDTO updateProfessionalCategory(ProfessionalCategoryDTO category) throws Exception {
		return service.updateProfessionalCategory(category);
	}

}
