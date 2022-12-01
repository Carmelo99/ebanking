package com.ebanking.server.model;

import java.util.Objects;

import javax.management.RuntimeErrorException;
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

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti atributa
	 * 
	 * @param id id racuna
	 * @param payment_purpose svrha uplate
	 * @param receiver primalac
	 * @param type tip racuna
	 * @param amount iznos uplate
	 * @param sender posiljalac
	 */
	public Bill(int id, @NotNull String payment_purpose, @NotNull String receiver, BillType type,
			@NotNull double amount, User sender) {
		super();
		this.id = id;
		this.payment_purpose = payment_purpose;
		this.receiver = receiver;
		this.type = type;
		this.amount = amount;
		this.sender = sender;
	}

	/**
	 * Konstruktor koji inicijalizuje objekat.
	 */
	public Bill() {
		super();
	}

	/**
	 * Vraca id racuna
	 * 
	 * @return id id racuna
	 */
	public int getId() {
		return id;
	}

	/**
	 * Postavlja id racuna na novu vrednost
	 * 
	 * @param id racuna
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
	 * Vraca svrhu uplate
	 * 
	 * @return payment_purpose svrha uplate
	 */
	public String getPayment_purpose() {
		return payment_purpose;
	}

	/**
	 * Postavlja svrhu uplate na novu vrednost
	 * 
	 * @param payment_purpose svrha uplate
	 * 
	 * @throws java.lang.NullPointerException ako je uneta svrha uplate null
	 */
	public void setPayment_purpose(String payment_purpose) {
		if (payment_purpose == null) {
			throw new NullPointerException("Svrha uplate ne sme biti null");
		}
		this.payment_purpose = payment_purpose;
	}

	/**
	 * Vraca primaoca
	 * 
	 * @return receiver primalac
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * Postavlja primaoca na novu vrednost
	 * 
	 * @param receiver primalac
	 * 
	 * @throws java.lang.NullPointerException ako je uneti primalac null
	 */
	public void setReceiver(String receiver) {
		if (receiver==null) {
			throw new NullPointerException("Primalac ne sme biti null");
		}
		this.receiver = receiver;
	}

	/**
	 * Vraca tip racuna
	 * 
	 * @return type tip racuna
	 */
	public BillType getType() {
		return type;
	}

	/**
	 * Postavlja tip racuna na novu vrednost
	 * 
	 * @param type tip racuna
	 * 
	 * @throws java.lang.NullPointerException ako je uneti tip racuna null
	 */
	public void setType(BillType type) {
		if (type==null) {
			throw new NullPointerException("Tip racuna ne sme biti null");
		}
		this.type = type;
	}

	/**
	 * Vraca iznos za uplatu
	 * 
	 * @return amount iznos
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Postavlja iznos racuna na novu vrednost
	 * 
	 * @param amount iznos racuna
	 * 
	 * @throws java.lang.RuntimeException ako je uneti iznos <=0
	 */
	public void setAmount(double amount) {
		if (amount<=0) {
			throw new RuntimeException("Iznos mora biti pozitivan broj");
		}
		this.amount = amount;
	}

	/**
	 * Vraca posiljaoca
	 * 
	 * @return amount posiljalac
	 */
	public User getSender() {
		return sender;
	}

	/**
	 * Postavlja posiljaoca na novu vrednost
	 * 
	 * @param sender posiljalac
	 * 
	 * @throws java.lang.NullPointerException ako je uneti posiljalac null
	 */
	public void setSender(User sender) {
		if (sender==null) {
			throw new NullPointerException("Korisnik ne sme biti null");
		}
		this.sender = sender;
	}

	/**
	 * @return Vraca String sa svim podacima o racunu
	 */
	@Override
	public String toString() {
		return "Bill [id=" + id + ", payment_purpose=" + payment_purpose + ", receiver=" + receiver + ", type=" + type
				+ ", amount=" + amount + ", sender=" + sender + "]";
	}

	
	/**
	 * Poredi dva racuna i vraca true ako su isti, false ako nisu.
	 * Racuni se porede po svim atributima i svi moraju da budu isti.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase Bill i imaju sve iste atribute</li>
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
		Bill other = (Bill) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && id == other.id
				&& Objects.equals(payment_purpose, other.payment_purpose) && Objects.equals(receiver, other.receiver)
				&& Objects.equals(sender, other.sender) && Objects.equals(type, other.type);
	}
	
	
	
	
	
}
