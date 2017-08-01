package com.maville.back.soap.implementations;

import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.soap.interfaces.DirectoryCategoryWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.DirectoryCategoryWebService")
public class DirectoryCategoryWebServiceImpl implements DirectoryCategoryWebService {
	
	@Override
	public void addDirectoryCategory(DirectoryCategoryDTO directoryCategory) throws Exception {
		ServiceFactory.getInstance().getDirectoryCategoryService().addDirectoryCategory(directoryCategory);
	}

	@Override
	public void deleteDirectoryCategory(DirectoryCategoryDTO directoryCategory) {
		ServiceFactory.getInstance().getDirectoryCategoryService().deleteDirectoryCategory(directoryCategory);
	}

	@Override
	public DirectoryCategoryDTO findDirectoryCategory(int directoryCategoryId) {
		return ServiceFactory.getInstance().getDirectoryCategoryService().getDirectoryCategoryById(directoryCategoryId);
	}

	@Override
	public List<DirectoryCategoryDTO> findAllDirectoryCategory() {
		return ServiceFactory.getInstance().getDirectoryCategoryService().getAllDirectoryCategory();
	}

	@Override
	public DirectoryCategoryDTO updateDirectoryCategory(DirectoryCategoryDTO directoryCategory) throws Exception {
		return ServiceFactory.getInstance().getDirectoryCategoryService().updateDirectoryCategory(directoryCategory);
	}

	@Override
	public DirectoryCategoryDTO findDirectoryCategoryByName(String name) {
		return ServiceFactory.getInstance().getDirectoryCategoryService().getDirectoryCategoryByName(name);
	}

	@Override
	public List<DirectoryDTO> findDirectoriesByCategory(int categoryId) {
		return ServiceFactory.getInstance().getDirectoryCategoryService().getDirectoriesByCategory(categoryId);
	}

}
