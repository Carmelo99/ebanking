package com.ebanking.server.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponseDto implements Serializable {

	private static final long serialVersionUID = -1807805111367622618L;

	private UserReadDto user;
}
