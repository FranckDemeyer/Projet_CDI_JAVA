package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;

public interface DirectoryHourService {

	public DirectoryHourDTO getDirectoryHourById(int id);
	
	public List<DirectoryHourDTO> getAllDirectoryHours();
	
	public List<DirectoryHourDTO> getHoursByDirectory(DirectoryDTO directory);
	
	public void addDirectoryHour(DirectoryHourDTO directoryHour);
	
	public void deleteDirectoryHour(DirectoryHourDTO directoryHour);
	
	DirectoryHourDTO updateDirectoryHour(DirectoryHourDTO directoryHour);
	
}
