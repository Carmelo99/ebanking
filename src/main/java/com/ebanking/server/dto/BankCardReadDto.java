package com.ebanking.server.dto;

import com.ebanking.server.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankCardReadDto {

	private int card_number;
	
	private String card_type;
	
	private User card_owner;
	
}
