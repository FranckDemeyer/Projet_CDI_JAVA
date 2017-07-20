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
		// TODO Auto-generated method stub
		return account;
	}
<<<<<<< HEAD
	
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
=======

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
>>>>>>> 0a64aa8b9a45cafc693b9a88a4b1a11938b58893

	@Override
	public void addAccount(AccountDTO account) throws Exception {
		// TODO 
	}

	@Override
<<<<<<< HEAD
	public AccountDTO updateAccount(AccountDTO account) throws Exception {
		return account;
=======
	public void deleteAccount(AccountDTO account) {
		// TODO 
	}

	@Override
	public void updateAccount(AccountDTO account) throws Exception {
		// TODO 
>>>>>>> 0a64aa8b9a45cafc693b9a88a4b1a11938b58893
	}
}
