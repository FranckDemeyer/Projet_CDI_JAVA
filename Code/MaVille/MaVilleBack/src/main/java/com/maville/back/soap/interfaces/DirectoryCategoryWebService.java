package com.maville.back.soap.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;

@WebService
public interface DirectoryCategoryWebService {
	@WebMethod
	void addDirectoryCategory(DirectoryCategoryDTO directoryCategory) throws Exception;
	@WebMethod
	void deleteDirectoryCategory(DirectoryCategoryDTO directoryCategory);
	@WebMethod
	DirectoryCategoryDTO findDirectoryCategory(int directoryCategoryId);
	@WebMethod
	List<DirectoryCategoryDTO> findAllDirectoryCategory();
	@WebMethod
	DirectoryCategoryDTO findDirectoryCategoryByName(String name);
	@WebMethod
	DirectoryCategoryDTO updateDirectoryCategory(DirectoryCategoryDTO directoryCategory) throws Exception;
	@WebMethod
	List<DirectoryDTO> findDirectoriesByCategory(int categoryId);
}
