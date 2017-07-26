package com.maville.front.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.factories.ServiceFactory;

@ManagedBean(name="professional")
@SessionScoped
public class ProfessionalBean {

	/* Variables */
	
	private ProfessionalDTO professional = new ProfessionalDTO();
	private static Map<Integer, ProfessionalDTO> professionals = new HashMap<>();
	
	/* Getters and Setters */
	
	public ProfessionalDTO getProfessional() {
		return professional;
	}
	
	public void setProfessional(ProfessionalDTO professional) {
		this.professional = professional;
	}
	
	public static Map<Integer, ProfessionalDTO> getProfessionals() {
		return professionals;
	}
	
	public static void setProfessionals(Map<Integer, ProfessionalDTO> professionals) {
		ProfessionalBean.professionals = professionals;
	}

	/* Methods */
	
	private static void addProfessional(ProfessionalDTO professional) {
		professionals.put(professional.getProfessionalId(), professional);
	}
	
	private static void deleteProfessional(ProfessionalDTO professional) {
		professionals.remove(professional.getProfessionalId());
	}
	
	private static void updateProfessional(ProfessionalDTO professional) {
		professionals.put(professional.getProfessionalId(), professional);
	}
	
	public String add() {
		ServiceFactory.getInstance().getProfessionalService().addProfessional(professional);
		addProfessional(professional);
		return "professional-added";
	}
	
	public String delete() {
		ServiceFactory.getInstance().getProfessionalService().deleteProfessional(professional);
		deleteProfessional(professional);
		return "professional-deleted";
	}
	
	public String update() {
		professional = ServiceFactory.getInstance().getProfessionalService().updateProfessional(professional);
		updateProfessional(professional);
		return "professional-updated";
	}
	
}
