package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Accounts;
import com.banking.model.Transactions;
import com.banking.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionsController transactionsController;

	// createAccount happens upon createCustomer
	public void createAccount(int acctID, int balance, String acctStatus) {
		Accounts acct = new Accounts(acctID, balance, acctStatus);
		accountService.createAccount(acct);
	}

	// checkBalance
	@GetMapping("/account/{acctID}/balance")
	public int getBalance(@PathVariable int acctID) {
		return accountService.getBalance(acctID);
	}

	// depositAmount
	@PutMapping("/account/{acctID}/deposit/{amount}")
	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.depositAmount(acctID, amount);
		Transactions logger = new Transactions(acctID, "Deposited", "Success", initBal, initBal + amount);
		transactionsController.addLog(logger);
	}

	// withdrawAmount
	@PutMapping("/account/{acctID}/withdraw/{amount}")
	public void withdrawAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.withdrawAmount(acctID, amount);
		Transactions logger = new Transactions(acctID, "Withdrawn", "Success", initBal, initBal - amount);
		transactionsController.addLog(logger);
	}

	// transferAmount
	@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
	public void transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
		int initBalSender = getBalance(acctID);
		int initBalReceiver = getBalance(destAcctID);
		accountService.transferAmount(acctID, destAcctID, amount);
		Transactions loggerSender = new Transactions(acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
		transactionsController.addLog(loggerSender);
		Transactions loggerReceiver = new Transactions(destAcctID, "Received", "Success", initBalReceiver,
				initBalReceiver + amount);
		transactionsController.addLog(loggerReceiver);
	}

	// deleteAccount
	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable int acctID) {
		accountService.deleteAccount(acctID);
		transactionsController.deleteLog(acctID);
	}

	// getAccountInfo
	@GetMapping("/account/{acctID}")
	public Accounts getAccountInfo(@PathVariable int acctID) {
		return accountService.getAccountInfo(acctID);
	}
}
