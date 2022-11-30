package com.ebanking.server.controller;




import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.server.dto.AuthenticationResponseDto;
import com.ebanking.server.dto.CommonResponseDto;
import com.ebanking.server.dto.UserCreateDto;
import com.ebanking.server.dto.UserReadDto;
import com.ebanking.server.model.User;
import com.ebanking.server.service.UserService;

/**
 * Klasa koja predstavlja javnog kontrolera.
 * Ona sluzi prilikom prijave i odljavljivanja korisnika iz aplikacije.
 * Ona je zaduzena da prima korisnicke zahteve na adresi localhost:8080/api 
 * plus odgovarajuci endpoint u zavisnosti od metode.
 * 
 * 
 * @author Antonije
 *
 */
@RestController
@RequestMapping("/api")
public class PublicController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	

	/**
	 * Metoda koja prijavljuje korisnika u sistem.
	 * Metoda koja se poziva kada se primi get zahtev na endpoint-u /authenticate.
	 * Poziva metodu klase UserService i vraca AuthenticationResponseDto enkapsuliran u serverski odgovor.
	 * 
	 * @param userCreateDto dto koji sadrzi username i password prosledjenog korisnika.
	 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
	 */
		@CrossOrigin
		@PostMapping(path="/authenticate")
		public @ResponseBody ResponseEntity<Object> logUser(@RequestBody UserCreateDto userCreateDto) {
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Access-Control-Allow-Origin", "Access-Control-Allow-Origin");
	    User user =userService.login(userCreateDto.getUsername(), userCreateDto.getPassword());
	    UserReadDto userReadDto = userService.getUserReadDto(user);
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.data(new AuthenticationResponseDto(userReadDto))
				.build());
//		return userService.login(userCreateDto.getUsername(),userCreateDto.getPassword());
//		return ResponseEntity.ok().body(userService.login(userCreateDto.getUsername(),userCreateDto.getPassword()));
//		return ResponseEntity.ok(CommonResponseDto.builder()
//				.code(Integer.valueOf(HttpStatus.OK.value()))
//				.message(HttpStatus.OK.getReasonPhrase())
//				.data(modelMapper.map(userService.login(modelMapper.map(userCreateDto, User.class)), UserReadDto.class))
//				.build());

		//return userService.login(username,password);
		
		
		
	}
		
		/**
		 * Metoda koja odljavljuje korisnika sa sistema.
		 * Ukoliko prodje klijentski zahtev, vraca uspesan odgovor i http status 200 OK.
		 * 
		 * @return ResponseEntity genericku klasu, koja predstavlja omotac klasu za serverski odgovor.
		 */
		@PostMapping(path = "/logout")
		public @ResponseBody ResponseEntity<Object> logout() {

			// @formatter:off
			return ResponseEntity.ok(CommonResponseDto.builder()
					.code(Integer.valueOf(HttpStatus.OK.value()))
					.message(HttpStatus.OK.getReasonPhrase())
					.data(Boolean.TRUE)
					.build());
			// @formatter:on
		}

}
