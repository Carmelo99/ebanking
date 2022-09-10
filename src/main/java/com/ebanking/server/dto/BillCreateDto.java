package com.ebanking.server.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillCreateDto {

	//@NotBlank(message = "Payment purpose must contain a value")
	private String payment_purpose;

	//@NotBlank(message = "Receiver must contain a value")
	private String receiver;
	
	//@NotBlank(message = "Bill type must contain a value")
	private String type;
	
	//@NotNull(message = "Amount must contain a value")
	private double amount;
	
	//@NotBlank(message = "Payment purpose must contain a value")
	private int user_id;
	
	
}
