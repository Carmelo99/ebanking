package com.ebanking.server.controller;

import java.awt.PageAttributes.MediaType;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.server.dto.UserReadDto;
import com.ebanking.server.dto.UserSwitchToAdminDto;
import com.ebanking.server.dto.CommonResponseDto;
import com.ebanking.server.model.User;
import com.ebanking.server.service.UserService;

/**
 * Klasa koja predstavlja kontrolera za klasu User.
 * Ona je zaduzena da prima korisnicke zahteve na adresi localhost:8080/api/users
 * plus odgovarajuci endpoint u zavisnosti od metode.
 * 
 * @author Antonije
 *
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
//	@PostMapping(path="/login")
//	public @ResponseBody User login(@RequestParam(name="username") String username, 
//			@RequestParam(name="password") String password) {
//		
//		return userService.login(username,password);
//	}
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * Metoda koja vraca sve korisnike.
	 * Metoda koja se poziva kada se primi get zahtev na endpoint-u /list.
	 * Poziva metodu klase UserService i njen odgovor mapira u odgovarajuci dto.
	 * 
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@GetMapping(path = "/list")
	public @ResponseBody ResponseEntity<Object> getAllUsers() {
		// @formatter:off
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.data(userService.getAllUsers().stream().map(d -> modelMapper.map(d, UserReadDto.class)).collect(Collectors.toList()))
				.build());
		// @formatter:on
	}
	
	/**
	 * Metoda koja dodeljuje ili oduzima admin ulogu odredjenom korisniku.
	 * Metoda koja se poziva kada se primi patch zahtev na endpoint-u /switchisadmin/{id}/{isadmin}.
	 * 
	 * @param id id korisnika
	 * @param isadmin true/false vrednost u zavisnosti od toga da li se dodeljuje ili oduzima admin uloga.
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@PatchMapping(path = "/switchisadmin/{id}/{isadmin}")
	public @ResponseBody ResponseEntity<Object> switchStatus(
			@PathVariable(name = "id") int id,
			@PathVariable(name="isadmin") boolean isadmin
			//@RequestBody UserSwitchToAdminDto userDto
			)  {
		// @formatter:off
		userService.switchIsAdmin(id,isadmin);
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.build());
		// @formatter:on
	}
	
	/**
	 * Metoda koja sluzi za transfer novca sa jednog korisnika na drugog.
	 * Metoda koja se poziva kada se primi patch zahtev na endpoint-u /transfer-money/{firstname}/{lastname}/{amount}/{user_id}.
	 * 
	 * @param firstname ime korisnika kome ce se preneti novac
	 * @param lastname prezime korisnika kome ce se preneti novac
	 * @param amount iznos koji ce se preneti
	 * @param id id korisnika koji salje novac
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@PatchMapping(path = "/transfer-money/{firstname}/{lastname}/{amount}/{user_id}")
	public @ResponseBody ResponseEntity<Object> transferMoney(
			@PathVariable(name = "firstname") String firstname,
			@PathVariable(name="lastname") String lastname,
			@PathVariable(name="amount") double amount,
			@PathVariable(name="user_id") int id
			)  {
		// @formatter:off
		userService.transferMoney(firstname,lastname,amount,id);
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.build());
		// @formatter:on
	}
	
//	@PatchMapping(path = "/switchIsAdmin")
//	public void switchStatus(
//			@RequestBody UserSwitchToAdminDto userDto)  {
//		userService.switchIsAdmin(userDto.getId(),userDto.isAdmin());
//	}
	
	/**
	 * Metoda koja brise korisnika iz baze.
	 * Metoda koja se poziva kada se primi delete zahtev na endpoint-u /{id}.
	 * 
	 * @param id id korisnika koji se brise
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Object> deleteUser(@PathVariable int id) {
		// @formatter:off
		userService.delete(id);
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.build());
		// @formatter:on
	}
	
	
	
	
	
	
}
