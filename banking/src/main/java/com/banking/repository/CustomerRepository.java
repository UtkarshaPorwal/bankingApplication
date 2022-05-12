package com.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.banking.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>  {

}
