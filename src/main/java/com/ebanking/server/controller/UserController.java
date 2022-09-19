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
	
//	@PatchMapping(path = "/switchIsAdmin")
//	public void switchStatus(
//			@RequestBody UserSwitchToAdminDto userDto)  {
//		userService.switchIsAdmin(userDto.getId(),userDto.isAdmin());
//	}
	
	
	@DeleteMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<Object> deleteWord(@PathVariable int id) {
		// @formatter:off
		userService.delete(id);
		return ResponseEntity.ok(CommonResponseDto.builder()
				.code(Integer.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.getReasonPhrase())
				.build());
		// @formatter:on
	}
	
	
	
	
	
	
}
