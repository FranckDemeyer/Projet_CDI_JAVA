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
@Service("professionalCategoryService")
public class ProfessionalCategoryServiceImpl implements ProfessionalCategoryService {
	
	@Autowired
	private ProfessionalCategoryDAO professionalCategoryDAO;
	
	@Override
	public ProfessionalCategoryDTO getProfessionalCategoryById(int id) {
		ProfessionalCategoryDTO categoryDTO = null;
		ProfessionalCategory category = professionalCategoryDAO.find(id);
		if(category != null) {
			categoryDTO = new ProfessionalCategoryDTO();
			BeanUtils.copyProperties(category, categoryDTO);
			List<ProfessionalDTO> professionalsDTO = new ArrayList<>();
			for(Professional professional: category.getProfessionals()) {
				ProfessionalDTO professionalDTO = new ProfessionalDTO();
				BeanUtils.copyProperties(professional, professionalDTO);
				professionalsDTO.add(professionalDTO);
			}
			categoryDTO.setProfessionals(professionalsDTO);
		}
		return categoryDTO;
	}
	
	@Override
	public List<ProfessionalCategoryDTO> getAllProfessionalCategories() {
		List<ProfessionalCategoryDTO> categories = new ArrayList<>();
		for(ProfessionalCategory pc : professionalCategoryDAO.findAll()) {
			ProfessionalCategoryDTO pc2 = new ProfessionalCategoryDTO();
			BeanUtils.copyProperties(pc, pc2);
			List<ProfessionalDTO> proDTO = new ArrayList<>();
			for(Professional p: pc.getProfessionals()) {
				ProfessionalDTO pDTO = new ProfessionalDTO();
				BeanUtils.copyProperties(p, pDTO);
				proDTO.add(pDTO);
			}
			pc2.setProfessionals(proDTO);
			categories.add(pc2);
		}
		return categories;
	}
	
	@Override
	public ProfessionalCategoryDTO getProfessionalCategoryByName(String name) {
		ProfessionalCategoryDTO categoryDTO = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		ProfessionalCategory category = professionalCategoryDAO.findOne(Professional.FIND_BY_NAME, parameters);
		if(category != null) {
			categoryDTO = new ProfessionalCategoryDTO();
			BeanUtils.copyProperties(category, categoryDTO);
			List<ProfessionalDTO> professionalsDTO = new ArrayList<>();
			for(Professional professional: category.getProfessionals()) {
				ProfessionalDTO professionalDTO = new ProfessionalDTO();
				BeanUtils.copyProperties(professional, professionalDTO);
				professionalsDTO.add(professionalDTO);
			}
			categoryDTO.setProfessionals(professionalsDTO);
		}
		return categoryDTO;
	}

	@Override
	public void addProfessionalCategory(ProfessionalCategoryDTO category) {
		if(getProfessionalCategoryByName(category.getName()) != null) {throw new IllegalArgumentException("Cette Cat�gorie existe d�j�");}
		ProfessionalCategory entity = new ProfessionalCategory();
		BeanUtils.copyProperties(category, entity);
		List<Professional> professionals = new ArrayList<>();
		for(ProfessionalDTO proDTO: category.getProfessionals()) {
			Professional pro = new Professional();
			BeanUtils.copyProperties(proDTO, pro);
			professionals.add(pro);
		}
		entity.setProfessionals(professionals);
		try {
			professionalCategoryDAO.save(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de l'insertion");
		}
	}

	@Override
	public void deleteProfessionalCategory(ProfessionalCategoryDTO category) {
		if(getProfessionalCategoryById(category.getProfessionalCategoryId()) == null) {throw new IllegalArgumentException("Cette Cat�gorie n'existe pas");}
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
			throw new RuntimeException("Erreur lors de la mise � jour");
		}
		BeanUtils.copyProperties(entity, category);
		return category;
	}

	@Override
	public List<ProfessionalDTO> getProfessionalsByProfessionalCategory(ProfessionalCategoryDTO professionalCategory) {
		List<ProfessionalDTO> professionals = new ArrayList<>();
		for(Professional pro : professionalCategoryDAO.find(professionalCategory.getProfessionalCategoryId()).getProfessionals()) {
			ProfessionalDTO pro2 = new ProfessionalDTO();
			BeanUtils.copyProperties(pro, pro2);
			professionals.add(pro2);
		}
		return professionals;
	}
}
