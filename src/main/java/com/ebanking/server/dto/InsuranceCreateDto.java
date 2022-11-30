package com.ebanking.server.dto;

import com.ebanking.server.model.InsuranceCompany;

import lombok.Getter;
import lombok.Setter;

/**
 * Klasa koja se koristi prilikom upisivanje osiguranja u bazu.
 * 
 * @author Antonije
 *
 */
@Getter
@Setter
public class InsuranceCreateDto {

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
