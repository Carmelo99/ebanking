package com.ebanking.server.dto;

import com.ebanking.server.model.User;

import lombok.Getter;
import lombok.Setter;

/**
 * Klasa koja se koristi prilikom citanja iz baze.
 * 
 * @author Antonije
 *
 */
@Getter
@Setter
public class BankCardReadDto {

	/**
	 * Broj kartice kao integer.
	 */
	private int card_number;
	
	/**
	 * Tip kartice kao String.
	 */
	private String card_type;
	
	/**
	 * Korisnik kartice.
	 * Predstavlja spoljni kljuc ka tabeli User.
	 */
	private User card_owner;
	
}
