package com.maville.back.service.implementations;

import java.util.List;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.service.interfaces.DirectoryCategoryService;

public class DirectoryCategoryServiceImpl implements DirectoryCategoryService {

	@Override
	public DirectoryCategoryDTO getDirectoryCategoryById(int id) {
		DirectoryCategoryDTO directoryCategory = null;
		// TODO
		return directoryCategory;
	}

	@Override
	public List<DirectoryCategoryDTO> getAllDirectoryCategory() {
		List<DirectoryCategoryDTO> listDirectoryCategory = null;
		// TODO 
		return listDirectoryCategory;
	}

	@Override
	public List<DirectoryCategoryDTO> getDirectoryCategoryByName(String name) {
		List<DirectoryCategoryDTO> listDirectoryCategory = null;
		// TODO 
		return listDirectoryCategory;
	}

	@Override
	public void addDirectoryCategory(DirectoryCategoryDTO directoryCategory) {
		// TODO 
	}

	@Override
	public void deleteDirectoryCategory(DirectoryCategoryDTO directoryCategory) {
		// TODO 
	}

	@Override
	public DirectoryCategoryDTO updateDirectoryCategory(DirectoryCategoryDTO directoryCategory) {
		// TODO 
	}

	@Override
	public List<DirectoryDTO> getDirectoriesByCategory(int idCategory) {
		List<DirectoryDTO> listDirectory = null;
		// TODO 
		return listDirectory;
	}

}