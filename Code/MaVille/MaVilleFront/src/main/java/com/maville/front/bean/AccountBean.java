package com.maville.front.bean;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.maville.back.dto.AccountDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.dto.ProfessionalCategoryDTO;
import com.maville.back.factories.ServiceFactory;
@ManagedBean(name="account")
@SessionScoped
public class AccountBean {
	/* private Variables */
	private AccountDTO account = new AccountDTO();
	private static Map<Integer, AccountDTO> accounts = new HashMap<>();
	
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
	public Map<Integer, AccountDTO> getAccounts() {
		return accounts;
	}
	/* private Methods */
	private static void addAccounts(AccountDTO account) {
		accounts.put(account.getAccountId(), account);
	}
	private static void deleteAccounts(Integer accountId) {
		accounts.remove(accountId);
	}
	private static void updateAccounts(AccountDTO account) {
		accounts.put(account.getAccountId(), account);
	}
	
	/* public Methods */
	public String add() throws Exception {
		ServiceFactory.getInstance().getAccountService().addAccount(account);
		addAccounts(account);
		return "add";
	}
	
	public String delete() {
		ServiceFactory.getInstance().getAccountService().deleteAccount(account);
		deleteAccounts(account.getAccountId());
		return "delete";
	}
	
	public String update() throws Exception {
		ServiceFactory.getInstance().getAccountService().updateAccount(account);
		updateAccounts(account);
		return "update";
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
