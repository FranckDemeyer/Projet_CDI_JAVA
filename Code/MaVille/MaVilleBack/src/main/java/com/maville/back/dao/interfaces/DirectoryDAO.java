package com.maville.back.dao.interfaces;

import java.util.List;

import com.maville.back.dao.generics.AbstractDAO;
import com.maville.back.entities.Directory;
import com.maville.back.entities.DirectoryHour;

public interface DirectoryDAO extends AbstractDAO<Directory, Integer> {
	List<DirectoryHour> getDirectoryHoursByDirectory(Directory directory);
}
