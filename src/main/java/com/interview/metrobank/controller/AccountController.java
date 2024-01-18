package com.interview.metrobank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.metrobank.requestDTO.CustomerRequestDTO;
import com.interview.metrobank.responseDTO.CustomerAccountLite;
import com.interview.metrobank.responseDTO.CustomerAccountResponseDTO;
import com.interview.metrobank.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/account")
	public ResponseEntity<CustomerAccountLite> createAccount(@RequestBody @Valid CustomerRequestDTO customerDTO) {

		return ResponseEntity.ok(accountService.createCustomerAccount(customerDTO));

	}

	@GetMapping("/account/{customerNumber}")
	public ResponseEntity<CustomerAccountResponseDTO> getAccountDetails(
			@PathVariable("customerNumber") Long customerNumber) {

		return ResponseEntity.ok(accountService.getCustomerAccount(customerNumber));
	}

}
