package com.maville.back.dao.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.ProfessionalDAO;
import com.maville.back.entities.Professional;
import com.maville.back.entities.ProfessionalCategory;

public class ProfessionalDAOImpl extends GenericDAO<Professional, Integer> implements ProfessionalDAO {

	public ProfessionalDAOImpl(Class<Professional> entityClass) {
		super(Professional.class);
	}

	@Override
	public List<Professional> getCategoryProfessionals(ProfessionalCategory professionalCategory) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("professionalCategory", professionalCategory.getProfessionalCategoryId());
		return super.findGroup(Professional.GET_CATEGORY_PROFESSIONALS, parameters);
	}

}
