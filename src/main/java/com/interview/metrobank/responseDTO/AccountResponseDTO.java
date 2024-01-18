package com.interview.metrobank.responseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountResponseDTO {
	
	Long accountNumber;
	String accountType;
	Double availableBalance;

}
