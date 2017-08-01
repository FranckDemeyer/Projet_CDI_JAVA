package com.maville.front.bean;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.maville.back.dto.AccountDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.AccountService;

@ManagedBean(name="account")
@SessionScoped
public class AccountBean {
	
	/* Variables */
	
	private AccountDTO account = new AccountDTO();
	private AccountDTO accountPro = new AccountDTO();
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

	public AccountDTO getAccountPro() {
		return accountPro;
	}

	public void setAccountPro(AccountDTO accountPro) {
		this.accountPro = accountPro;
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
		System.out.println(account);
		service.addAccount(account);
		accountPro = account;
		account = new AccountDTO();
		if(account.isAdmin()) return "account-added";
		return "professional";
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
