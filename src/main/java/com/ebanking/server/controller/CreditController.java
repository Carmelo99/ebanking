package com.ebanking.server.controller;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.server.dto.BillCreateDto;
import com.ebanking.server.dto.BillReadDto;
import com.ebanking.server.dto.CommonResponseDto;
import com.ebanking.server.dto.CreditCreateDto;
import com.ebanking.server.service.CreditService;

/**
 * Klasa koja predstavlja kontrolera za klasu Credit.
 * Ona je zaduzena da prima korisnicke zahteve na adresi localhost:8080/api/credit
 * plus odgovarajuci endpoint u zavisnosti od metode. 
 * 
 * @author Antonije
 *
 */
@RestController
@RequestMapping("/api/credit")
public class CreditController {

	
	@Autowired
	private CreditService creditService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Metoda koja vraca sve kredite za odredjeni id korisnika.
	 * Metoda koja se poziva kada se primi get zahtev na endpoint-u /list.
	 * Poziva metodu klase CreditService i njen odgovor mapira u odgovarajuci dto.
	 * 
	 * @param userId korisnikov id
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@GetMapping(path = "/list")
	public @ResponseBody ResponseEntity<Object> getAll(
			@RequestParam(name = "user_id") int userId) {
		// @formatter:off
		System.out.println(userId);
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.data(creditService.getAllByUserId(userId).stream().map(d -> modelMapper.map(d, BillReadDto.class)).collect(Collectors.toList())).build());
		// @formatter:on
	}
	
	/**
	 * Metoda koja upisuje novi kredit u bazu.
	 * Metoda koja se poziva kada se primi post zahtev na endpoint-u /.
	 * 
	 * 
	 * @param creditCreateDto dto klasa za upis novog racuna u bazu.
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@PostMapping(path = "")
	public @ResponseBody ResponseEntity<Object> payBill(
			@RequestBody CreditCreateDto creditCreateDto
			){
			// @formatter:off
			return ResponseEntity.ok(CommonResponseDto.builder()
			.code(Integer.valueOf(HttpStatus.OK.value()))
			.message(HttpStatus.OK.getReasonPhrase())
			.data(creditService.applyForCredit(creditCreateDto))
			.build());
			// @formatter:on
	}
	
	
	
	
	
}
