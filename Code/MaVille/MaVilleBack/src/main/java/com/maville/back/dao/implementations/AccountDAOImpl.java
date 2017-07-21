package com.maville.back.dao.implementations;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.maville.back.dao.generics.GenericDAO;
import com.maville.back.dao.interfaces.AccountDAO;
import com.maville.back.entities.Account;

@Transactional
@Repository("accountDAO")
public class AccountDAOImpl extends GenericDAO<Account, Integer> implements AccountDAO {

	public AccountDAOImpl() {
		super(Account.class);
	}

}
