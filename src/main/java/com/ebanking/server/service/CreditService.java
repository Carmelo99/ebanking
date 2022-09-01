package com.ebanking.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.server.repository.CreditRepository;

@Service
public class CreditService {

	@Autowired
	private CreditRepository creditRepository;
	
}
