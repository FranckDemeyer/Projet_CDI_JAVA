package com.maville.back.dao.interfaces;

import java.util.List;

import com.maville.back.dao.generics.AbstractDAO;
import com.maville.back.entities.Directory;
import com.maville.back.entities.DirectoryCategory;

public interface DirectoryCategoryDAO extends AbstractDAO<DirectoryCategory, Integer> {
	DirectoryCategory getDirectoryCategoryByName(String name);
	List<Directory> getDirectoriesByCategory(int idCategory);
}
