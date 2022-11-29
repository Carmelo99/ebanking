package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="insurance")
public class Insurance {
	
	@Id
	@GeneratedValue
	private int code;
	
	@NotNull
	private String insurance_name;
	
	@NotNull
	private String insurance_type;
	
	@ManyToOne
	@JoinColumn(name="company",referencedColumnName = "tin")
	private InsuranceCompany company;
	
	

}
