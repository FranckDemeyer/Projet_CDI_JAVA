package com.maville.back.dao.interfaces;

import java.util.List;

import com.maville.back.dao.generics.AbstractDAO;
import com.maville.back.entities.Account;

public interface AccountDAO extends AbstractDAO<Account, Integer> {
	List<Account> findAllProfessional();
	List<Account> findAllAdmin();
}
