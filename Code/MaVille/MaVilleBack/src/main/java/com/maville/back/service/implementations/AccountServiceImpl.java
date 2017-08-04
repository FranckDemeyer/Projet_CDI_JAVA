package com.maville.back.service.implementations;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maville.back.dao.interfaces.AccountDAO;
import com.maville.back.dto.AccountDTO;
import com.maville.back.dto.ProfessionalDTO;
import com.maville.back.entities.Account;
import com.maville.back.entities.Professional;
import com.maville.back.service.interfaces.AccountService;

@Transactional
@Component("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDAO accountDao;
	
	@Override
	public AccountDTO getAccountById(int id) {
		AccountDTO accountDTO = null;
		Account account = accountDao.find(id);
		if(account != null) {
			accountDTO = new AccountDTO();
			BeanUtils.copyProperties(account, accountDTO);
			ProfessionalDTO professionalDTO = new ProfessionalDTO();
			BeanUtils.copyProperties(account.getProfessional(), professionalDTO);
			accountDTO.setProfessional(professionalDTO);
		}
		return accountDTO;
	}
	
	@Override
	public AccountDTO getAccountByUsername(String username){
		AccountDTO accountDTO = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", username);
		Account account = accountDao.findOne(Account.FIND_BY_NAME, parameters);
		if(account != null) {
			accountDTO = new AccountDTO();
			BeanUtils.copyProperties(account, accountDTO);
			ProfessionalDTO professionalDTO = new ProfessionalDTO();
			BeanUtils.copyProperties(account.getProfessional(), professionalDTO);
			accountDTO.setProfessional(professionalDTO);
		}
		return accountDTO;
	}

	@Override
	public List<AccountDTO> getAllAccount() {
		List<AccountDTO> listAccounts = new ArrayList<>();
		for(Account acc : accountDao.findAll()) {
			AccountDTO acc2 = new AccountDTO();
			BeanUtils.copyProperties(acc, acc2);
			ProfessionalDTO professionalDTO = null;
			if(acc.getProfessional() != null) {
				professionalDTO = new ProfessionalDTO();
				BeanUtils.copyProperties(acc.getProfessional(), professionalDTO);
			}
			acc2.setProfessional(professionalDTO);
			listAccounts.add(acc2);
		}
		return listAccounts;
	}

	@Override
	public List<AccountDTO> getAllProfessional() {
		List<AccountDTO> listAccounts = new ArrayList<>();
		for(Account acc : accountDao.findGroup(Account.FIND_ALL_PROFESSIONAL, null)) {
			AccountDTO acc2 = new AccountDTO();
			BeanUtils.copyProperties(acc, acc2);
			ProfessionalDTO professionalDTO = new ProfessionalDTO();
			BeanUtils.copyProperties(acc.getProfessional(), professionalDTO);
			acc2.setProfessional(professionalDTO);
			listAccounts.add(acc2);
		}
		return listAccounts;
	}

	@Override
	public List<AccountDTO> getAllAdmin() {
		List<AccountDTO> listAccounts = new ArrayList<>();
		for(Account acc : accountDao.findGroup(Account.FIND_ALL_ADMIN, null)) {
			AccountDTO acc2 = new AccountDTO();
			BeanUtils.copyProperties(acc, acc2);
			ProfessionalDTO professionalDTO = new ProfessionalDTO();
			BeanUtils.copyProperties(acc.getProfessional(), professionalDTO);
			acc2.setProfessional(professionalDTO);
			listAccounts.add(acc2);
		}
		return listAccounts;
	}

	@Override
	public AccountDTO addAccount(AccountDTO account) throws Exception {
		// verify mandatory data
		String err = "";
		if(account.getUsername().isEmpty()){
			err += "Le nom d'utilisateur ne peut être vide. ";
		}
		if(account.getPassword().isEmpty()){
			err += "Le mot de passe ne peut être vide.";
		}
		if(err != ""){
			throw new IllegalArgumentException(err);
		}
		// verify username isn't already used
		if(getAccountByUsername(account.getUsername()) != null){
			throw new IllegalArgumentException("Ce nom d'utilisateur existe déjà");
		}
		// save data
		Account entity = new Account();
		BeanUtils.copyProperties(account, entity);
		Professional professional = new Professional();
		BeanUtils.copyProperties(account.getProfessional(), professional);
		entity.setProfessional(professional);
		try{
			entity = accountDao.save(entity);
			BeanUtils.copyProperties(entity, account);
			ProfessionalDTO professionalDTO = new ProfessionalDTO();
			BeanUtils.copyProperties(entity.getProfessional(), professionalDTO);
			account.setProfessional(professionalDTO);
		} catch(Exception e){
			throw new RuntimeException("Erreur lors de l'enregistrement de l'utilisateur");
		}
		return account;
	}

	@Override
	public void deleteAccount(AccountDTO account) {
		if(accountDao.find(account.getAccountId()) == null){
			throw new IllegalArgumentException("Cet utilisateur n'existe pas");
		}
		Account entity = new Account();
		BeanUtils.copyProperties(account, entity);
		try{
		accountDao.delete(entity);
		} catch(Exception e){
			throw new RuntimeException("Erreur lors de la suppression de l'utilisateur");
		}
	}

	@Override
	public AccountDTO updateAccount(AccountDTO account) throws Exception {
		// verify mandatory data
		String err = "";
		if(account.getUsername().isEmpty()){
			err += "Le nom d'utilisateur ne peut être vide. ";
		}
		if(account.getPassword().isEmpty()){
			err += "Le mot de passe ne peut être vide.";
		}
		if(err != ""){
			throw new IllegalArgumentException(err);
		}
		// 
		Account entity = new Account();
		BeanUtils.copyProperties(account, entity);
		try{
			entity = accountDao.update(entity);
		} catch(Exception e){
			throw new RuntimeException("Erreur lors de la mise à jour de l'utilisateur");
		}
		BeanUtils.copyProperties(entity, account);
		return account;
	}
}
