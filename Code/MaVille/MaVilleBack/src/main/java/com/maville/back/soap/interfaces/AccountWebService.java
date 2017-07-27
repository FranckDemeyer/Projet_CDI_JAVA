package com.maville.back.soap.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.maville.back.dto.AccountDTO;

@WebService
public interface AccountWebService {
	@WebMethod
	void addAccount(AccountDTO account) throws Exception;
	@WebMethod
	void deleteAccount(AccountDTO account);
	@WebMethod
	AccountDTO findAccount(int accountId);
	@WebMethod
	List<AccountDTO> findAllAccount();
	@WebMethod
	AccountDTO findAccountByName(String name);
	@WebMethod
	AccountDTO updateAccount(AccountDTO account) throws Exception;
	@WebMethod
	List<AccountDTO> findAllProfessionalAccount();
	@WebMethod
	List<AccountDTO> findAllAdminAccount();
}
