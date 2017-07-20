package com.maville.back.dao.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.DirectoryCategoryDAO;
import com.maville.back.entities.Directory;
import com.maville.back.entities.DirectoryCategory;

public class DirectoryCategoryDAOImpl extends GenericDAO<DirectoryCategory, Integer> implements DirectoryCategoryDAO {

	public DirectoryCategoryDAOImpl() {
		super(DirectoryCategory.class);
	}

	@Override
	public DirectoryCategory getDirectoryCategoryByName(String name) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		return super.findOne(DirectoryCategory.GET_CATEGORY_BYNAME, parameters);
	}

	@Override
	public List<Directory> getDirectoriesByCategory(int idCategory) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("categories", idCategory);
		return super.findOne(DirectoryCategory.GET_DIRECTORIES_BYCATEGORY, parameters).getDirectories();
	}

}
