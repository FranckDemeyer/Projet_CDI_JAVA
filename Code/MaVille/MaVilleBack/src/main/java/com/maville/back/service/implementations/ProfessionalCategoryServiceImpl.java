package com.maville.back.service.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maville.back.dao.interfaces.ProfessionalCategoryDAO;
import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.entities.Professional;
import com.maville.back.entities.ProfessionalCategory;
import com.maville.back.service.interfaces.ProfessionalCategoryService;

@Transactional
@Service("professionalCategoryDAO")
public class ProfessionalCategoryServiceImpl implements ProfessionalCategoryService {
	
	@Autowired
	private ProfessionalCategoryDAO professionalCategoryDAO;
	
	@Override
	public ProfessionalCategoryDTO getProfessionalCategoryById(int id) {
		ProfessionalCategoryDTO category = new ProfessionalCategoryDTO();
		BeanUtils.copyProperties(professionalCategoryDAO.find(id), category);
		return category;
	}
	
	@Override
	public List<ProfessionalCategoryDTO> getAllProfessionalCategory() {
		List<ProfessionalCategoryDTO> categories = new ArrayList<>();
		for(ProfessionalCategory pc : professionalCategoryDAO.findAll()) {
			ProfessionalCategoryDTO pc2 = new ProfessionalCategoryDTO();
			BeanUtils.copyProperties(pc, pc2);
			categories.add(pc2);
		}
		return categories;
	}
	
	@Override
	public List<ProfessionalCategoryDTO> getProfessionalCategoryByName(String name) {
		List<ProfessionalCategoryDTO> categories = new ArrayList<>();
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		for(ProfessionalCategory pc : professionalCategoryDAO.findGroup(ProfessionalCategory.FIND_BY_NAME, parameters)) {
			ProfessionalCategoryDTO pc2 = new ProfessionalCategoryDTO();
			BeanUtils.copyProperties(pc, pc2);
			categories.add(pc2);
		}
		return categories;
	}

	@Override
	public void addProfessionalCategory(ProfessionalCategoryDTO category) {
		if(getProfessionalCategoryByName(category.getName()) != null) {throw new IllegalArgumentException("Cette Catégorie existe déjà");}
		ProfessionalCategory entity = new ProfessionalCategory();
		BeanUtils.copyProperties(category, entity);
		try {
			professionalCategoryDAO.save(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de l'insertion");
		}
	}

	@Override
	public void deleteProfessionalCategory(ProfessionalCategoryDTO category) {
		if(getProfessionalCategoryById(category.getProfessionalCategoryId()) == null) {throw new IllegalArgumentException("Cette Catégorie n'existe pas");}
		ProfessionalCategory entity = new ProfessionalCategory();
		BeanUtils.copyProperties(category, entity);
		try {
			professionalCategoryDAO.delete(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la suppression");
		}
	}
	
	@Override
	public ProfessionalCategoryDTO updateProfessionalCategory(ProfessionalCategoryDTO category) {
		ProfessionalCategory entity = new ProfessionalCategory();
		BeanUtils.copyProperties(category, entity);
		try {
			entity = professionalCategoryDAO.update(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la mise à jour");
		}
		BeanUtils.copyProperties(entity, category);
		return category;
	}

	@Override
	public List<ProfessionalDTO> getCategoryProfessionals(ProfessionalCategoryDTO professionalCategory) {
		List<ProfessionalDTO> professionals = new ArrayList<>();
		for(Professional pro : professionalCategoryDAO.find(professionalCategory.getProfessionalCategoryId()).getProfessionals()) {
			ProfessionalDTO pro2 = new ProfessionalDTO();
			BeanUtils.copyProperties(pro, pro2);
			professionals.add(pro2);
		}
		return professionals;
	}
}
