package com.maville.back.service.implementations;

import java.util.List;

import com.maville.back.dto.AccountDTO;
import com.maville.back.service.interfaces.AccountService;

public class AccountServiceImpl implements AccountService {
	
	@Override
	public AccountDTO getById(int id) {
		AccountDTO account = null;
		return account;
	}

	public List<AccountDTO> getAll() {
		List<AccountDTO> accounts = null;
		return accounts;
	}

	public void add(AccountDTO account) throws Exception {

	}

	public void delete(AccountDTO account) {

	}

	public void update(AccountDTO account) throws Exception {

	}
}
