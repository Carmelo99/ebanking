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

import com.ebanking.server.dto.CommonResponseDto;
import com.ebanking.server.dto.UserCreateDto;
import com.ebanking.server.dto.UserReadDto;
import com.ebanking.server.model.User;
import com.ebanking.server.service.UserService;


@RestController
@RequestMapping("/api")
public class PublicController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private ModelMapper modelMapper;
	

	
	//public @ResponseBody ResponseEntity<Object> login(@RequestBody UserCreateDto userCreateDto) {
		@CrossOrigin
		@PostMapping(path="/authenticate")
		public @ResponseBody ResponseEntity<Object> logUser(@RequestBody UserCreateDto userCreateDto) {
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Access-Control-Allow-Origin", "Access-Control-Allow-Origin");
//		return ResponseEntity.ok(CommonResponseDto.builder()
//				.code(Integer.valueOf(HttpStatus.OK.value()))
//				.message(HttpStatus.OK.getReasonPhrase())
//				.data(userService.login(userCreateDto.getUsername(), userCreateDto.getPassword()))
//				.build());
//		return userService.login(userCreateDto.getUsername(),userCreateDto.getPassword());
		return ResponseEntity.ok().body(userService.login(userCreateDto.getUsername(),userCreateDto.getPassword()));
//		return ResponseEntity.ok(CommonResponseDto.builder()
//				.code(Integer.valueOf(HttpStatus.OK.value()))
//				.message(HttpStatus.OK.getReasonPhrase())
//				.data(modelMapper.map(userService.login(modelMapper.map(userCreateDto, User.class)), UserReadDto.class))
//				.build());

		//return userService.login(username,password);
		
		
	}

}
