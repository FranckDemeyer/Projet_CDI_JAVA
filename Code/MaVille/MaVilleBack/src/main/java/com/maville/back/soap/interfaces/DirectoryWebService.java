package com.maville.back.soap.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maville.back.dto.AccountDTO;
import com.maville.back.entities.Directory;

@WebService
public interface DirectoryWebService {
	@WebMethod
	void addDirectory(Directory directory) throws Exception;
	@WebMethod
	void deleteDirectory(Directory directory);
	@WebMethod
	AccountDTO findDirectory(int directoryId);
	@WebMethod
	List<Directory> findAllDirectory();
	@WebMethod
	AccountDTO updateDirectory(Directory directory) throws Exception;
}
