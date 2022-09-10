package com.ebanking.server.dto;

import com.ebanking.server.model.BillType;
import com.ebanking.server.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillReadDto {

	private int id;
	
	private String payment_purpose;

	private String receiver;
	
	private BillType type;
	
	private double amount;
	
	private User sender;
	
}
