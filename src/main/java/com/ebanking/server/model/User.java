package com.ebanking.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String firstname;
	@NotNull
	private String lastname;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private int age;
	@NotNull						
	private String marital_status;
	@NotNull					
	private boolean employed;
	@NotNull
	private double monthly_income;
	@NotNull
	private boolean admin;
	

}
