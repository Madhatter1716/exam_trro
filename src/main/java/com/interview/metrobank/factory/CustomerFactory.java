package com.interview.metrobank.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interview.metrobank.model.Customer;
import com.interview.metrobank.requestDTO.CustomerRequestDTO;
import com.interview.metrobank.responseDTO.CustomerAccountLite;
import com.interview.metrobank.responseDTO.CustomerAccountResponseDTO;

@Component
public class CustomerFactory {
	
	private final String CREATE_SUCCESS_MSG = "Customer account created";
	private final Integer CREATE_SUCCESS_CODE = 200;
	private final String GET__SUCCESS_MSG = "Customer account found";
	
	@Autowired
	AccountFactory accountFactory;

	public Customer requestDTOToModel(CustomerRequestDTO dto) {
		Customer customer = new Customer();
		customer.setName(dto.getCustomerName());
		customer.setAddress1(dto.getAddress1());
		customer.setAddress2(dto.getAddress2());
		customer.setEmail(dto.getCustomerEmail());
		customer.setMobile(dto.getCustomerMobile());
		return customer;
	}

	public CustomerAccountLite modelToLite(Customer customer) {
		
		return CustomerAccountLite.builder()
				.customerId(customer.getId())
				.transactionStatusCode(CREATE_SUCCESS_CODE)
				.transactionStatusDescription(CREATE_SUCCESS_MSG)
				.build();
	}
	
	public CustomerAccountResponseDTO entityToResponseDTO(Customer customer) {
		return CustomerAccountResponseDTO.builder()
				.customerEmail(customer.getEmail())
				.address1(customer.getAddress1())
				.address2(customer.getAddress2())
				.customerMobile(customer.getMobile())
				.customerName(customer.getName())
				.customerNumber(customer.getId().toString())
				.account(accountFactory.entityToResponseDTO(customer.getAccount()))
				.transactionStatusCode(302)
				.transactionStatusDescription(GET__SUCCESS_MSG)
				.build();
	}
}
