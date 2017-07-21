package com.maville.back.soap.implementations;

import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.AccountDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.soap.interfaces.AccountWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.AccountWebService")
public class AccountWebServiceImpl implements AccountWebService {

	@Override
	public List<AccountDTO> findAccountByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(AccountDTO account) {
		ServiceFactory.getInstance().getAccountService().deleteAccount(account);
	}

	@Override
	public AccountDTO findAccount(int accountId) {
		return ServiceFactory.getInstance().getAccountService().getAccountById(accountId);
	}

	@Override
	public List<AccountDTO> findAllAccount() {
		return ServiceFactory.getInstance().getAccountService().getAllAccount();
	}

	@Override
	public AccountDTO updateAccount(AccountDTO account) throws Exception {
		return ServiceFactory.getInstance().getAccountService().updateAccount(account);
	}

	@Override
	public void addAccount(AccountDTO account) throws Exception {
		ServiceFactory.getInstance().getAccountService().addAccount(account);
	}

	@Override
	public List<AccountDTO> findAllProfessionalAccount() {
		return null;
	}

	@Override
	public List<AccountDTO> findAllAdminAccount() {
		return null;
	}

}
