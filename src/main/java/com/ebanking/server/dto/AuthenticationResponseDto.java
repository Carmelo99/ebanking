package com.ebanking.server.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Klasa koja se koristi za autentikaciju korisnika.
 * 
 * 
 * @author Antonije
 *
 */
@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponseDto implements Serializable {

	/**
	 * Jedinstveni broj klase koji se automatski generise.
	 */
	private static final long serialVersionUID = -1807805111367622618L;

	/**
	 * Korisnik u formi klase UserReadDto.
	 * Predstavlja spoljni kljuc ka dto UserReadDto.
	 */
	private UserReadDto user;
}
