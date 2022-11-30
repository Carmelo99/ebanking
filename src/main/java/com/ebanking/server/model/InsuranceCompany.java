package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Klasa InsuranceCompany predstavlja kompaniju cija osiguranja korisnik moze uzeti.
 * Sadrzi poreski identifikacioni broj kompanije, kao i njen naziv.
 * 
 * @author Antonije
 *
 */
@Data
@Entity
@Table(name="insurance_company")
public class InsuranceCompany {
	
	
	//tax identification number = pib
	/**
	 * Poreski identifikacioni broj kompanije kao integer.
	 * Predstavlja jedinstveni identifikator tabele InsuranceCompany.
	 */
	@Id
	@GeneratedValue
	private int tin;
	
	/**
	 * Naziv kompanije kao String.
	 */
	@NotNull
	private String company_name;
	
}
