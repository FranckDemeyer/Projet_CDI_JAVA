package com.maville.back.dao.implementations;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.DirectoryHourDAO;
import com.maville.back.entities.DirectoryHour;

public class DirectoryHourDAOImpl extends GenericDAO<DirectoryHour, Integer> implements DirectoryHourDAO {

	public DirectoryHourDAOImpl() {
		super(DirectoryHour.class);
	}

}
