package com.maville.back.soap.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maville.back.entities.DirectoryCategory;

@WebService
public interface DirectoryCategoryWebService {
	@WebMethod
	void addDirectoryCategory(DirectoryCategory directoryCategory) throws Exception;
	@WebMethod
	void deleteDirectoryCategory(DirectoryCategory directoryCategory);
	@WebMethod
	DirectoryCategory findDirectoryCategory(int directoryCategoryId);
	@WebMethod
	List<DirectoryCategory> findAllDirectoryCategory();
	@WebMethod
	DirectoryCategory updateDirectoryCategory(DirectoryCategory directoryCategory) throws Exception;
}
