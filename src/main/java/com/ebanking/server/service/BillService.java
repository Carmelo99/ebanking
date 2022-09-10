package com.ebanking.server.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.server.model.Bill;
import com.ebanking.server.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	public ArrayList<Bill> getAllByUserId(int userId) {
		return billRepository.getAllByUserId(userId);
	}
	
	
	
}
