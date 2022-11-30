package com.ebanking.server.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * Klasa koja se koristi prilikom login-a korisnika u bazu.
 * 
 * @author Antonije
 *
 */
@Getter
@Setter
public class UserCreateDto {

	/**
	 * Korisnicko ime kao String.
	 */
	@NotBlank
	private String username;

	/**
	 * Lozinka kao String.
	 */
	@NotBlank
	private String password;

}
