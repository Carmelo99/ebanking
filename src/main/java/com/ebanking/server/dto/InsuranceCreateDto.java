package com.ebanking.server.dto;

import com.ebanking.server.model.InsuranceCompany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsuranceCreateDto {

	private String insurance_name;
	
	private String insurance_type;
	
	private InsuranceCompany company;
	
	
}
