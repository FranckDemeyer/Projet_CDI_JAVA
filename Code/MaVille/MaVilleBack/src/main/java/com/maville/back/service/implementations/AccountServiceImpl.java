package com.maville.back.service.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.maville.back.dto.AccountDTO;
import com.maville.back.service.interfaces.AccountService;

@Transactional
@Component("accountService")
public class AccountServiceImpl implements AccountService {
	
	
	@Override
	public AccountDTO getAccountById(int id) {
		AccountDTO account = null;
		return account;
	}
	
	@Override
	public List<AccountDTO> getAllAccount() {
		List<AccountDTO> accounts = null;
		return accounts;
	}

	@Override
	public void addAccount(AccountDTO account) throws Exception {

	}

	@Override
	public void deleteAccount(AccountDTO account) {

	}

	@Override
	public void updateAccount(AccountDTO account) throws Exception {

	}
}
