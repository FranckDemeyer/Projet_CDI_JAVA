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
	
	/* Variables */
	
	private AccountDTO account = new AccountDTO();
	private static Map<Integer, AccountDTO> accounts = new HashMap<>();
	
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
	public Map<Integer, AccountDTO> getAccounts() {
		return accounts;
	}
	
	public static void setAccounts(Map<Integer, AccountDTO> accounts) {
		AccountBean.accounts = accounts;
	}

	/* Methods */

	private static void addAccount(AccountDTO account) {
		accounts.put(account.getAccountId(), account);
	}
	private static void deleteAccount(Integer accountId) {
		accounts.remove(accountId);
	}
	private static void updateAccount(AccountDTO account) {
		accounts.put(account.getAccountId(), account);
	}

	public String add() throws Exception {
		ServiceFactory.getInstance().getAccountService().addAccount(account);
		addAccount(account);
		return "add";
	}
	
	public String delete() {
		ServiceFactory.getInstance().getAccountService().deleteAccount(account);
		deleteAccount(account.getAccountId());
		return "delete";
	}
	
	public String update() throws Exception {
		account = ServiceFactory.getInstance().getAccountService().updateAccount(account);
		updateAccount(account);
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
