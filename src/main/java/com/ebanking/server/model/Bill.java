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
 * Klasa Bill predstavlja sve racune svih korisnika aplikacije.
 * Sadrzi id racuna, svrhu uplate, primaoca racuna, tip racuna, iznos za uplatu i posiljaoca.
 * 
 * @author Antonije
 *
 */
@Data
@Entity
@Table(name="bill")
public class Bill {

	/**
	 * Id racuna kao integer.
	 * Predstavlja jedinstveni identifikator tabele Bill.
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Svrha uplate kao String.
	 */
	@NotNull
	private String payment_purpose;
	
	/**
	 * Primalac kao String.
	 */
	@NotNull
	private String receiver;
	
	/**
	 * Tip racuna koji se uplacuje.
	 * Predstavlja spoljni kljuc ka tabeli BillType i ima referencu na kolonu id klase BillType.
	 */
	@ManyToOne
	@JoinColumn(name = "bill_type", referencedColumnName = "id")
	private BillType type;
	
	/**
	 * Iznos za uplatu kao double.
	 */
	@NotNull
	private double amount;
	
	/**
	 * Posiljalac koji uplacuje racun.
	 * Predstavlja spoljni kljuc ka tabeli User, ima referencu na kolonu id klase User.
	 */
	@ManyToOne
	@JoinColumn(name="sender", referencedColumnName = "id")
	private User sender;
	
	
	
	
}
