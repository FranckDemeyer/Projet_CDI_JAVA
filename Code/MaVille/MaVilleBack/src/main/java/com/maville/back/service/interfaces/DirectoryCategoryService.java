package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.DirectoryCategoryDTO;

public interface DirectoryCategoryService {
	DirectoryCategoryDTO getDirectoryCategoryById(int id);
	List<DirectoryCategoryDTO> getAllDirectoryCategory();
	void addDirectoryCategory(DirectoryCategoryDTO directoryCategory);
	void deleteDirectoryCategory(DirectoryCategoryDTO directoryCategory);
	void updateDirectoryCategory(DirectoryCategoryDTO directoryCategory);
}
