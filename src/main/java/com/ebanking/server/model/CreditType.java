package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Klasa CreditType predstavlja tip kredita za koji korisnik aplicira.
 * Sadrzi id tipa kredita i naziv tipa.
 * 
 * @author Antonije
 *
 */
@Data
@Entity
@Table(name="credit_type")
public class CreditType {
	
	/**
	 * Id tipa kredita kao integer.
	 * Predstavlja jedinstveni identifikator tabele CreditType.
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Naziv tipa kredita kao String.
	 */
	@NotNull
	private String type;
	
}
