package com.ebanking.server.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {

	
	@NotBlank
	private String username;

	@NotBlank
	private String password;

}
