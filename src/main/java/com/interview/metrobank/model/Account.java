package com.interview.metrobank.model;

import com.interview.metrobank.enumerated.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="accountType")
	private AccountType type;
	
	private Long accountNumber;
	
	@Column(name="availableBalance")
	private Double balance;
	
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
}
