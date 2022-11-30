package com.ebanking.server.dto;

import com.ebanking.server.model.InsuranceCompany;

import lombok.Getter;
import lombok.Setter;

/**
 * Klasa koja se koristi prilikom citanja osiguranja iz baze.
 * 
 * @author Antonije
 *
 */
@Getter
@Setter
public class InsuranceReadDto {

	/**
	 * Sifra osiguranja kao integer.
	 */
	private int code;
	
	/**
	 * Naziv osiguranja kao String.
	 */
	private String insurance_name;
	
	/**
	 * Tip osiguranja kao String.
	 */
	private String insurance_type;
	
	/**
	 * Osiguravajuca kuca.
	 * Predstavlja spoljni kljuc ka tabeli InsuranceCompany.
	 */
	private InsuranceCompany company;
	
}
