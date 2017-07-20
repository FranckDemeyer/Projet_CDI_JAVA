package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.AccountDTO;

public interface AccountService {
	AccountDTO getAccountById(int id);
	List<AccountDTO> getAllAccount();
	void addAccount(AccountDTO account) throws Exception;
	void deleteAccount(AccountDTO account);
	AccountDTO updateAccount(AccountDTO account) throws Exception;
}
