package com.ebanking.server.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Klasa User predstavlja korisnika bankarske aplikacije.
 * Sadrzi id korisnika, ime i prezime, korisnicko ime i lozinku, godine, bracni status,
 * da li je zaposlen, mesecna primanja, da li je admin, iznos na racunu, kao i broj osiguranja.
 * 
 * @author Antonije
 *
 */
@Data
@Entity
@Table(name="users")
public class User implements Serializable{
	
	/**
	 * Id korisnika kao integer.
	 * Predstavlja jedinstveni identifikator tabele User.
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Ime korisnika kao String.
	 */
	@NotNull
	private String firstname;
	
	/**
	 * Prezime korisnika kao String.
	 */
	@NotNull
	private String lastname;
	
	/**
	 * Korisnicko ime korisnika kao String.
	 */
	@NotNull
	private String username;
	
	/**
	 * Lozinka korisnika kao String.
	 */
	@NotNull
	private String password;

	/**
	 * Godine korisnika kao integer.
	 */
	private int age;
	
	/**
	 * Bracni status korisnika kao String.
	 */
	@NotNull						
	private String marital_status;
	
	/**
	 * Da li je korisnik zaposlen kao boolean.
	 */
	@NotNull					
	private boolean employed;
	
	/**
	 * Mesecna primanja korisnika kao double.
	 */
	@NotNull
	private double monthly_income;
	
	/**
	 * Da li je korisnik admin kao boolean.
	 */
	@NotNull
	private boolean admin;
	
	/**
	 * Iznos na racunu korisnika kao double.
	 */
	private double amount;
	
	/**
	 * Broj osiguranja koje je korisnik uzeo.
	 * Predstavlja spoljni kljuc ka tabeli Insurance, ima referencu na kolonu code klase Insurance.
	 */
	@ManyToOne
	@JoinColumn(name="insurance_number",referencedColumnName = "code")
	private Insurance insurance_number;

}
