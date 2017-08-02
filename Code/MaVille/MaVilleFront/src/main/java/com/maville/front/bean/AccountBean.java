package com.maville.front.bean;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.AccountDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.AccountService;

@ManagedBean(name="account")
@SessionScoped
public class AccountBean implements Serializable {
	
	/* Variables */

	private static final long serialVersionUID = 1L;
	private AccountDTO account = new AccountDTO();
	private AccountService service = ServiceFactory.getInstance().getAccountService();
	
	/* Constructors */
	
	public AccountBean() {
	}
	
	/* Getters and Setters */
	
	public AccountDTO getAccount() {
		return account;
	}
	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public AccountService getService() {
		return service;
	}

	public void setService(AccountService service) {
		this.service = service;
	}

	/* Methods */

	public AccountDTO getAccountById(int id) {
		return service.getAccountById(id);
	}
	
	public AccountDTO getAccoutnByUsername(String name) {
		return service.getAccountByUsername(name);
	}
	
	public List<AccountDTO> getAllAccount() {
		return service.getAllAccount();
	}
	
	public List<AccountDTO> getAllAdminAccount() {
		return service.getAllAdmin();
	}
	
	public List<AccountDTO> getAllProfessionalAccount() {
		return service.getAllProfessional();
	}

	public String add() throws Exception {
		if(!account.isAdmin()) return "professional";
		service.addAccount(account);
		account = new AccountDTO();
		return "account-added";
	}
	
	public String delete() {
		service.deleteAccount(account);
		return "account-deleted";
	}
	
	public String edit(AccountDTO account) {
		this.account = account;
		return "account-edit";
	}
	
	public String update() throws Exception {
		account = service.updateAccount(account);
		return "account-updated";
	}
	
}
