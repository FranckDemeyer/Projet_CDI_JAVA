package com.maville.back.service.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maville.back.dao.interfaces.DirectoryCategoryDAO;
import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.entities.DirectoryCategory;
import com.maville.back.service.interfaces.DirectoryCategoryService;

@Service("directoryCategoryService")
@Transactional
public class DirectoryCategoryServiceImpl implements DirectoryCategoryService {

	@Autowired
	DirectoryCategoryDAO directoryCategoryDao;

	@Override
	public DirectoryCategoryDTO getDirectoryCategoryById(int id) {
		DirectoryCategoryDTO directoryCategory = new DirectoryCategoryDTO();
		BeanUtils.copyProperties(directoryCategoryDao.find(id), directoryCategory);
		return directoryCategory;
	}

	@Override
	public List<DirectoryCategoryDTO> getAllDirectoryCategory() {
		List<DirectoryCategoryDTO> listDirectoryCategory = null;
		BeanUtils.copyProperties(directoryCategoryDao.findAll(), listDirectoryCategory);
		return listDirectoryCategory;
	}

	@Override
	public DirectoryCategoryDTO getDirectoryCategoryByName(String name) {
		DirectoryCategoryDTO directoryCategory = new DirectoryCategoryDTO();
		// TODO implement the query
		// BeanUtils.copyProperties(directoryCategoryDao.findOne(DirectoryCategory.,
		// parameters), directoryCategory);
		return directoryCategory;
	}

	@Override
	public void addDirectoryCategory(DirectoryCategoryDTO directoryCategory) {
		if (getDirectoryCategoryByName(directoryCategory.getName()) != null) {
			throw new RuntimeException("Cette catégorie existe déjà.");
		}
		DirectoryCategory entity = new DirectoryCategory();
		BeanUtils.copyProperties(directoryCategory, entity);
		try {
			directoryCategoryDao.save(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de l'enregistrement de la catégorie.");
		}
	}

	@Override
	public void deleteDirectoryCategory(DirectoryCategoryDTO directoryCategory) {
		if (getDirectoryCategoryByName(directoryCategory.getName()) == null) {
			throw new RuntimeException("Cette catégorie n'existe pas.");
		}
		DirectoryCategory entity = new DirectoryCategory();
		BeanUtils.copyProperties(directoryCategory, entity);
		try {
			directoryCategoryDao.delete(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la suppression de la catégorie.");
		}
	}

	@Override
	public DirectoryCategoryDTO updateDirectoryCategory(DirectoryCategoryDTO directoryCategory) {
		DirectoryCategory entity = new DirectoryCategory();
		BeanUtils.copyProperties(directoryCategory, entity);
		try {
			directoryCategoryDao.update(entity);
		} catch (Exception e) {
			throw new RuntimeException("Erreur lors de la mise à jour de la catégorie.");
		}
		BeanUtils.copyProperties(entity, directoryCategory);
		return directoryCategory;
	}

	@Override
	public List<DirectoryDTO> getDirectoriesByCategory(int idCategory) {
		List<DirectoryDTO> listDirectory = null;
		// TODO implement method from DAO
		// BeanUtils.copyProperties(directoryCategoryDao., listDirectory);
		return listDirectory;
	}

}
