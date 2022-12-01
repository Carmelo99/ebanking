package com.ebanking.server.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 * Klasa koja predstavlja karticu za banku korisnika aplikacije.
 * 
 * Sadrzi broj kartice, tip kartice i korisnika koji je vlasnik kartice.
 * 
 * @author Antonije
 *
 */
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

	/**
	 * Konstruktor koji inicijalizuje objekat.
	 */
	public BankCard() {
		super();
	}

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti atributa
	 * 
	 * @param card_number broj kartice
	 * @param card_type tip kartice
	 * @param card_owner korisnik kartice
	 */
	public BankCard(int card_number, @NotNull String card_type, User card_owner) {
		super();
		this.card_number = card_number;
		this.card_type = card_type;
		this.card_owner = card_owner;
	}

	/**
	 * Vraca broj kartice
	 * 
	 * @return card_number broj kartice
	 */
	public int getCard_number() {
		return card_number;
	}

	/**
	 * Postavlja broj kartice na novu vrednost
	 * 
	 * @param card_number broj kartice
	 * 
	 * @throws java.lang.RuntimeException ako je unet broj kartice <=0
	 */
	public void setCard_number(int card_number) {
		if (card_number<=0) {
			throw new RuntimeException("Broj kartice mora biti >0");
		}
		this.card_number = card_number;
	}

	/**
	 * Vraca tip kartice
	 * 
	 * @return card_type tip kartice
	 */
	public String getCard_type() {
		return card_type;
	}

	/**
	 * Postavlja tip kartice na novu vrednost
	 * 
	 * @param card_type tip kartice
	 * 
	 * @throws java.lang.NullPointerException ako je uneti tip kartice null
	 */
	public void setCard_type(String card_type) {
		if (card_type==null) {
			throw new NullPointerException("Tip kartice ne sme biti null");
		}
		this.card_type = card_type;
	}

	/**
	 * Vraca korisnika kartice
	 * 
	 * @return card_owner korisnik kartice
	 */
	public User getCard_owner() {
		return card_owner;
	}

	/**
	 * Postavlja korisnika kartice na novu vrednost
	 * 
	 * @param card_owner korisnik kartice
	 * 
	 * @throws java.lang.NullPointerException ako je uneti korisnik null
	 */
	public void setCard_owner(User card_owner) {
		if (card_owner==null) {
			throw new NullPointerException("Korisnik ne sme biti null");
		}
		this.card_owner = card_owner;
	}

	/**
	 * @return Vraca String sa svim podacima o bankarskoj kartici
	 */
	@Override
	public String toString() {
		return "BankCard [card_number=" + card_number + ", card_type=" + card_type + ", card_owner=" + card_owner + "]";
	}

	
	/**
	 * Poredi dve bankarske kartice i vraca true ako su iste, false ako nisu.
	 * Bankarske kartice se porede po svim atributima i svi moraju da budu isti.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase BankCard i imaju sve iste atribute</li>
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
		BankCard other = (BankCard) obj;
		return card_number == other.card_number && Objects.equals(card_owner, other.card_owner)
				&& Objects.equals(card_type, other.card_type);
	}
	
	
	
}
