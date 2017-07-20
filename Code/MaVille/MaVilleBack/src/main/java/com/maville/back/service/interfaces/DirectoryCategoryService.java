package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;

public interface DirectoryCategoryService {

	public DirectoryCategoryDTO getDirectoryCategoryById(int id);

	public List<DirectoryCategoryDTO> getAllDirectoryCategory();

	public List<DirectoryCategoryDTO> getDirectoryCategoryByName(String name);

	public void addDirectoryCategory(DirectoryCategoryDTO directoryCategory);

	public void deleteDirectoryCategory(DirectoryCategoryDTO directoryCategory);

	DirectoryCategoryDTO updateDirectoryCategory(DirectoryCategoryDTO directoryCategory);

	public List<DirectoryDTO> getDirectoriesByCategory(int idCategory);

}
