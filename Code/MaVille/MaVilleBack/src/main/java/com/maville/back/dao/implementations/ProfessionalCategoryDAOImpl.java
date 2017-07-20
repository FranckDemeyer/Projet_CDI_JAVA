package com.maville.back.dao.implementations;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.ProfessionalCategoryDAO;
import com.maville.back.entities.ProfessionalCategory;

public class ProfessionalCategoryDAOImpl extends GenericDAO<ProfessionalCategory, Integer>
		implements ProfessionalCategoryDAO {

	public ProfessionalCategoryDAOImpl() {
		super(ProfessionalCategory.class);
	}

}
