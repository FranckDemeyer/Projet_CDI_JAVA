package com.maville.back.dao.implementations;

import java.util.List;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.AccountDAO;
import com.maville.back.entities.Account;

public class AccountDAOImpl extends GenericDAO<Account, Integer> implements AccountDAO {

	public AccountDAOImpl() {
		super(Account.class);
	}

	@Override
	public List<Account> findAllProfessional() {
		return super.findGroup(Account.FIND_ALL_PROFESSIONAL, null);
	}

	@Override
	public List<Account> findAllAdmin() {
		return super.findGroup(Account.FIND_ALL_ADMIN, null);
	}

}
