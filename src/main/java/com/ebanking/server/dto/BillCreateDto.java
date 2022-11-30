package com.ebanking.server.dto;



import lombok.Getter;
import lombok.Setter;

/**
 * Klasa koja se koristi prilikom citanja racuna iz baze.
 * 
 * @author Antonije
 *
 */
@Getter
@Setter
public class BillCreateDto {

	/**
	 * Svrha uplate kao String.
	 */
	private String payment_purpose;

	/**
	 * Primalac kao String.
	 */
	private String receiver;
	
	/**
	 * Tip racuna kao String.
	 */
	private String type;
	
	/**
	 * Iznos racuna kao double.
	 */
	private double amount;
	
	/**
	 * Id korisnika kao integer.
	 */
	private int user_id;
	
	
}
