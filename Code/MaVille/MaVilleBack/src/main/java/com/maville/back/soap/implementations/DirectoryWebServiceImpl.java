package com.maville.back.soap.implementations;

import java.util.List;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.DirectoryService;
import com.maville.back.soap.interfaces.DirectoryWebService;

public class DirectoryWebServiceImpl implements DirectoryWebService {
	
	private DirectoryService service = ServiceFactory.getInstance().getDirectoryService();

	@Override
	public void addDirectory(DirectoryDTO directory) throws Exception {
		service.addDirectory(directory);
	}

	@Override
	public void deleteDirectory(DirectoryDTO directory) {
		service.delecteDirectory(directory);
	}

	@Override
	public DirectoryDTO findDirectoryById(int directoryId) {
		return service.getDirectoryById(directoryId);
	}

	@Override
	public List<DirectoryDTO> findAllDirectories() {
		return service.getAllDirectories();
	}

	@Override
	public List<DirectoryDTO> findDirectoriesByName(String name) {
		return service.getDirectoriesByName(name);
	}

	@Override
	public DirectoryDTO updateDirectory(DirectoryDTO directory) throws Exception {
		return service.updateDirectory(directory);
	}

	@Override
	public List<DirectoryDTO> findDirectoriesByCategory(DirectoryCategoryDTO category) {
		return service.getDirectoriesByCategory(category);
	}

	@Override
	public List<DirectoryDTO> findDirectoriesByCoord(String lat, String lng, double rayon) {
		return service.getDirectoriesByCoord(lat, lng, rayon);
	}

	@Override
	public List<DirectoryHourDTO> findDirectoryHoursByDirectory(DirectoryDTO directory) {
		return service.getDirectoryHoursByDirectory(directory);
	}

}
