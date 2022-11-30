package com.ebanking.server.dto;

import com.ebanking.server.model.BillType;
import com.ebanking.server.model.User;

import lombok.Getter;
import lombok.Setter;

/**
 * Klasa koja se koristi prilikom citanja racuna iz baze.
 * 
 * 
 * @author Antonije
 *
 */
@Getter
@Setter
public class BillReadDto {

	/**
	 * Id racuna kao integer.
	 */
	private int id;
	
	/**
	 * Svrha uplate kao String.
	 */
	private String payment_purpose;

	/**
	 * Primilac kao String.
	 */
	private String receiver;
	
	/**
	 * Tip racuna.
	 * Predstavlja spoljni kljuc ka tabeli BillType.
	 */
	private BillType type;
	
	/**
	 * Iznos racuna kao double.
	 */
	private double amount;
	
	/**
	 * Korisnik koji placa racun.
	 * Predstavlja spoljni kljuc ka tabeli User.
	 */
	private User sender;
	
}
