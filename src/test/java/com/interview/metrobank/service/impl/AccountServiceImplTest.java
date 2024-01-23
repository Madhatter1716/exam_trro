package com.interview.metrobank.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.interview.metrobank.exception.EmailInvalidException;
import com.interview.metrobank.exception.EnumNotFoundException;
import com.interview.metrobank.factory.CustomerFactory;
import com.interview.metrobank.model.Customer;
import com.interview.metrobank.repository.AccountRepository;
import com.interview.metrobank.repository.CustomerRepository;
import com.interview.metrobank.requestDTO.CustomerRequestDTO;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {

	@Mock
	CustomerRepository mockCustomerRepo;

	@Mock
	AccountRepository mockAccountRepository;

	@Mock
	CustomerFactory mockCustomerFactory;

	@InjectMocks
	AccountServiceImpl accountService;

	@Test
	public void givenInvalidEmail_WhenCreateCustomerAccount_ThenThrowException() {
		CustomerRequestDTO mockRequestDTO = mockedCustomerRequestDTO();
		mockRequestDTO.setCustomerEmail("metrobankgmail.com");

		assertThrows(EmailInvalidException.class, () -> accountService.createCustomerAccount(mockRequestDTO),
				"Customer email is not a valid format");
	}

	@Test
	public void givenNullAccountType_WhenCreateCustomerAccount_ThenThrowException() {
		CustomerRequestDTO mockRequestDTO = mockedCustomerRequestDTO();
		mockRequestDTO.setAccountType(null);

		assertThrows(EnumNotFoundException.class, () -> accountService.createCustomerAccount(mockRequestDTO),
				"Account type is not valid");
	}
	
	@Test
	public void givenInvalidAccountType_WhenCreateCustomerAccount_ThenThrowException() {
		CustomerRequestDTO mockRequestDTO = mockedCustomerRequestDTO();
		mockRequestDTO.setAccountType("invalid");

		assertThrows(EnumNotFoundException.class, () -> accountService.createCustomerAccount(mockRequestDTO),
				"Account type is not valid");
	}
	
	@Test
	public void givenValidRequestDTO_WhenCreateCustomerAccount_ThenSavedSuccessfully() {
		CustomerRequestDTO mockRequestDTO = mockedCustomerRequestDTO();
		when(mockCustomerFactory.requestDTOToModel(mockRequestDTO)).thenReturn(new Customer());
		accountService.createCustomerAccount(mockRequestDTO);
		verify(mockCustomerFactory, times(1)).requestDTOToModel(mockRequestDTO);
		verify(mockCustomerRepo, times(1)).save(any(Customer.class));
		verify(mockCustomerFactory, times(1)).modelToLite(any(Customer.class));
	}

	CustomerRequestDTO mockedCustomerRequestDTO() {
		return CustomerRequestDTO.builder().accountType("savings").customerName("Test").customerMobile("012345678911")
				.address1("test address").customerEmail("metrobank@gmail.com").build();
	}

}
