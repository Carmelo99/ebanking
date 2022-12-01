package com.ebanking.server.model;

import java.util.Objects;

import javax.management.RuntimeErrorException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Klasa InsuranceCompany predstavlja kompaniju cija osiguranja korisnik moze uzeti.
 * Sadrzi poreski identifikacioni broj kompanije, kao i njen naziv.
 * 
 * @author Antonije
 *
 */
@Entity
@Table(name="insurance_company")
public class InsuranceCompany {
	
	
	//tax identification number = pib
	/**
	 * Poreski identifikacioni broj kompanije kao integer.
	 * Predstavlja jedinstveni identifikator tabele InsuranceCompany.
	 */
	@Id
	@GeneratedValue
	private int tin;
	
	/**
	 * Naziv kompanije kao String.
	 */
	@NotNull
	private String company_name;

	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti atributa
	 * 
	 * @param tin poreski identifikacioni broj osiguravajuce kuce
	 * @param company_name naziv osiguravajuce kuce
	 */
	public InsuranceCompany(int tin, @NotNull String company_name) {
		super();
		this.tin = tin;
		this.company_name = company_name;
	}

	/**
	 * Konstruktor koji inicijalizuje objekat.
	 */
	public InsuranceCompany() {
		super();
	}

	/**
	 * Vraca poreski identifikacioni broj
	 * 
	 * @return tin poreski identifikacioni broj
	 */
	public int getTin() {
		return tin;
	}

	/**
	 * Postavlja poreski identifikacioni broj na novu vrednost
	 * 
	 * @param tin poreski identifikacioni broj
	 * 
	 * @throws java.lang.RuntimeException ako je poreski identifikacioni broj <=0
	 */
	public void setTin(int tin) {
		if (tin<=0) {
			throw new RuntimeException("Tin mora biti >0");
		}
		this.tin = tin;
	}

	/**
	 * Vraca naziv osiguravajuce kuce
	 * 
	 * @return company_name naziv osiguravajuce kuce
	 */
	public String getCompany_name() {
		return company_name;
	}

	/**
	 * Postavlja naziv osiguravajuce kuce na novu vrednost
	 * 
	 * @param company_name naziv osiguravajuce kuce
	 * 
	 * @throws java.lang.NullPointerException ako je naziv osiguravajuce kuce null
	 */
	public void setCompany_name(String company_name) {
		if (company_name==null) {
			throw new NullPointerException("Naziv osiguravajuce kuce ne sme biti null");
		}
		this.company_name = company_name;
	}

	/**
	 * @return Vraca String sa svim podacima o osiguravajucoj kuci
	 */
	@Override
	public String toString() {
		return "InsuranceCompany [tin=" + tin + ", company_name=" + company_name + "]";
	}

	/**
	 * Poredi dve osiguravajuce kuce i vraca true ako su iste, false ako nisu.
	 * Osiguravajuce kuce se porede po svim atributima i svi moraju da budu isti.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase InsuranceCompany i imaju sve iste atribute</li>
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
		InsuranceCompany other = (InsuranceCompany) obj;
		return Objects.equals(company_name, other.company_name) && tin == other.tin;
	}
	
	
	
}
