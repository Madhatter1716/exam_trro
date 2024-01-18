package com.interview.metrobank.enumerated;

public enum AccountType {
	
	SAVINGS("savings"), CHECKING("checking");

	
	private String type;
	
	AccountType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}


}
