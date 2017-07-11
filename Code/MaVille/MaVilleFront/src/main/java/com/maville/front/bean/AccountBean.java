package com.maville.front.bean;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.maville.back.entities.Account;
import com.maville.back.entities.Professional;
import com.maville.back.entities.ProfessionalCategory;
import com.maville.back.factories.ServiceFactory;
@ManagedBean(name="account")
@SessionScoped
public class AccountBean {
	/* private Variables */
	private Account account = new Account();
	private static Map<Integer, Account> accounts = new HashMap<>();
	
	public AccountBean() {
		account.setProfessional(new Professional());
		account.getProfessional().setCategory(new ProfessionalCategory());
	}
	
	/* Getters and Setters */
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Map<Integer, Account> getAccounts() {
		return accounts;
	}
	/* private Methods */
	private static void addAccounts(Account account) {
		accounts.put(account.getAccountId(), account);
	}
	private static void deleteAccounts(Integer accountId) {
		accounts.remove(accountId);
	}
	private static void updateAccounts(Account account) {
		accounts.put(account.getAccountId(), account);
	}
	
	/* public Methods */
	public String add() throws Exception {
		ServiceFactory.getInstance().getAccountService().add(account);
		addAccounts(account);
		return "add";
	}
	
	public String delete() {
		ServiceFactory.getInstance().getAccountService().delete(account);
		deleteAccounts(account.getAccountId());
		return "delete";
	}
	
	public String update() throws Exception {
		ServiceFactory.getInstance().getAccountService().update(account);
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
