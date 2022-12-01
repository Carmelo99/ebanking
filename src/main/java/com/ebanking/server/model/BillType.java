package com.ebanking.server.model;

import java.util.Objects;

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

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti atributa
	 * 
	 * @param id id tipa racuna
	 * @param type naziv tipa racuna
	 */
	public BillType(int id, @NotNull String type) {
		super();
		this.id = id;
		this.type = type;
	}

	/**
	 * Konstruktor koji inicijalizuje objekat.
	 */
	public BillType() {
		super();
	}

	/**
	 * Vraca id tipa racuna
	 * 
	 * @return id tipa racuna
	 */
	public int getId() {
		return id;
	}

	/**
	 * Postavlja id tipa racuna na novu vrednost
	 * 
	 * @param id tipa racuna
	 * 
	 * @throws java.lang.RuntimeException ako je uneti id <=0
	 */
	public void setId(int id) {
		if (id<=0) {
			throw new RuntimeException("Id mora biti >0");
		}
		this.id = id;
	}

	/**
	 * Vraca naziv tipa racuna
	 * 
	 * @return type tip racuna
	 */
	public String getType() {
		return type;
	}

	/**
	 * Postavlja naziv tipa racuna na novu vrednost
	 * 
	 * @param type naziv tipa racuna
	 * 
	 * @throws java.lang.NullPointerException ako je uneti naziv tipa racuna null
	 */
	public void setType(String type) {
		if (type==null) {
			throw new NullPointerException("Naziv tipa racuna ne sme biti null");
		}
		this.type = type;
	}

	/**
	 * @return Vraca String sa svim podacima o tipu racuna
	 */
	@Override
	public String toString() {
		return "BillType [id=" + id + ", type=" + type + "]";
	}

	/**
	 * Poredi dva tipa racuna i vraca true ako su isti, false ako nisu.
	 * Tipovi racuna se porede po svim atributima i svi moraju da budu isti.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase BillType i imaju sve iste atribute</li>
	 * 		<li>false u svim ostalim slucajevima</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillType other = (BillType) obj;
		return id == other.id && Objects.equals(type, other.type);
	}
	
	
	
}
