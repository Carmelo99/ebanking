package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="insurance_company")
public class InsuranceCompany {
	
	//tax identification number = pib
	@Id
	@GeneratedValue
	private int tin;
	
	@NotNull
	private String company_name;
	
}
