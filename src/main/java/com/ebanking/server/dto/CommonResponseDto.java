package com.ebanking.server.dto;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

/**
 * Klasa koja predstavlja genericki odgovor ka klijentskom delu aplikacije.
 * 
 * @author Antonije
 *
 * @param <T>
 */
@Data
@Builder
public class CommonResponseDto<T> {

	/**
	 * Vreme odgovora koje se postavlja na trenutno vreme.
	 */
	@Builder.Default
	private Instant timestamp = Instant.now();

	/**
	 * Sifra odgovora kao Integer.
	 */
	private Integer code;

	/**
	 * Poruka odgovora kao String.
	 */
	private String message;

	/**
	 * Genericki deo koji se razlikuje u svakom od response-a kijentu.
	 */
	private T data;

}