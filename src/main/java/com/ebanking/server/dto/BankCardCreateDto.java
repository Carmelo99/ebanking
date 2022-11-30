package com.ebanking.server.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Klasa koja se koristi prilikom cuvanja bankarske kartice u bazu.
 * 
 * @author Antonije
 *
 */
@Getter
@Setter
public class BankCardCreateDto {

	/**
	 * Tip kartice kao String.
	 */
	private String card_type;
	
	/**
	 * Korisnik kartice kao integer.
	 */
	private int card_owner;
	
	
	
}
