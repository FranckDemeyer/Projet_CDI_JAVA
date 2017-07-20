package com.maville.back.dao.implementations;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.DirectoryCategoryDAO;
import com.maville.back.entities.DirectoryCategory;

public class DirectoryCategoryDAOImpl extends GenericDAO<DirectoryCategory, Integer> implements DirectoryCategoryDAO {

	public DirectoryCategoryDAOImpl() {
		super(DirectoryCategory.class);
	}

}
