package com.maville.back.dao.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.DirectoryCategoryDAO;
import com.maville.back.entities.Directory;
import com.maville.back.entities.DirectoryCategory;

@Transactional
@Repository("directoryCategoryDAOI")
public class DirectoryCategoryDAOImpl extends GenericDAO<DirectoryCategory, Integer> implements DirectoryCategoryDAO {

	public DirectoryCategoryDAOImpl() {
		super(DirectoryCategory.class);
	}

	@Override
	public List<Directory> getDirectoriesByCategory(int idCategory) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("categories", idCategory);
		return super.findOne(DirectoryCategory.GET_DIRECTORIES_BYCATEGORY, parameters).getDirectories();
	}

}
