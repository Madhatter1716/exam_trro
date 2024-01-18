package com.interview.metrobank.factory;

import org.springframework.stereotype.Component;

import com.interview.metrobank.model.Account;
import com.interview.metrobank.responseDTO.AccountResponseDTO;

@Component
public class AccountFactory {
	
	public AccountResponseDTO entityToResponseDTO(Account account) {
		return AccountResponseDTO.builder()
				.accountNumber(account.getAccountNumber())
				.accountType(account.getType().toString())
				.availableBalance(account.getBalance())
				.build();
	}

}
