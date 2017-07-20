package com.maville.back.service.implementations;

import java.util.List;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.service.interfaces.DirectoryService;

public class DirectoryServiceImpl implements DirectoryService {

	@Override
	public DirectoryDTO getDirectoryById(int id) {
		DirectoryDTO directory = null;
		// TODO
		return directory;
	}

	@Override
	public List<DirectoryDTO> getAllDirectory() {
		List<DirectoryDTO> listDirectory = null;
		// TODO
		return listDirectory;
	}

	@Override
	public List<DirectoryDTO> getDirectoryByName(String name) {
		List<DirectoryDTO> listDirectory = null;
		// TODO
		return listDirectory;
	}

	@Override
	public void addDirectory(DirectoryDTO directory) {
		// TODO 
	}

	@Override
	public void delecteDirectory(DirectoryDTO directory) {
		// TODO 
	}

	@Override
	public void updateDirectory(DirectoryDTO directory) {
		// TODO 

	}

	@Override
	public List<DirectoryDTO> getDirectoryByCategory(DirectoryCategoryDTO category) {
		List<DirectoryDTO> listDirectory = null;
		// TODO 
		return listDirectory;
	}

	@Override
	public List<DirectoryDTO> getDirectoryByCoord(String lat, String lng, double rayon) {
		List<DirectoryDTO> listDirectory = null;
		// TODO 
		return listDirectory;
	}

	@Override
	public List<DirectoryHourDTO> getDirectoryHours(DirectoryDTO directory) {
		List<DirectoryHourDTO> directoryHours = null;
		// TODO
		return directoryHours;
	}

}
