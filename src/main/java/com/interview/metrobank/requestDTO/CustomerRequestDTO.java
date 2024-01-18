package com.interview.metrobank.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerRequestDTO {

	@NotBlank(message = "Name is required field")
	String customerName;
	@NotBlank(message = "Mobile is required field")
	String customerMobile;
	@NotBlank(message = "Email is required field")
	String customerEmail;
	@NotBlank(message = "address1 is required field")
	String address1;
	String address2;
//	@NotBlank(message = "accountType is required field")
	String accountType;

}
