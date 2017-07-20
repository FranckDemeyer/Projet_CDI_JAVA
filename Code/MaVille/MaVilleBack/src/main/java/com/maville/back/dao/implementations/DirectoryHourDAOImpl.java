package com.maville.back.dao.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.DirectoryHourDAO;
import com.maville.back.entities.Directory;
import com.maville.back.entities.DirectoryHour;

public class DirectoryHourDAOImpl extends GenericDAO<DirectoryHour, Integer> implements DirectoryHourDAO {

	public DirectoryHourDAOImpl() {
		super(DirectoryHour.class);
	}

	@Override
	public List<DirectoryHour> getDirectoryHoursByDirectory(Directory directory) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("directory", directory.getDirectoryId());
		return super.findGroup(DirectoryHour.GET_DIRECTORYHOURS_BYDIRECTORY, parameters);
	}

}
