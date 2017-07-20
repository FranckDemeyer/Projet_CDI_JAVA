package com.maville.back.dao.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.DirectoryDAO;
import com.maville.back.entities.Directory;
import com.maville.back.entities.DirectoryCategory;
import com.maville.back.entities.DirectoryHour;

public class DirectoryDAOImpl extends GenericDAO<Directory, Integer> implements DirectoryDAO {

	public DirectoryDAOImpl() {
		super(Directory.class);
	}

	@Override
	public List<Directory> getDirectoryByName(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Directory> getDirectoryByCategory(DirectoryCategory category) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("category", category.getDirectoryCategoryId());
		return super.findGroup(Directory.GET_DIRECTORY_BYCATEGORY, parameters);
	}

//	@Override
//	public List<Directory> getDirectoryByCoord(String latMin, String latMax, String lngMin, String lngMax) {
//		Map<String, Object> parameters = new HashMap<>();
//		parameters.put("latMin", latMin);
//		parameters.put("latMax", latMax);
//		parameters.put("lngMin", lngMin);
//		parameters.put("lngMax", lngMax);
//		return super.findGroup(Directory.GET_DIRECTORY_BYCOORD, parameters);
//	}

	@Override
	public List<DirectoryHour> getDirectoryHoursByDirectory(Directory directory) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("directory", directory.getDirectoryId());
		return super.findOne(DirectoryHour.GET_DIRECTORYHOURS_BYDIRECTORY, parameters).getHours();
	}

}
