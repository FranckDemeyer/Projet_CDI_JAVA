package com.maville.back.test;


import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maville.back.dao.interfaces.AccountDAO;
//import com.maville.back.dao.interfaces.ProfessionalDAO;
import com.maville.back.entities.Account;
import com.maville.back.entities.Professional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/context.xml")
public class TestDAO {
	
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private AccountDAO accountDAO;
//	@Autowired
//	private ProfessionalDAO professionalDAO;
	
	@Test
	public void test() {
		Professional pro1 = new Professional("SAS", "LETest", "Rue marcer", "95820", "LaVille", "0663558877", "77.62855850000005", "12.9817147", false);
		Account account1 = new Account("test1", "test", false, pro1);
		Professional pro2 = new Professional("SAS", "LETest", "Rue marcer", "95820", "LaVille", "0663558877", "77.62855850000005", "12.9817147", false);
		Account account2 = new Account("test2", "test", false, pro2);
		Account account3 = new Account("test3", "test", true);
		Account account4 = new Account("test4", "test", true);
		pro1.setAccount(account1);
		pro2.setAccount(account2);
		accountDAO.save(account1);
		accountDAO.save(account2);
		accountDAO.save(account3);
		accountDAO.save(account4);
		List<Account> accountAdmin = accountDAO.findGroup(Account.FIND_ALL_ADMIN, null);
		System.out.println(accountAdmin);
		List<Account> accountPro = accountDAO.findGroup(Account.FIND_ALL_PROFESSIONAL, null);
		System.out.println(accountPro);
		Assert.assertNotEquals(accountAdmin.size(), 0);
	}

}
