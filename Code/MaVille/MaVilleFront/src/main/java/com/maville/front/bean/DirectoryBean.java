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

@ManagedBean(name="directory")
@SessionScoped
public class DirectoryBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/* Variables */
	
	private DirectoryDTO directory = new DirectoryDTO();
	private DirectoryService service = ServiceFactory.getInstance().getDirectoryService();
	
	/* Manage Category */
	@ManagedProperty(value="#{directoryCategory}")
	private DirectoryCategoryBean categoryBean;
	private DirectoryCategoryDTO category;
	private List<DirectoryCategoryDTO> listCategories;
	
	/* liste des pages Directory*/
	private static final String listDirPage = "directory";
	private static final String createDirPage = "create-directory";
	private static final String editDirPage = "edit-directory";
	
	/* lists for filtering */
	private List<DirectoryDTO> allDirectories;
	private List<DirectoryDTO> filteredDirectories;
	
	/* file upload */
	UploadedFile file;
	
	@PostConstruct
	public void init(){
		listCategories = ServiceFactory.getInstance().getDirectoryCategoryService().getAllDirectoryCategory();
		System.out.println(listCategories);
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
	
	/* Methods */
	
	public DirectoryDTO getDirectoryById(int id) {
		return service.getDirectoryById(id);
	}
	
	public List<DirectoryDTO> getAllDirectories() {
		allDirectories = service.getAllDirectories();
		return allDirectories;
	}
	
	public List<DirectoryDTO> getFilteredDirectories(){
		return filteredDirectories;
	}
	
	public void setFilteredDirectories(List<DirectoryDTO> filteredDirectories){
		this.filteredDirectories = filteredDirectories;
	}
	
	public List<DirectoryDTO> getDirectoriesByName(String name) {
		return service.getDirectoriesByName(name);
	}
	
	public List<DirectoryDTO> getDirectoriesByCategory (DirectoryCategoryDTO category) {
		return service.getDirectoriesByCategory(category);
	}
	
	public List<DirectoryDTO> getDirectoriesByCoord(String lat, String lng, double rayon) {
		return service.getDirectoriesByCoord(lat, lng, rayon);
	}
	
	public List<DirectoryHourDTO> getHoursByDirectory(DirectoryDTO directory) {
		return service.getDirectoryHoursByDirectory(directory);
	}
	
	public String create(){
		directory = new DirectoryDTO();
		return createDirPage;
	}
	public String add() {
		service.addDirectory(directory);
		return listDirPage;
	}
	
	public String delete(DirectoryDTO directory) {
		this.directory = directory;
		service.delecteDirectory(this.directory);
		return listDirPage;
	}
	
	public String edit(DirectoryDTO directory) {
		this.directory = directory;
		return editDirPage;
	}
	
	public String update() {
		directory = service.updateDirectory(directory);
		return listDirPage;
	}
	
	/* file upload */
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void fileUploadListener(FileUploadEvent e){
		// Get uploaded file from the FileUploadEvent
		this.file = e.getFile();
		try{
			InputStream inputStream = file.getInputstream();
			OutputStream out = new FileOutputStream(new File(System.getProperty("catalina.base"), "uploads/" + file.getFileName()));
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = inputStream.read(bytes)) != -1){
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
			inputStream.close();
		} catch(Exception ioe) {
			ioe.printStackTrace();
			throw new RuntimeException("Erreur lors du chargement du fichier : " + ioe.getMessage());
		}
		// set the file as photo for the directory
		directory.setPhoto(file.getFileName());
	}
	
}
