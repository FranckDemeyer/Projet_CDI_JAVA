package com.maville.back.dao.implementations;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.DirectoryDAO;
import com.maville.back.entities.Directory;

public class DirectoryDAOImpl extends GenericDAO<Directory, Integer> implements DirectoryDAO {

	public DirectoryDAOImpl() {
		super(Directory.class);
	}

}
