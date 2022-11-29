package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="bank_card")
public class BankCard {
	
	@Id
	private int card_number;

	@NotNull
	private String card_type;
	
	@ManyToOne
	@JoinColumn(name="card_owner", referencedColumnName = "id")
	private User card_owner;
	
}
