package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;

public interface DirectoryService {

	public DirectoryDTO getDirectoryById(int id);

	public List<DirectoryDTO> getAllDirectories();
	
	public List<DirectoryDTO> getDirectoriesByName(String name);

	public void addDirectory(DirectoryDTO directory);

	public void delecteDirectory(DirectoryDTO directory);

	public DirectoryDTO updateDirectory(DirectoryDTO directory);

	public List<DirectoryDTO> getDirectoriesByCategory(DirectoryCategoryDTO category);

	public List<DirectoryDTO> getDirectoriesByCoord(String lat, String lng, double rayon);
	
	public List<DirectoryHourDTO> getDirectoryHoursByDirectory(DirectoryDTO directory); 

}
