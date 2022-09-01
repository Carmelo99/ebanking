package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="credit_type")
public class CreditType {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String type;
	
}
