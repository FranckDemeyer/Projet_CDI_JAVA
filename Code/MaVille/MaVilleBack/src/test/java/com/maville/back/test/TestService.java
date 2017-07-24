package com.maville.back.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maville.back.dto.AccountDTO;
import com.maville.back.service.interfaces.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/context.xml")
public class TestService {

	@Autowired
	private AccountService accountService;
	
	@Test
	public void test() {
		
		AccountDTO account = new AccountDTO("toto", "pass", true);
		try {
			accountService.addAccount(account);
		} catch (Exception e) {}
		
		account = accountService.getAccountById(1);
		
		account.setPassword("new password");
		
		try {
			account = accountService.updateAccount(account);
		} catch (Exception e) {}
		
		System.out.println(account);
		
		List<AccountDTO> accounts = accountService.getAllAccount();
		
		System.out.println(accounts);
		
		Assert.assertNotNull(account);
		
	}

}
