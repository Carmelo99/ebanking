package com.ebanking.server.model;


import java.io.Serializable;
import java.util.Objects;

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

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti atributa
	 * 
	 * @param id id korisnika
	 * @param firstname ime korisnika
	 * @param lastname prezime korisnika
	 * @param username korisnicko ime
	 * @param password sifra
	 * @param age godine korisnika
	 * @param marital_status bracni status
	 * @param employed da li je korisnik zaposlen
	 * @param monthly_income mesecna primanja korisnika
	 * @param admin da li je korisnik admin
	 * @param amount iznos na racunu korisnika
	 * @param insurance_number broj osiguranja
	 */
	public User(int id, @NotNull String firstname, @NotNull String lastname, @NotNull String username,
			@NotNull String password, int age, @NotNull String marital_status, @NotNull boolean employed,
			@NotNull double monthly_income, @NotNull boolean admin, double amount, Insurance insurance_number) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.age = age;
		this.marital_status = marital_status;
		this.employed = employed;
		this.monthly_income = monthly_income;
		this.admin = admin;
		this.amount = amount;
		this.insurance_number = insurance_number;
	}

	/**
	 * Konstruktor koji inicijalizuje objekat.
	 */
	public User() {
		super();
	}

	/**
	 * Vraca id korisnika
	 * 
	 * @return id korisnika
	 */
	public int getId() {
		return id;
	}

	/**
	 * Postavlja id korisnika na novu vrednost
	 * 
	 * @param id korisnika
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
	 * Vraca ime korisnika
	 * 
	 * @return firstname ime korisnika
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Postavlja ime korisnika na novu vrednost
	 * 
	 * @param firstname ime korisnika
	 * 
	 * @throws java.lang.NullPointerException ako je uneto ime korisnika null
	 */
	public void setFirstname(String firstname) {
		if (firstname==null) {
			throw new NullPointerException("Ime ne sme biti null");
		}
		this.firstname = firstname;
	}

	/**
	 * Vraca prezime korisnika
	 * 
	 * @return lastname prezime korisnika
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Postavlja prezime korisnika na novu vrednost
	 * 
	 * @param lastname prezime korisnika
	 * 
	 * @throws java.lang.NullPointerException ako je uneto prezime korisnika null
	 */
	public void setLastname(String lastname) {
		if (lastname==null) {
			throw new NullPointerException("Prezime ne sme biti null");
		}
		this.lastname = lastname;
	}

	/**
	 * Vraca korisnicko ime
	 * 
	 * @return username korisnicko ime
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Postavlja korisnicko ime na novu vrednost
	 * 
	 * @param username korisnicko ime
	 * 
	 * @throws java.lang.NullPointerException ako je uneto korisnicko ime null
	 */
	public void setUsername(String username) {
		if (username==null) {
			throw new NullPointerException("Korisnicko ime ne sme biti null");
		}
		this.username = username;
	}

	/**
	 * Vraca lozinku
	 * 
	 * @return password sifra
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Postavlja lozinku na novu vrednost
	 * 
	 * @param password lozinka
	 * 
	 * @throws java.lang.NullPointerException ako je uneta lozinka null
	 */
	public void setPassword(String password) {
		if (password==null) {
			throw new NullPointerException("Lozinka ne sme biti null");
		}
		this.password = password;
	}

	/**
	 * Vraca godine korisnika
	 * 
	 * @return age godine korisnika
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Postavlja godine korisnika na novu vrednost
	 * 
	 * @param age godine korisnika
	 * 
	 * @throws java.lang.RuntimeException ako su unete godine korisnika <=0
	 */
	public void setAge(int age) {
		if (age <= 0) {
			throw new RuntimeException("Godine moraju biti >0");
		}
		this.age = age;
	}

	/**
	 * Vraca bracni status 
	 * 
	 * @return marital_status bracni status
	 */
	public String getMarital_status() {
		return marital_status;
	}

	/**
	 * Postavlja bracni status korisnika na novu vrednost
	 * 
	 * @param marital_status bracni status
	 * 
	 * @throws java.lang.NullPointerException ako je uneti bracni status null
	 */
	public void setMarital_status(String marital_status) {
		if (marital_status==null) {
			throw new NullPointerException("Bracni status ne sme biti null");
		}
		this.marital_status = marital_status;
	}

	/**
	 * Vraca da li je korisnik zaposlen
	 * 
	 * @return employed da li je korisnik zaposlen
	 */
	public boolean isEmployed() {
		return employed;
	}

	/**
	 * Postavlja zaposlenje korisnika na novu vrednost
	 * 
	 * @param employed zaposlenje korisnika
	 */
	public void setEmployed(boolean employed) {
		this.employed = employed;
	}

	/**
	 * Vraca mesecna primanja
	 * 
	 * @return monthly_income mesecna primanja
	 */
	public double getMonthly_income() {
		return monthly_income;
	}

	/**
	 * Postavlja mesecna primanja korisnika na novu vrednost
	 * 
	 * @param monthly_income mesecna primanja
	 * 
	 * @throws java.lang.RuntimeException ako su uneta mesecna primanja <=0
	 */
	public void setMonthly_income(double monthly_income) {
		if (monthly_income <= 0) {
			throw new RuntimeException("Mesecna primanja moraju biti >0");
		}
		this.monthly_income = monthly_income;
	}

	/**
	 * Vraca da li je korisnik admin
	 * 
	 * @return admin da li je korisnik admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Postavlja admin ulogu korisnika na novu vrednost
	 * 
	 * @param admin admin uloga
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * Vraca iznos na racunu korisnika
	 * 
	 * @return amount iznos na racunu
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Postavlja iznos na racunu korisnika na novu vrednost
	 * 
	 * @param amount iznos na racunu
	 * 
	 * @throws java.lang.RuntimeException ako je uneti iznos <=0
	 */
	public void setAmount(double amount) {
		if (amount <= 0) {
			throw new RuntimeException("Iznos mora biti >0");
		}
		this.amount = amount;
	}

	/**
	 * Vraca broj osiguranja
	 * 
	 * @return insurance_number broj osiguranja
	 */
	public Insurance getInsurance_number() {
		return insurance_number;
	}

	/**
	 * Postavlja broj osiguranja na novu vrednost
	 * 
	 * @param insurance_number broj osiguranja
	 * 
	 * @throws java.lang.NullPointerException ako je uneti broj osiguranja null
	 */
	public void setInsurance_number(Insurance insurance_number) {
		if (insurance_number==null) {
			throw new NullPointerException("Broj osiguranja ne sme biti null");
		}
		this.insurance_number = insurance_number;
	}

	/**
	 * @return Vraca String sa svim podacima o korisniku
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", age=" + age + ", marital_status=" + marital_status + ", employed="
				+ employed + ", monthly_income=" + monthly_income + ", admin=" + admin + ", amount=" + amount
				+ ", insurance_number=" + insurance_number + "]";
	}

	
	/**
	 * Poredi dva korisnika i vraca true ako su isti, false ako nisu.
	 * Korisnici se porede po svim atributima i svi moraju da budu isti.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase User i imaju sve iste atribute</li>
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
		User other = (User) obj;
		return admin == other.admin && age == other.age
				&& Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& employed == other.employed && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(insurance_number, other.insurance_number) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(marital_status, other.marital_status)
				&& Double.doubleToLongBits(monthly_income) == Double.doubleToLongBits(other.monthly_income)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	
	

}
