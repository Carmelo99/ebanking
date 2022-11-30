package com.ebanking.server.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

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
import com.ebanking.server.model.Bill;
import com.ebanking.server.service.BillService;

/**
 * Klasa koja predstavlja kontrolera za klasu Bill.
 * Ona je zaduzena da prima korisnicke zahteve na adresi localhost:8080/api/bill 
 * plus odgovarajuci endpoint u zavisnosti od metode.
 * 
 * @author Antonije
 *
 */
@RestController
@RequestMapping("/api/bill")
public class BillController {

	@Autowired
	private BillService billService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Metoda koja vraca sve racune za odredjeni id korisnika.
	 * Metoda koja se poziva kada se primi get zahtev na endpoint-u /list.
	 * Poziva metodu klase BillService i njen odgovor mapira u odgovarajuci dto.
	 * 
	 * @param userId korisnikov id
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@GetMapping(path = "/list")
	public @ResponseBody ResponseEntity<Object> getAll(
			@RequestParam(name = "user_id") int userId) {
		// @formatter:off
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.data(billService.getAllByUserId(userId).stream().map(d -> modelMapper.map(d, BillReadDto.class)).collect(Collectors.toList())).build());
		// @formatter:on
	}
	
	/**
	 * Metoda koja upisuje novi racun u bazu.
	 * Metoda koja se poziva kada se primi post zahtev na endpoint-u /.
	 * 
	 * @param billCreateDto dto klasa za upis novog racuna u bazu.
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@PostMapping(path = "")
	public @ResponseBody ResponseEntity<Object> payBill(
			@RequestBody BillCreateDto billCreateDto
			){
			// @formatter:off
			return ResponseEntity.ok(CommonResponseDto.builder()
			.code(Integer.valueOf(HttpStatus.OK.value()))
			.message(HttpStatus.OK.getReasonPhrase())
			.data(billService.payBill(billCreateDto))
			.build());
			// @formatter:on
	}
	
	
}
