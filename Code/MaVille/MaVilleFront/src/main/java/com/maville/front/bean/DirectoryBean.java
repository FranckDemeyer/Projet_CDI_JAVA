package com.maville.front.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.maville.back.dto.DirectoryCategoryDTO;
import com.maville.back.dto.DirectoryDTO;
import com.maville.back.dto.DirectoryHourDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.DirectoryService;

@ManagedBean(name = "directory")
@SessionScoped
public class DirectoryBean implements Serializable {

	/* Variables */

	private DirectoryDTO directory = new DirectoryDTO();
	private DirectoryService service = ServiceFactory.getInstance().getDirectoryService();

	/* Manage Category */
	@ManagedProperty(value = "#{directoryCategory}")
	private DirectoryCategoryBean categoryBean;
	private DirectoryCategoryDTO category;
	private List<DirectoryCategoryDTO> listCategories;

	/* Manage hours */
	// @ ManagedProperty(value="directoryHour")
	// private DirectoryHourBean hourBean;
	// private DirectoryHourDTO hour;
	// private List<DirectoryHourDTO> listHours;
	// private int selectedHourId;

	/* liste des pages Directory */
	private static final String listDirPage = "directory";
	private static final String createDirPage = "create-directory";
	private static final String editDirPage = "edit-directory";

	/* lists for filtering */
	private List<DirectoryDTO> allDirectories;
	private List<DirectoryDTO> filteredDirectories;

	/* file upload */
	UploadedFile file;

	@PostConstruct
	public void init() {
		listCategories = ServiceFactory.getInstance().getDirectoryCategoryService().getAllDirectoryCategory();
		// listHours =
		// ServiceFactory.getInstance().getDirectoryHourService().getAllDirectoryHours();
	}

	/* Getters and Setters */

	public DirectoryCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(DirectoryCategoryDTO category) {
		this.category = category;
	}

	public List<DirectoryCategoryDTO> getListCategories() {
		return listCategories;
	}

	public DirectoryDTO getDirectory() {
		return directory;
	}

	public void setDirectory(DirectoryDTO directory) {
		this.directory = directory;
	}

	public void setCategoryBean(DirectoryCategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}

	// public void setHourBean(DirectoryHourBean hourBean) {
	// this.hourBean = hourBean;
	// }
	//
	// public DirectoryHourDTO getHour() {
	// return hour;
	// }
	//
	// public void setHour(DirectoryHourDTO hour) {
	// this.hour = hour;
	// }
	//
	// public List<DirectoryHourDTO> getListHours() {
	// return listHours;
	// }
	//
	// public void setListHours(List<DirectoryHourDTO> listHours) {
	// this.listHours = listHours;
	// }

	/* Methods */

	public DirectoryDTO getDirectoryById(int id) {
		return service.getDirectoryById(id);
	}

	public List<DirectoryDTO> getAllDirectories() {
		if (allDirectories == null)
			allDirectories = service.getAllDirectories();
		return allDirectories;
	}

	public List<DirectoryDTO> getFilteredDirectories() {
		return filteredDirectories;
	}

	public void setFilteredDirectories(List<DirectoryDTO> filteredDirectories) {
		this.filteredDirectories = filteredDirectories;
	}

	public List<DirectoryDTO> getDirectoriesByName(String name) {
		return service.getDirectoriesByName(name);
	}

	public List<DirectoryDTO> getDirectoriesByCategory(DirectoryCategoryDTO category) {
		return service.getDirectoriesByCategory(category);
	}

	public List<DirectoryDTO> getDirectoriesByCoord(String lat, String lng, double rayon) {
		return service.getDirectoriesByCoord(lat, lng, rayon);
	}

	public List<DirectoryHourDTO> getHoursByDirectory(DirectoryDTO directory) {
		return service.getDirectoryHoursByDirectory(directory);
	}

	public String create() {
		directory = new DirectoryDTO();
		return createDirPage;
	}

	public String add() {
		if (directory.getDirectoryId() > 0) {
			return update();
		} else {
			service.addDirectory(directory);
			allDirectories = service.getAllDirectories();
			return listDirPage;
		}
	}

	public String delete(DirectoryDTO directory) {
		// TODO ajouter message de confirmation
		this.directory = directory;
		service.delecteDirectory(this.directory);
		directory = new DirectoryDTO();
		allDirectories = service.getAllDirectories();
		return listDirPage;
	}

	public String edit(DirectoryDTO directory) {
		this.directory = directory;
		return createDirPage;
	}

	public String update() {
		directory = service.updateDirectory(directory);
		allDirectories = service.getAllDirectories();
		return listDirPage;
	}

	/* file upload */
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void fileUploadListener(FileUploadEvent e) {
		// Get uploaded file from the FileUploadEvent
		this.file = e.getFile();
		try {
			InputStream inputStream = file.getInputstream();
			OutputStream out = new FileOutputStream(
					new File(System.getProperty("catalina.base"), "uploads/" + file.getFileName()));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
			inputStream.close();
		} catch (Exception ioe) {
			ioe.printStackTrace();
			throw new RuntimeException("Erreur lors du chargement du fichier : " + ioe.getMessage());
		}
		// set the file as photo for the directory
		directory.setPhoto(file.getFileName());
	}

	// keep the selected hour in memory
	// public void selectHour(DirectoryHourDTO hour){
	// this.hour = hour;
	// selectedHourId = hour.getId();
	// }
	//
	// public void saveHour(){
	// if (hour.getDay() != null && hour.getHour() != null){
	// if (selectedHourId > 0){
	// // an hour is in edition mode
	// listHours.set(selectedHourId, hour);
	// selectedHourId = 0;
	// } else {
	// listHours.add(hour);
	// }
	// hour = new DirectoryHourDTO();
	// }
	// }
	//
	// public void removeHour(){
	// // remove hour of the list
	// listHours.remove(hour.getId());
	// selectedHourId = 0;
	// }

}
