package com.maville.back.soap.implementations;

import java.util.List;

import javax.jws.WebService;

import com.maville.back.dto.AccountDTO;
import com.maville.back.factories.ServiceFactory;
import com.maville.back.service.interfaces.AccountService;
import com.maville.back.soap.interfaces.AccountWebService;

@WebService(endpointInterface="com.maville.back.soap.interfaces.AccountWebService")
public class AccountWebServiceImpl implements AccountWebService {
	
	private AccountService service = ServiceFactory.getInstance().getAccountService();

	@Override
	public AccountDTO findAccountByName(String name) {
		return service.getAccountByUsername(name);
	}

	@Override
	public void deleteAccount(AccountDTO account) {
		service.deleteAccount(account);
	}

	@Override
	public AccountDTO findAccount(int accountId) {
		return service.getAccountById(accountId);
	}

	@Override
	public List<AccountDTO> findAllAccount() {
		return service.getAllAccount();
	}

	@Override
	public AccountDTO updateAccount(AccountDTO account) throws Exception {
		return service.updateAccount(account);
	}

	@Override
	public void addAccount(AccountDTO account) throws Exception {
		service.addAccount(account);
	}

	@Override
	public List<AccountDTO> findAllProfessionalAccount() {
		return service.getAllProfessional();
	}

	@Override
	public List<AccountDTO> findAllAdminAccount() {
		return service.getAllAdmin();
	}

}
