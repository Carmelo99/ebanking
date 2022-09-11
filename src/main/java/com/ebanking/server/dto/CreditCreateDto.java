package com.ebanking.server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCreateDto {

	private String type;
	
	private double amount;
	
	private int user_id;
	
}
