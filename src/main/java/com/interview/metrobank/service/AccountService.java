package com.interview.metrobank.service;

import com.interview.metrobank.requestDTO.CustomerRequestDTO;
import com.interview.metrobank.responseDTO.CustomerAccountLite;
import com.interview.metrobank.responseDTO.CustomerAccountResponseDTO;

public interface AccountService {

	CustomerAccountLite createCustomerAccount(CustomerRequestDTO requestDTO);
	
	CustomerAccountResponseDTO getCustomerAccount(Long customerNumber);
	
	
}
