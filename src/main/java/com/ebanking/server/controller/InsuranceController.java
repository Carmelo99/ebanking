package com.ebanking.server.controller;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.server.dto.BankCardReadDto;
import com.ebanking.server.dto.BillReadDto;
import com.ebanking.server.dto.CommonResponseDto;
import com.ebanking.server.dto.CreditCreateDto;
import com.ebanking.server.dto.InsuranceReadDto;
import com.ebanking.server.model.Insurance;
import com.ebanking.server.service.InsuranceService;

/**
 * Klasa koja predstavlja kontrolera za klasu Insurance.
 * Ona je zaduzena da prima korisnicke zahteve na adresi localhost:8080/api/insurance 
 * plus odgovarajuci endpoint u zavisnosti od metode. 
 * 
 * @author Antonije
 *
 */
@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {

	@Autowired
	private InsuranceService insuranceService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Metoda koja vraca sva osiguranja.
	 * Metoda koja se poziva kada se primi get zahtev na endpoint-u /get-all.
	 * Poziva metodu klase InsuranceService i njen odgovor mapira u odgovarajuci dto.
	 * 
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@GetMapping(path = "/get-all")
	public @ResponseBody ResponseEntity<Object> getAllInsurances() {
		// @formatter:off
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.data(insuranceService.getAllInsurances().stream().map(d -> modelMapper.map(d, InsuranceReadDto.class)).collect(Collectors.toList()))
				.build());
		// @formatter:on
	}
	
	/**
	 * Metoda koja vraca sva osiguranja za prosledjeni id korisnika.
	 * Metoda koja se poziva kada se primi get zahtev na endpoint-u /list.
	 * Poziva metodu klase InsuranceService i njen odgovor mapira u odgovarajuci dto.
	 * 
	 * @param userId id korisnika 
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@GetMapping(path = "/list")
	public @ResponseBody ResponseEntity<Object> getAllByUserId(
			@RequestParam(name = "user_id") int userId) {
		// @formatter:off
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.data(insuranceService.getAllByUserId(userId).stream().map(d -> modelMapper.map(d, InsuranceReadDto.class)).collect(Collectors.toList())).build());
		// @formatter:on
	}
	
	/**
	 * Metoda koja dodeljuje osiguranje odredjenom korisniku koji je izabrao to osiguranje.
	 * Metoda koja se poziva kada se primi patch zahtev na endpoint-u /take-insurance/{id}/{code}.
	 * 
	 * @param id id korisnika
	 * @param code sifra osiguranja
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@PatchMapping(path = "/take-insurance/{id}/{code}")
	public @ResponseBody ResponseEntity<Object> takeInsurance(
			@PathVariable(name = "id") int id,
			@PathVariable(name="code") int code
			)  {
		// @formatter:off
		insuranceService.takeInsurance(id,code);
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.build());
		// @formatter:on
	}
	
	/**
	 * Metoda koja brise osiguranje korisnika sa id-om koji je prosledjen.
	 * Metoda koja se poziva kada se primi delete zahtev na endpoint-u /{id}.
	 * 
	 * @param id broj kartice
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Object> deleteInsurance(@PathVariable int id) {
		// @formatter:off
		insuranceService.deleteUserInsurance(id);
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.build());
		// @formatter:on
	}
	
	
}
