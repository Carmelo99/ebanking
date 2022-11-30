package com.ebanking.server.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Klasa koja se koristi prilikom upisivanja kredita u bazu.
 * 
 * @author Antonije
 *
 */
@Getter
@Setter
public class CreditCreateDto {

	/**
	 * Tip kredita kao String.
	 */
	private String type;
	
	/**
	 * Iznos kredita kao amount.
	 */
	private double amount;
	
	/**
	 * Id korisnika kao integer.
	 */
	private int user_id;
	
}
