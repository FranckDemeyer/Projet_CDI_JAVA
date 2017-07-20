package com.maville.back.service.implementations;

import java.util.List;

import com.maville.back.dto.AccountDTO;
import com.maville.back.service.interfaces.AccountService;

public class AccountServiceImpl implements AccountService {
	
	@Override
	public AccountDTO getAccountById(int id) {
		AccountDTO account = null;
		// TODO Auto-generated method stub
		return account;
	}

	@Override
	public List<AccountDTO> getAllAccount() {
		List<AccountDTO> listAccounts = null;
		// TODO Auto-generated method stub
		return listAccounts;
	}

	@Override
	public List<AccountDTO> getAllProfessional() {
		List<AccountDTO> listAccounts = null;
		// TODO Auto-generated method stub
		return listAccounts;
	}

	@Override
	public List<AccountDTO> getAllAdmin() {
		List<AccountDTO> listAccounts = null;
		// TODO Auto-generated method stub
		return listAccounts;
	}

	@Override
	public void addAccount(AccountDTO account) throws Exception {
		// TODO 
	}

	@Override
	public void deleteAccount(AccountDTO account) {
		// TODO 
	}

	@Override
	public void updateAccount(AccountDTO account) throws Exception {
		// TODO 
	}
}
