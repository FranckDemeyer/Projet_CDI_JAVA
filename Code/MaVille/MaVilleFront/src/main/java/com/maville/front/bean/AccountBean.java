package com.maville.front.bean;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.maville.back.dto.AccountDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.AccountService;

@ManagedBean(name="account")
@SessionScoped
public class AccountBean {
	
	/* Variables */
	
	private AccountDTO account = new AccountDTO();
	private AccountService service = ServiceFactory.getInstance().getAccountService();
	
	/* Constructors */
	
	public AccountBean() {
		account.setProfessional(new ProfessionalDTO());
		account.getProfessional().setCategory(new ProfessionalCategoryDTO());
	}
	
	/* Getters and Setters */
	
	public AccountDTO getAccount() {
		return account;
	}
	public void setAccount(AccountDTO account) {
		this.account = account;
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
	
	public boolean isAdmin() {
		return account.isAdmin();
	}
	
	public void setAdmin(boolean admin) {
		account.setAdmin(admin);
	}
	
	public void setHasAdmin(ValueChangeEvent e) {
		account.setAdmin(Boolean.parseBoolean(e.getNewValue().toString()));
	}
}
