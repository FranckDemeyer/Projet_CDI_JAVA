package com.maville.back.service;

import java.util.List;

import com.maville.back.entities.Account;

public interface AccountService {
	Account getById(int id);

	List<Account> getAll();

	void add(Account account) throws Exception;

	void delete(Account account);

	void update(Account account) throws Exception;
}
