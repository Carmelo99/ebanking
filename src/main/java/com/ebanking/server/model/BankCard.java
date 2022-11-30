package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;


/**
 * Klasa koja predstavlja karticu za banku korisnika aplikacije.
 * 
 * Sadrzi broj kartice, tip kartice i korisnika koji je vlasnik kartice.
 * 
 * @author Antonije
 *
 */
@Data
@Entity
@Table(name="bank_card")
public class BankCard {
	
	
	/**
	 * Broj kartice kao integer.
	 * Predstavlja jedinstveni identifikator klase.
	 */
	@Id
	private int card_number;

	/**
	 * Tip kartice kao String.
	 */
	@NotNull
	private String card_type;
	
	/**
	 * Korisnik kartice.
	 * Predstavlja spoljni kljuc ka tabeli User, ima referencu na kolonu id tabele User.
	 */
	@ManyToOne
	@JoinColumn(name="card_owner", referencedColumnName = "id")
	private User card_owner;
	
}
