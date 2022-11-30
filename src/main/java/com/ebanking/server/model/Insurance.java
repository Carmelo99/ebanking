package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Klasa Insurance predstavlja osiguranja koja su dostupna korisniku aplikacije.
 * Sadrzi kod osiguranja, naziv osiguranja, tip osiguranja i kompaniju cije je osiguranje.
 * 
 * @author Antonije
 *
 */
@Data
@Entity
@Table(name="insurance")
public class Insurance {
	
	/**
	 * Kod osiguranja kao integer.
	 * Predstavlja jedinstveni identifikator tabele Insurance.
	 */
	@Id
	@GeneratedValue
	private int code;
	
	/**
	 * Naziv osiguranja kao String.
	 */
	@NotNull
	private String insurance_name;
	
	/**
	 * Tip osiguranja kao String.
	 */
	@NotNull
	private String insurance_type;
	
	/**
	 * Kompanija cije je osiguranje.
	 * Predstavlja spoljni kljuc ka tabeli InsuranceCompany i ima referencu na kolonu tin klase InsuranceCompany.
	 */
	@ManyToOne
	@JoinColumn(name="company",referencedColumnName = "tin")
	private InsuranceCompany company;
	
	

}
