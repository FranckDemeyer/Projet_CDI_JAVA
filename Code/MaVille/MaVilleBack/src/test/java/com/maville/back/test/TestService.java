package com.maville.back.test;

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
	private AccountService service;
	
	@Test
	public void test() {
		AccountDTO account = new AccountDTO("test", "passxord", true);
		try {
			service.addAccount(account);
			System.out.println(account);
			account.setPassword("password");
			account = service.updateAccount(account);
			System.out.println(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertNotNull(account);
	}

}
