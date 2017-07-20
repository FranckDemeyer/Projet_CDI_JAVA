package com.maville.back.dao.interfaces;

import java.util.List;

import com.maville.back.dao.generics.AbstractDAO;
import com.maville.back.entities.Directory;
import com.maville.back.entities.DirectoryHour;

public interface DirectoryHourDAO extends AbstractDAO<DirectoryHour, Integer> {
	List<DirectoryHour> getDirectoryHoursByDirectory(Directory directory);
}
