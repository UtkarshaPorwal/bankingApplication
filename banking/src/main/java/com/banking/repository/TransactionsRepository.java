package com.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.banking.model.Transactions;

public interface TransactionsRepository extends CrudRepository<Transactions, Integer>{

}
