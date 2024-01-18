package com.interview.metrobank.responseDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CustomerAccountLite extends StatusResponseDTO {
	
	Long customerId;

	
	
}
