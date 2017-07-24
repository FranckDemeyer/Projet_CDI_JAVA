package com.maville.back.soap.implementations;

import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.soap.interfaces.ProfessionalWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.ProfessionalWebService")
public class ProfessionalWebServiceImpl implements ProfessionalWebService {

	@Override
	public void addProfessional(ProfessionalDTO professional) throws Exception {
		ServiceFactory.getInstance().getProfessionalService().addProfessional(professional);
	}

	@Override
	public void deleteProfessional(ProfessionalDTO professional) {
		ServiceFactory.getInstance().getProfessionalService().deleteProfessional(professional);
	}

	@Override
	public ProfessionalDTO findProfessional(int professionalId) {
		return ServiceFactory.getInstance().getProfessionalService().getProfessionalById(professionalId);
	}

	@Override
	public List<ProfessionalDTO> findAllProfessionals() {
		return ServiceFactory.getInstance().getProfessionalService().getAllProfessional();
	}

	@Override
	public List<ProfessionalDTO> findProfessionalsByName(String name) {
		return ServiceFactory.getInstance().getProfessionalService().getProfessionalByName(name);
	}

	@Override
	public List<ProfessionalDTO> findProfessionalsByCategory(ProfessionalCategoryDTO category) {
		return ServiceFactory.getInstance().getProfessionalService().getProfessionalByCategory(category);
	}

	@Override
	public List<ProfessionalDTO> findProfessionalsByCoord(String lat, String lng, double radius) {
		return ServiceFactory.getInstance().getProfessionalService().getProfessionalByCoord(lat, lng, radius);
	}

	@Override
	public ProfessionalDTO updateProfessional(ProfessionalDTO professional) throws Exception {
		return ServiceFactory.getInstance().getProfessionalService().updateProfessional(professional);
	}

}
