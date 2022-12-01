package com.ebanking.server.model;

import java.util.Objects;

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

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti atributa
	 * 
	 * @param id id tipa kredita
	 * @param type naziv tipa kredita
	 */
	public CreditType(int id, @NotNull String type) {
		super();
		this.id = id;
		this.type = type;
	}

	/**
	 * Konstruktor koji inicijalizuje objekat.
	 */
	public CreditType() {
		super();
	}

	/**
	 * Vraca id tipa kredita
	 * 
	 * @return id tipa kredita
	 */
	public int getId() {
		return id;
	}

	/**
	 * Postavlja id tipa kredita na novu vrednost
	 * 
	 * @param id tipa kredita
	 * 
	 * @throws java.lang.RuntimeException ako je uneti id <=0
	 */
	public void setId(int id) {
		if (id <= 0) {
			throw new RuntimeException("Id mora biti >0");
		}
		this.id = id;
	}

	/**
	 * Vraca naziv tipa kredita
	 * 
	 * @return type naziv tipa kredita
	 */
	public String getType() {
		return type;
	}

	/**
	 * Postavlja naziv tipa kredita na novu vrednost
	 * 
	 * @param type naziv tipa kredita
	 * 
	 * @throws java.lang.NullPointerException ako je uneti naziv tipa kredita null
	 */
	public void setType(String type) {
		if (type==null) {
			throw new NullPointerException("Naziv tipa racuna ne sme biti null");
		}
		this.type = type;
	}

	/**
	 * @return Vraca String sa svim podacima o tipu kredita
	 */
	@Override
	public String toString() {
		return "CreditType [id=" + id + ", type=" + type + "]";
	}

	/**
	 * Poredi dva kredita i vraca true ako su isti, false ako nisu.
	 * Tipovi kredita se porede po svim atributima i svi moraju da budu isti.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase CreditType i imaju sve iste atribute</li>
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
		CreditType other = (CreditType) obj;
		return id == other.id && Objects.equals(type, other.type);
	}
	
	
	
}
