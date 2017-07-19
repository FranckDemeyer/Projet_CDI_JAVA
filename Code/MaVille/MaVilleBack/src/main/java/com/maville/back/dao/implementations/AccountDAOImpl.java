package com.maville.back.dao.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.AccountDAO;
import com.maville.back.entities.Account;

public class AccountDAOImpl extends GenericDAO<Account, Integer> implements AccountDAO {

	public AccountDAOImpl() {
		super(Account.class);
	}

	@Override
	public List<Account> findAllProfessional() {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("admin", Boolean.TRUE);
		return super.findGroup(namedQuery, parameters);
		// TODO creer la namedQuery
	}

	@Override
	public List<Account> findAllAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

}
