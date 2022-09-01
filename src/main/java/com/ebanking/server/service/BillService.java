package com.ebanking.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.server.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;
	
}
