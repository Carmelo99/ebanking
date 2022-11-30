package com.ebanking.server.dto;

import java.io.Serializable;

import com.ebanking.server.model.Insurance;

import lombok.Getter;
import lombok.Setter;

/**
 * Klasa koja se koristi prilikom citanja korisnika iz baze.
 * 
 * @author Antonije
 *
 */
@Getter
@Setter
public class UserReadDto{

	/**
	 * Id korisnika kao integer.
	 */
	private int id;
	
	/**
	 * Ime korisnika kao String.
	 */
	private String firstname;

	/**
	 * Prezime korisnika kao String.
	 */
	private String lastname;

	/**
	 * Korisnicko ime kao String.
	 */
	private String username;

	/**
	 * Lozinka korisnika kao String.
	 */
	private String password;
	
	/**
	 * Godine korisnika kao double.
	 */
	private int age;
	
	/**
	 * Bracni status korisnika kao String.
	 */
	private String marital_status;
	
	/**
	 * Da li je korisnik zaposlen kao boolean.
	 */
	private boolean employed;
	
	/**
	 * Mesecna primanja korisnika kao double.
	 */
	private double monthly_income;
	
	/**
	 * Iznos na racunu korisnika kao double.
	 */
	private double amount;

	/**
	 * Da li je korisnik admin kao boolean.
	 */
	private boolean admin;
	
	/**
	 * Broj osiguranja.
	 * Predstavlja spoljni kljuc ka tabeli Insurance.
	 */
	private Insurance insurance_number;
	
}
