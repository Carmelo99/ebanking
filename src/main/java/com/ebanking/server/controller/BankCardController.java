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

@RestController
@RequestMapping("/api/bank-card")
public class BankCardController {

	@Autowired
	private BankCardService bankCardService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
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
