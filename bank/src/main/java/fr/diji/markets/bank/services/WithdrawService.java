package fr.diji.markets.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.diji.markets.bank.common.security.SecurityContext;
import fr.diji.markets.bank.persistance.entities.Account;
import fr.diji.markets.bank.persistance.entities.Client;
import fr.diji.markets.bank.persistance.repository.AccountRepository;

/**
 * @Feature 1
 *  
 * As a client of the bank
  I want to withdraw money from my account
  In order to have cash
 
 * 
 * @author Mickael
 *
 */
@Service
public class WithdrawService {
	@Autowired AccountRepository accountRepository;
	@Autowired SecurityContext securityContext;
	
	public List<Account> selectAccounts() {
		Client client = securityContext.getAuthenticatedClient(); 
		return accountRepository.findByClient(client);
	}

	@Transactional
	public Account withdraw(String accountId, double withdrawAmount) {
		Account account;
		Client client = securityContext.getAuthenticatedClient();
		
		// When user selects no account, checking account is used
		if (accountId == null) {
			account = accountRepository.findCheckingAccount(client);
		}else {
			account = accountRepository.findOne(accountId);
		}
		
		account.withdraw(withdrawAmount);
		
		return account;
	}

	public SecurityContext getSecurityContext() {
		return securityContext;
	}
}
