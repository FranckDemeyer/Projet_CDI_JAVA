package com.maville.back.dao.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.DirectoryDAO;
import com.maville.back.entities.Directory;
import com.maville.back.entities.DirectoryHour;

@Transactional
@Repository("directoryDAOI")
public class DirectoryDAOImpl extends GenericDAO<Directory, Integer> implements DirectoryDAO {

	public DirectoryDAOImpl() {
		super(Directory.class);
	}

	@Override
	public List<DirectoryHour> getDirectoryHoursByDirectory(Directory directory) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("directory", directory.getDirectoryId());
		return super.findOne(DirectoryHour.GET_DIRECTORYHOURS_BYDIRECTORY, parameters).getHours();
	}

}
