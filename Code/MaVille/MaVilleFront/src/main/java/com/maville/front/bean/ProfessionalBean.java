package com.maville.front.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.ProfessionalService;

@ManagedBean(name="professional")
@SessionScoped
public class ProfessionalBean {

	/* Variables */
	
	private ProfessionalDTO professional = new ProfessionalDTO();
	private ProfessionalService service = ServiceFactory.getInstance().getProfessionalService();
	
	/* Getters and Setters */
	
	public ProfessionalDTO getProfessional() {
		return professional;
	}
	
	public void setProfessional(ProfessionalDTO professional) {
		this.professional = professional;
	}
	
	/* Methods */
	
	public ProfessionalDTO getProfessionalById(int id) {
		return service.getProfessionalById(id);
	}
	
	public List<ProfessionalDTO> getAllProfessionals() {
		return service.getAllProfessionals();
	}
	
	public List<ProfessionalDTO> getProfessionalsByName(String name) {
		return service.getProfessionalsByName(name);
	}
	
	public List<ProfessionalDTO> getProfessionalsByCategory(ProfessionalCategoryDTO category) {
		return service.getProfessionalsByCategory(category);
	}
	
	public List<ProfessionalDTO> getProfessionalsByCoord(String lat, String lng, double rayon) {
		return service.getProfessionalsByCoord(lat, lng, rayon);
	}
	
	public String add() {
		service.addProfessional(professional);
		return "professional-added";
	}
	
	public String delete() {
		service.deleteProfessional(professional);
		return "professional-deleted";
	}
	
	public String edit(ProfessionalDTO professional) {
		this.professional = professional;
		return "professional-edit";
	}
	
	public String update() {
		professional = service.updateProfessional(professional);
		return "professional-updated";
	}
	
}
