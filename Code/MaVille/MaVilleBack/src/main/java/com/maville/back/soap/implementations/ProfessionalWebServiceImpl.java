package com.maville.back.soap.implementations;

import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.ProfessionalService;
import com.maville.back.soap.interfaces.ProfessionalWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.ProfessionalWebService")
public class ProfessionalWebServiceImpl implements ProfessionalWebService {
	
	private ProfessionalService service = ServiceFactory.getInstance().getProfessionalService();

	@Override
	public void addProfessional(ProfessionalDTO professional) throws Exception {
		service.addProfessional(professional);
	}

	@Override
	public void deleteProfessional(ProfessionalDTO professional) {
		service.deleteProfessional(professional);
	}

	@Override
	public ProfessionalDTO findProfessional(int professionalId) {
		return service.getProfessionalById(professionalId);
	}

	@Override
	public List<ProfessionalDTO> findAllProfessionals() {
		return service.getAllProfessionals();
	}

	@Override
	public List<ProfessionalDTO> findProfessionalsByName(String name) {
		return service.getProfessionalsByName(name);
	}

	@Override
	public List<ProfessionalDTO> findProfessionalsByCategory(ProfessionalCategoryDTO category) {
		return service.getProfessionalsByCategory(category);
	}

	@Override
	public List<ProfessionalDTO> findProfessionalsByCoord(String lat, String lng, double radius) {
		return service.getProfessionalsByCoord(lat, lng, radius);
	}

	@Override
	public ProfessionalDTO updateProfessional(ProfessionalDTO professional) throws Exception {
		return service.updateProfessional(professional);
	}

}
