package com.maville.back.soap.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;

@WebService
public interface DirectoryWebService {
	@WebMethod
	void addDirectory(DirectoryDTO directory) throws Exception;
	@WebMethod
	void deleteDirectory(DirectoryDTO directory);
	@WebMethod
	DirectoryDTO findDirectoryById(int directoryId);
	@WebMethod
	List<DirectoryDTO> findAllDirectories();
	@WebMethod
	List<DirectoryDTO> findDirectoriesByName(String name);
	@WebMethod
	DirectoryDTO updateDirectory(DirectoryDTO directory) throws Exception;
	@WebMethod
	public List<DirectoryDTO> findDirectoriesByCategory(DirectoryCategoryDTO category);
	@WebMethod
	public List<DirectoryDTO> findDirectoriesByCoord(String lat, String lng, double rayon);
	@WebMethod
	public List<DirectoryHourDTO> findDirectoryHoursByDirectory(DirectoryDTO directory); 
}
