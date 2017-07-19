package com.maville.back.service.interfaces;

import java.util.List;

import com.maville.back.dto.AccountDTO;

public interface AccountService {
	AccountDTO getById(int id);
	List<AccountDTO> getAll();
	void add(AccountDTO accountDTO) throws Exception;
	void delete(AccountDTO account);
	void update(AccountDTO account) throws Exception;
}
