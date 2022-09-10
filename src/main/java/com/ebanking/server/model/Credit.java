package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="credit")
public class Credit {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="credit_type", referencedColumnName = "id")
	private CreditType type;
	
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="sender", referencedColumnName = "id")
	private User sender;
}
