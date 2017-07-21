package com.maville.back.dao.implementations;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.DirectoryHourDAO;
import com.maville.back.entities.DirectoryHour;

@Transactional
@Repository("directoryHourDAO")
public class DirectoryHourDAOImpl extends GenericDAO<DirectoryHour, Integer> implements DirectoryHourDAO {

	public DirectoryHourDAOImpl() {
		super(DirectoryHour.class);
	}

}
