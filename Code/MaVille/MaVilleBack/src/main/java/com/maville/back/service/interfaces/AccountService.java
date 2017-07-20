package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.AccountDTO;

public interface AccountService {
	AccountDTO getAccountById(int id);
	List<AccountDTO> getAllAccount();
<<<<<<< HEAD
	void addAccount(AccountDTO account) throws Exception;
	void deleteAccount(AccountDTO account);
	AccountDTO updateAccount(AccountDTO account) throws Exception;
=======
	List<AccountDTO> getAllProfessional();
	List<AccountDTO> getAllAdmin();
	void addAccount(AccountDTO account) throws Exception;
	void deleteAccount(AccountDTO account);
	void updateAccount(AccountDTO account) throws Exception;
>>>>>>> 0a64aa8b9a45cafc693b9a88a4b1a11938b58893
}
