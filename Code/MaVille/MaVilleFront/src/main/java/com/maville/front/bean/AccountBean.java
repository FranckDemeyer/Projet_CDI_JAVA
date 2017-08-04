package com.maville.front.bean;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.maville.back.dto.AccountDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.AccountService;

@ManagedBean(name="account")
@ViewScoped
public class AccountBean implements Serializable {
	
	/* Variables */

	private static final long serialVersionUID = 1L;
	private AccountDTO account = new AccountDTO();
	private AccountService service = ServiceFactory.getInstance().getAccountService();
	private List<AccountDTO> accounts;
	private List<AccountDTO> allAccountSort;
	private List<AccountDTO> allAdminAccountSort;
	private List<AccountDTO> allProfessionalAccountSort;
	private String radioButton = "Tous";
	
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

	public List<AccountDTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDTO> accounts) {
		this.accounts = accounts;
	}

	public List<AccountDTO> getAllAccountSort() {
		return allAccountSort;
	}

	public void setAllAccountSort(List<AccountDTO> allAccountSort) {
		this.allAccountSort = allAccountSort;
	}

	public List<AccountDTO> getAllAdminAccountSort() {
		return allAdminAccountSort;
	}

	public void setAllAdminAccountSort(List<AccountDTO> allAdminAccountSort) {
		this.allAdminAccountSort = allAdminAccountSort;
	}

	public List<AccountDTO> getAllProfessionalAccountSort() {
		return allProfessionalAccountSort;
	}

	public void setAllProfessionalAccountSort(List<AccountDTO> allProfessionalAccountSort) {
		this.allProfessionalAccountSort = allProfessionalAccountSort;
	}

	public String getRadioButton() {
		return radioButton;
	}

	public void setRadioButton(String radioButton) {
		this.radioButton = radioButton;
	}
	
	/* Methods */
	
	public String getUpdateView() {
		System.out.println("ok > " + radioButton);
		switch(radioButton) {
			case "Tous":
				accounts = getAllAccount();
				break;
			case "Administrateurs":
				accounts = getAllAdminAccount();
				break;
			case "Professionnels":
				accounts = getAllProfessionalAccount();
				break;
		}
		return null;
	}

	public AccountDTO getAccountById(int id) {
		return service.getAccountById(id);
	}
	
	public AccountDTO getAccoutnByUsername(String name) {
		return service.getAccountByUsername(name);
	}
	
	public List<AccountDTO> getAllAccount() {
		if(allAccountSort == null) allAccountSort = service.getAllAccount();
		return allAccountSort;
	}
	
	public List<AccountDTO> getAllAdminAccount() {
		if(allAdminAccountSort == null) allAdminAccountSort = service.getAllAdmin();
		return allAdminAccountSort;
	}
	
	public List<AccountDTO> getAllProfessionalAccount() {
		if(allProfessionalAccountSort == null) allProfessionalAccountSort = service.getAllProfessional();
		return allProfessionalAccountSort;
	}

	public String add() throws Exception {
		
		if(!account.isAdmin()) return "professional-add";
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
