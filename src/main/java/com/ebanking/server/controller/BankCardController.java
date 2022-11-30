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

import com.ebanking.server.dto.BankCardCreateDto;
import com.ebanking.server.dto.BankCardReadDto;
import com.ebanking.server.dto.BillReadDto;
import com.ebanking.server.dto.CommonResponseDto;
import com.ebanking.server.dto.UserReadDto;
import com.ebanking.server.service.BankCardService;

/**
 * Klasa koja predstavlja kontrolera za klasu BankCard.
 * Ona je zaduzena da prima korisnicke zahteve na adresi localhost:8080/api/bank-card 
 * plus odgovarajuci endpoint u zavisnosti od metode.
 * 
 * @author Antonije
 *
 */
@RestController
@RequestMapping("/api/bank-card")
public class BankCardController {

	@Autowired
	private BankCardService bankCardService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Metoda koja vraca sve kartice za banku.
	 * Metoda koja se poziva kada se primi get zahtev na endpoint-u /get-all.
	 * Poziva metodu klase BankCardService i njen odgovor mapira u odgovarajuci dto.
	 * 
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@GetMapping(path = "/get-all")
	public @ResponseBody ResponseEntity<Object> getAllBankCards() {
		// @formatter:off
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.data(bankCardService.getAllBankCards().stream().map(d -> modelMapper.map(d, BankCardReadDto.class)).collect(Collectors.toList()))
				.build());
		// @formatter:on
	}
	
	/**
	 * Metoda koja vraca sve kartice za banku za prosledjeni id korisnika.
	 * Metoda koja se poziva kada se primi get zahtev na endpoint-u /list.
	 * Poziva metodu klase BankCardService i njen odgovor mapira u odgovarajuci dto.
	 * 
	 * @param userId id korisnika
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@GetMapping(path = "/list")
	public @ResponseBody ResponseEntity<Object> getAllById(
			@RequestParam(name = "user_id") int userId) {
		// @formatter:off
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.data(bankCardService.getAllByUserId(userId).stream().map(d -> modelMapper.map(d, BankCardReadDto.class)).collect(Collectors.toList())).build());
		// @formatter:on
	}
	
	/**
	 * Metoda koja dodeljuje karticu za banku odredjenom korisniku.
	 * Metoda koja se poziva kada se primi patch zahtev na endpoint-u /take-card/{id}/{card}.
	 * 
	 * @param id korisnikov id
	 * @param cardNumber broj kartice
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@PatchMapping(path = "/take-card/{id}/{card}")
	public @ResponseBody ResponseEntity<Object> takeBankCard(
			@PathVariable(name = "id") int id,
			@PathVariable(name="card") int cardNumber
			)  {
		// @formatter:off
		bankCardService.takeBankCard(id,cardNumber);
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.build());
		// @formatter:on
	}
	
	/**
	 * Metoda koja brise karticu iz baze.
	 * Metoda koja se poziva kada se primi delete zahtev na endpoint-u /{id}.
	 * 
	 * @param id korisnikov id
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Object> deleteBankCard(@PathVariable int id) {
		// @formatter:off
		bankCardService.deleteBankCard(id);
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.build());
		// @formatter:on
	}
	
	
}
