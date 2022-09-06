package com.ebanking.server.dto;

import java.time.Instant;
import java.util.LinkedHashSet;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonResponseDto<T> {

	@Builder.Default
	private Instant timestamp = Instant.now();

	private Integer code;

	private String message;

	private T data;

}