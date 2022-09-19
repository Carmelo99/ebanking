package com.ebanking.server.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class UserSwitchToAdminDto {
	
	private int id;
	
	private boolean admin;
	

}
