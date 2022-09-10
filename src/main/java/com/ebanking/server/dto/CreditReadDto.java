package com.ebanking.server.dto;

import com.ebanking.server.model.CreditType;
import com.ebanking.server.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditReadDto {

	private int id;
	
	private CreditType type;
	
	private double amount;
	
	private User sender;
	
}
