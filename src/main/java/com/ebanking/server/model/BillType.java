package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="bill_type")
public class BillType {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String type;
	
}
