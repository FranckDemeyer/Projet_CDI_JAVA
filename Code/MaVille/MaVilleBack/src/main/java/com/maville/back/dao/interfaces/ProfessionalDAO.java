package com.maville.back.dao.interfaces;

import java.util.List;

import com.maville.back.dao.generics.AbstractDAO;
import com.maville.back.entities.Professional;
import com.maville.back.entities.ProfessionalCategory;

public interface ProfessionalDAO extends AbstractDAO<Professional, Integer> {
	List<Professional> getCategoryProfessionals(ProfessionalCategory professionalCategory);
}
