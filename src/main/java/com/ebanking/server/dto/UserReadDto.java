package com.ebanking.server.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReadDto{

	private int id;
	
	private String firstname;

	private String lastname;

	private String username;

	private String password;

	private boolean admin;
	
}
