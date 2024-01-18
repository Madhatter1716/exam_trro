package com.interview.metrobank.responseDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CustomerAccountResponseDTO extends StatusResponseDTO {

	String customerNumber;
	String customerName;
	String customerMobile;
	String customerEmail;
	String address1;
	String address2;
	AccountResponseDTO account;
	
	
}
