package com.maville.back.dao.implementations;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.ProfessionalCategoryDAO;
import com.maville.back.entities.ProfessionalCategory;

@Transactional
@Repository("professionalCategoryDAOI")
public class ProfessionalCategoryDAOImpl extends GenericDAO<ProfessionalCategory, Integer>
		implements ProfessionalCategoryDAO {

	public ProfessionalCategoryDAOImpl() {
		super(ProfessionalCategory.class);
	}

}
