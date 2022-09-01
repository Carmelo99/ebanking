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
@Table(name="bill")
public class Bill {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String payment_purpose;
	@NotNull
	private String receiver;
	
	@ManyToOne
	@JoinColumn(name = "bill_type", referencedColumnName = "id")
	private BillType bill_type;
	
	@NotNull
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="sender", referencedColumnName = "id")
	private User sender;
	
	
	
	
}
