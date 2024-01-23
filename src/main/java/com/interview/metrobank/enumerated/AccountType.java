package com.interview.metrobank.enumerated;

import java.util.Arrays;

public enum AccountType {
	
	SAVINGS("savings"), CHECKING("checking");

	
	private String type;
	
	AccountType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public static AccountType fetchAccountType(String constant) {
	       return Arrays.stream(AccountType.values())
	                    .filter(e -> e.getType().equals(constant))
	                    .findFirst()
	                    .orElse(null);
	    }


}
