package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Klasa BillType predstavlja tip racuna koji korisnik uplacuje.
 * Sadrzi id tipa racuna i naziv tipa racuna.
 * 
 * @author Antonije
 *
 */
@Data
@Entity
@Table(name="bill_type")
public class BillType {

	/**
	 * Id tipa racuna kao integer.
	 * Predstavlja jedinstveni identifikator tabele BillType.
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Naziv tipa racuna kao String.
	 */
	@NotNull
	private String type;
	
}
