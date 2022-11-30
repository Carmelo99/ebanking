package com.ebanking.server.dto;

import com.ebanking.server.model.CreditType;
import com.ebanking.server.model.User;

import lombok.Getter;
import lombok.Setter;

/**
 * Klasa koja se koristi prilikom citanja kredita iz baze.
 * 
 * @author Antonije
 *
 */
@Getter
@Setter
public class CreditReadDto {

	/**
	 * Id kredita kao integer.
	 */
	private int id;
	
	/**
	 * Tip kredita.
	 * Predstavlja spoljni kljuc ka tabeli CreditType.
	 */
	private CreditType type;
	
	/**
	 * Iznos kredita kao double.
	 */
	private double amount;
	
	/**
	 * Korisnik koji je aplicirao za kredit.
	 * Predstavlja spoljni kljuc ka tabeli User.
	 */
	private User sender;
	
}
