package com.maville.back.dao.implementations;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.ProfessionalDAO;
import com.maville.back.entities.Professional;

@Transactional
@Repository("professionalDAOI")
public class ProfessionalDAOImpl extends GenericDAO<Professional, Integer> implements ProfessionalDAO {

	public ProfessionalDAOImpl() {
		super(Professional.class);
	}

}
