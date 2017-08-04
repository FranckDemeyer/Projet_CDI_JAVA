package com.maville.front.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.ProfessionalService;

@ManagedBean(name="professional")
@SessionScoped
public class ProfessionalBean implements Serializable {

	/* Variables */
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{account}")
	private AccountBean accountBean;
	
	private ProfessionalDTO professional = new ProfessionalDTO();
	private ProfessionalService service = ServiceFactory.getInstance().getProfessionalService();
	private List<ProfessionalCategoryDTO> category = ServiceFactory.getInstance().getProfessionalCategoryService().getAllProfessionalCategories();
	
	/* Getters and Setters */
	
	public void setAccountBean(AccountBean accountBean) {
		this.accountBean = accountBean;
	}
	
	public ProfessionalDTO getProfessional() {
		return professional;
	}
	
	public void setProfessional(ProfessionalDTO professional) {
		this.professional = professional;
	}
	
	public List<ProfessionalCategoryDTO> getCategory() {
		return category;
	}

	public void setCategory(List<ProfessionalCategoryDTO> category) {
		this.category = category;
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
		accountBean.getAccount().setProfessional(professional);
		try {
			accountBean.setAccount(accountBean.getService().addAccount(accountBean.getAccount()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		professional.setAccount(accountBean.getAccount());
		service.addProfessional(professional);
		return "account-added";
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
