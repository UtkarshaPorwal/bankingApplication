package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Transactions;
import com.banking.service.TransactionsService;

@RestController
public class TransactionsController {
	@Autowired
	private TransactionsService transactionsService;

	// addLog
	public void addLog(Transactions transactions) {
		transactionsService.addLog(transactions);
	}

	// showLog
	@GetMapping("/account/{acctID}/logs")
	public Transactions showLog(@PathVariable int acctID) {
		return transactionsService.showLog(acctID);
	}

	public void deleteLog(int acctID) {
		transactionsService.deleteLog(acctID);
	}
}
