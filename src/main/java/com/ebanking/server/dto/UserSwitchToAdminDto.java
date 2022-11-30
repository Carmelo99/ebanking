package com.ebanking.server.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;

/**
 * Klasa koja se koristi prilikom operacije dodele/oduzimanja admin uloge korisniku.
 * 
 * @author Antonije
 *
 */
@Getter
public class UserSwitchToAdminDto {
	
	/**
	 * Id korisnika kao integer.
	 */
	private int id;
	
	/**
	 * Da li je korisnik admin kao boolean.
	 */
	private boolean admin;
	

}
