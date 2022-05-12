package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.model.Transactions;
import com.banking.repository.TransactionsRepository;
@Service
public class TransactionsService {
	@Autowired
	TransactionsRepository transactionsRepository;

	public void addLog(Transactions transactions) {
		transactionsRepository.save(transactions);
	}

	public Transactions showLog(int acctID) {
		return transactionsRepository.findById(acctID).orElse(null);
	}

	public void deleteLog(int acctID) {
		transactionsRepository.deleteById(acctID);
	}
}
