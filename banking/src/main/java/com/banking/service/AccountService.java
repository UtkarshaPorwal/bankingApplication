package com.banking.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.banking.exception.AccountInfoNotFoundException;
import com.banking.model.Accounts;
import com.banking.repository.AccountsRepository;

@Service
public class AccountService {
	@Autowired
	private AccountsRepository accountRepository;

	public void createAccount(Accounts acct) {
		accountRepository.save(acct);
	}

	public Accounts getAccountInfo(int acctID) {
		Optional<Accounts> account=accountRepository.findById(acctID);
    	if(account.isPresent()){
    		return account.get();
    	}throw new AccountInfoNotFoundException("No such account Exists");
	}

	public void deleteAccount(int acctID) {
		accountRepository.deleteById(acctID);
	}

	public int getBalance(int acctID) {
		return accountRepository.findBalanceByAcctID(acctID);
	}

	public void depositAmount(int acctID, int amount) {
		accountRepository.saveBalanceByAcctID(acctID, amount);
	}

	public void withdrawAmount(int acctID, int amount) {
		accountRepository.withdrawAmountByAcctID(acctID, amount);
	}

	public void transferAmount(int acctID, int destAcctID, int amount) {
		accountRepository.withdrawAmountByAcctID(acctID, amount);
		accountRepository.saveBalanceByAcctID(destAcctID, amount);
	}
}
