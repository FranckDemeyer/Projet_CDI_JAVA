package com.maville.back.dao.interfaces;

import java.util.List;

import com.maville.back.dao.generics.AbstractDAO;
import com.maville.back.entities.Directory;
import com.maville.back.entities.DirectoryCategory;
import com.maville.back.entities.DirectoryHour;

public interface DirectoryDAO extends AbstractDAO<Directory, Integer> {
	List<Directory> getDirectoryByName(String Name);
	List<Directory> getDirectoryByCategory(DirectoryCategory category);
//	List<Directory> getDirectoryByCoord(String latMin, String latMax, String lngMin, String lngMax);
	List<DirectoryHour> getDirectoryHoursByDirectory(Directory directory);
}
