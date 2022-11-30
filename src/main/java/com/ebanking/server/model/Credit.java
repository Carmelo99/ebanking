package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Klasa Credit predstavlja sve kredite koje su korisnici aplikacije podigli.
 * Sadrzi id kredita, tip kredita, iznos i posiljaoca.
 * 
 * @author Antonije
 *
 */
@Data
@Entity
@Table(name="credit")
public class Credit {

	/**
	 * Id kredita kao integer.
	 * Predstavlja jedinstveni identifikator tabele Credit.
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Tip kredita koji se podize.
	 * Predstavlja spoljni kljuc ka tabeli CreditType i ima referencu na kolonu id klase CreditType.
	 */
	@ManyToOne
	@JoinColumn(name="credit_type", referencedColumnName = "id")
	private CreditType type;
	
	/**
	 * Iznos kredita kao double.
	 */
	private double amount;
	
	/**
	 * Posiljalac koji aplicira za kredit.
	 * Predstavlja spoljni kljuc ka tabeli User, ima referencu na kolonu id klase User.
	 */
	@ManyToOne
	@JoinColumn(name="sender", referencedColumnName = "id")
	private User sender;
}
