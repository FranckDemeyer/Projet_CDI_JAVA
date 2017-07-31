package com.maville.back.soap.implementations;

import java.util.List;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.DirectoryCategoryService;
import com.maville.back.soap.interfaces.DirectoryCategoryWebService;

public class DirectoryCategoryWebServiceImpl implements DirectoryCategoryWebService {
	
	private DirectoryCategoryService service = ServiceFactory.getInstance().getDirectoryCategoryService();

	@Override
	public void addDirectoryCategory(DirectoryCategoryDTO directoryCategory) throws Exception {
		service.addDirectoryCategory(directoryCategory);
	}

	@Override
	public void deleteDirectoryCategory(DirectoryCategoryDTO directoryCategory) {
		service.deleteDirectoryCategory(directoryCategory);
	}

	@Override
	public DirectoryCategoryDTO findDirectoryCategory(int directoryCategoryId) {
		return service.getDirectoryCategoryById(directoryCategoryId);
	}

	@Override
	public List<DirectoryCategoryDTO> findAllDirectoryCategory() {
		return service.getAllDirectoryCategory();
	}

	@Override
	public DirectoryCategoryDTO updateDirectoryCategory(DirectoryCategoryDTO directoryCategory) throws Exception {
		return service.updateDirectoryCategory(directoryCategory);
	}

	@Override
	public DirectoryCategoryDTO findDirectoryCategoryByName(String name) {
		return service.getDirectoryCategoryByName(name);
	}

	@Override
	public List<DirectoryDTO> findDirectoriesByCategory(int categoryId) {
		return service.getDirectoriesByCategory(categoryId);
	}

}
