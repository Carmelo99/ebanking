package com.ebanking.server.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.server.model.Credit;
import com.ebanking.server.repository.CreditRepository;

@Service
public class CreditService {

	@Autowired
	private CreditRepository creditRepository;

	public ArrayList<Credit> getAllByUserId(int userId) {
		return creditRepository.getAllByUserId(userId);
	}
	
}
