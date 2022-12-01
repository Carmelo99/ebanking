package com.ebanking.server.model;

import java.util.Objects;

import javax.management.RuntimeErrorException;
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

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti atributa
	 * 
	 * @param id id kredita
	 * @param type tip kredita
	 * @param amount iznos za kredit
	 * @param sender aplikant za kredit
	 */
	public Credit(int id, CreditType type, double amount, User sender) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.sender = sender;
	}

	/**
	 * Konstruktor koji inicijalizuje objekat.
	 */
	public Credit() {
		super();
	}

	/**
	 * Vraca id kredita
	 * 
	 * @return id kredita
	 */
	public int getId() {
		return id;
	}

	/**
	 * Postavlja id kredita na novu vrednost
	 * 
	 * @param id kredita
	 * 
	 * @throws java.lang.RuntimeException ako je uneti id kredita <=0
	 */
	public void setId(int id) {
		if (id<=0) {
			throw new RuntimeException("Id mora biti >0");
		}
		this.id = id;
	}

	/**
	 * Vraca tip kredita
	 * 
	 * @return type tip kredita
	 */
	public CreditType getType() {
		return type;
	}

	/**
	 * Postavlja tip kredita na novu vrednost
	 * 
	 * @param type tip kredita
	 * 
	 * @throws java.lang.NullPointerException ako je uneti tip kredita null
	 */
	public void setType(CreditType type) {
		if (type==null) {
			throw new NullPointerException("Tip kredita ne sme biti null");
		}
		this.type = type;
	}

	/**
	 * Vraca iznos za kredit
	 * 
	 * @return amount iznos kredita
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Postavlja iznos kredita na novu vrednost
	 * 
	 * @param amount iznos kredita
	 * 
	 * @throws java.lang.RuntimeException ako je uneti iznos kredita <=0
	 */
	public void setAmount(double amount) {
		if (amount <=0) {
		throw new RuntimeException("Iznos mora biti >0");
		}
		this.amount = amount;
	}

	/**
	 * Vraca aplikanta za kredit
	 * 
	 * @return sender aplikant za kredit
	 */
	public User getSender() {
		return sender;
	}

	/**
	 * Postavlja aplikanta za kredit na novu vrednost
	 * 
	 * @param sender aplikant
	 * 
	 * @throws java.lang.NullPointerException ako je uneti aplikant null
	 */
	public void setSender(User sender) {
		if (sender==null) {
			throw new NullPointerException("Korisnik ne sme biti null");
		}
		this.sender = sender;
	}

	/**
	 * @return Vraca String sa svim podacima o kreditu
	 */
	@Override
	public String toString() {
		return "Credit [id=" + id + ", type=" + type + ", amount=" + amount + ", sender=" + sender + "]";
	}

	/**
	 * Poredi dva kredita i vraca true ako su isti, false ako nisu.
	 * Krediti se porede po svim atributima i svi moraju da budu isti.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase Credit i imaju sve iste atribute</li>
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
		Credit other = (Credit) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && id == other.id
				&& Objects.equals(sender, other.sender) && Objects.equals(type, other.type);
	}
	
	
}
