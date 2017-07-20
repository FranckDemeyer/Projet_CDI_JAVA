package com.maville.back.dao.implementations;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.ProfessionalDAO;
import com.maville.back.entities.Professional;

public class ProfessionalDAOImpl extends GenericDAO<Professional, Integer> implements ProfessionalDAO {

	public ProfessionalDAOImpl(Class<Professional> entityClass) {
		super(Professional.class);
	}

}
