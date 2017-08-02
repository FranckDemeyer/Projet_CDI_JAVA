package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.AccountDTO;

public interface AccountService {
	AccountDTO getAccountById(int id);
	AccountDTO getAccountByUsername(String username);
	List<AccountDTO> getAllAccount();
	List<AccountDTO> getAllProfessional();
	List<AccountDTO> getAllAdmin();
	AccountDTO addAccount(AccountDTO account) throws Exception;
	void deleteAccount(AccountDTO account);
	AccountDTO updateAccount(AccountDTO account) throws Exception;
}
