package com.interview.metrobank.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interview.metrobank.enumerated.AccountType;
import com.interview.metrobank.exception.EntityNotFoundException;
import com.interview.metrobank.factory.CustomerFactory;
import com.interview.metrobank.model.Account;
import com.interview.metrobank.model.Customer;
import com.interview.metrobank.repository.AccountRepository;
import com.interview.metrobank.repository.CustomerRepository;
import com.interview.metrobank.requestDTO.CustomerRequestDTO;
import com.interview.metrobank.responseDTO.CustomerAccountLite;
import com.interview.metrobank.responseDTO.CustomerAccountResponseDTO;
import com.interview.metrobank.service.AccountService;

@Component
public class AccountServiceImpl implements AccountService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	AccountRepository accountRepo;

	@Autowired
	CustomerFactory customerFactory;

	@Override
	public CustomerAccountLite createCustomerAccount(CustomerRequestDTO requestDTO) {
		Customer customer = customerFactory.requestDTOToModel(requestDTO);
		customerRepo.save(customer);

		Account account = new Account();
		account.setBalance(500.0);
		account.setAccountNumber(1001L);
		account.setType(AccountType.valueOf(requestDTO.getAccountType().toUpperCase()));
		account.setCustomer(customer);
		accountRepo.save(account);
		return customerFactory.modelToLite(customer);
	}

	@Override
	public CustomerAccountResponseDTO getCustomerAccount(Long customerNumber) {
		Optional<Customer> customer = customerRepo.findById(customerNumber);
		if (customer.isEmpty()) {
			throw new EntityNotFoundException("Customer not Found");
		}

		return customerFactory.entityToResponseDTO(customer.get());
	}

}
