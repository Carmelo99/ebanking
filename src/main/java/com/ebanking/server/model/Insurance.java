package com.ebanking.server.model;

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
 * Klasa Insurance predstavlja osiguranja koja su dostupna korisniku aplikacije.
 * Sadrzi kod osiguranja, naziv osiguranja, tip osiguranja i kompaniju cije je osiguranje.
 * 
 * @author Antonije
 *
 */
@Entity
@Table(name="insurance")
public class Insurance {
	
	/**
	 * Kod osiguranja kao integer.
	 * Predstavlja jedinstveni identifikator tabele Insurance.
	 */
	@Id
	@GeneratedValue
	private int code;
	
	/**
	 * Naziv osiguranja kao String.
	 */
	@NotNull
	private String insurance_name;
	
	/**
	 * Tip osiguranja kao String.
	 */
	@NotNull
	private String insurance_type;
	
	/**
	 * Kompanija cije je osiguranje.
	 * Predstavlja spoljni kljuc ka tabeli InsuranceCompany i ima referencu na kolonu tin klase InsuranceCompany.
	 */
	@ManyToOne
	@JoinColumn(name="company",referencedColumnName = "tin")
	private InsuranceCompany company;

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti atributa
	 * 
	 * @param code sifra osiguranja
	 * @param insurance_name naziv osiguranja
	 * @param insurance_type tip osiguranja
	 * @param company osiguravajuca kuca
	 */
	public Insurance(int code, @NotNull String insurance_name, @NotNull String insurance_type,
			InsuranceCompany company) {
		super();
		this.code = code;
		this.insurance_name = insurance_name;
		this.insurance_type = insurance_type;
		this.company = company;
	}

	/**
	 * Konstruktor koji inicijalizuje objekat.
	 */
	public Insurance() {
		super();
	}

	/**
	 * Vraca sifru osiguranja
	 * 
	 * @return code sifra osiguranja
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Postavlja sifru osiguranja na novu vrednost
	 * 
	 * @param code sifra osiguranja
	 * 
	 * @throws java.lang.RuntimeException ako je uneta sifra osiguranja <=0
	 */
	public void setCode(int code) {
		if (code<=0) {
			throw new RuntimeException("Sifra osiguranja mora biti >0");
		}
		this.code = code;
	}

	/**
	 * Vraca naziv osiguranja
	 * 
	 * @return insurance_name naziv osiguranja
	 */
	public String getInsurance_name() {
		return insurance_name;
	}

	/**
	 * Postavlja naziv osiguranja na novu vrednost
	 * 
	 * @param insurance_name naziv osiguranja
	 * 
	 * @throws java.lang.NullPointerException ako je uneti naziv osiguranja null
	 */
	public void setInsurance_name(String insurance_name) {
		if (insurance_name==null) {
			throw new NullPointerException("Naziv osiguranja ne sme biti null");
		}
		this.insurance_name = insurance_name;
	}

	/**
	 * Vraca tip osiguranja
	 * 
	 * @return insurance_type tip osiguranja
	 */
	public String getInsurance_type() {
		return insurance_type;
	}

	/**
	 * Postavlja tip osiguranja na novu vrednost
	 * 
	 * @param insurance_type tip osiguranja
	 * 
	 * @throws java.lang.NullPointerException ako je uneti tip osiguranja null
	 */
	public void setInsurance_type(String insurance_type) {
		if (insurance_type==null) {
			throw new NullPointerException("Tip osiguranja ne sme biti null");
		}
		this.insurance_type = insurance_type;
	}

	/**
	 * Vraca osiguravajucu kucu
	 * 
	 * @return company osiguravajuca kuca
	 */
	public InsuranceCompany getCompany() {
		return company;
	}

	/**
	 * Postavlja osiguravajucu kucu na novu vrednost
	 * 
	 * @param company osiguravajuca kuca
	 * 
	 * @throws java.lang.NullPointerException ako je uneta osiguravajuca kuca null
	 */
	public void setCompany(InsuranceCompany company) {
		if (company==null) {
			throw new NullPointerException("Osiguravajuca kuca ne sme biti null");
		}
		this.company = company;
	}

	/**
	 * @return Vraca String sa svim podacima o osiguranju
	 */
	@Override
	public String toString() {
		return "Insurance [code=" + code + ", insurance_name=" + insurance_name + ", insurance_type=" + insurance_type
				+ ", company=" + company + "]";
	}

	/**
	 * Poredi dva osiguranja i vraca true ako su isti, false ako nisu.
	 * Osiguranja se porede po svim atributima i svi moraju da budu isti.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase Insurance i imaju sve iste atribute</li>
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
		Insurance other = (Insurance) obj;
		return code == other.code && Objects.equals(company, other.company)
				&& Objects.equals(insurance_name, other.insurance_name)
				&& Objects.equals(insurance_type, other.insurance_type);
	}
	
	
	
	

}
