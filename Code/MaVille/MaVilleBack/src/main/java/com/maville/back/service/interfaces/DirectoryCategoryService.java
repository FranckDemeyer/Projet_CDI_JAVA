package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.DirectoryCategoryDTO;
<<<<<<< HEAD

public interface DirectoryCategoryService {
	DirectoryCategoryDTO getDirectoryCategoryById(int id);
	List<DirectoryCategoryDTO> getAllDirectoryCategory();
	void addDirectoryCategory(DirectoryCategoryDTO directoryCategory);
	void deleteDirectoryCategory(DirectoryCategoryDTO directoryCategory);
	void updateDirectoryCategory(DirectoryCategoryDTO directoryCategory);
=======
import com.maville.back.dto.DirectoryDTO;

public interface DirectoryCategoryService {

	public DirectoryCategoryDTO getDirectoryCategoryById(int id);

	public List<DirectoryCategoryDTO> getAllDirectoryCategory();

	public List<DirectoryCategoryDTO> getDirectoryCategoryByName(String name);

	public void addDirectoryCategory(DirectoryCategoryDTO directoryCategory);

	public void deleteDirectoryCategory(DirectoryCategoryDTO directoryCategory);

	public void updateDirectoryCategory(DirectoryCategoryDTO directoryCategory);

	public List<DirectoryDTO> getDirectoriesByCategory(int idCategory);

>>>>>>> 0a64aa8b9a45cafc693b9a88a4b1a11938b58893
}
