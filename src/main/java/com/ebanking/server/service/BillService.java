package com.ebanking.server.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.server.dto.BillCreateDto;
import com.ebanking.server.model.Bill;
import com.ebanking.server.model.BillType;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.BillRepository;
import com.ebanking.server.repository.BillTypeRepository;
import com.ebanking.server.repository.UserRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private BillTypeRepository billTypeRepository;
	
	@Autowired
	private UserRepository userRepository;

	public ArrayList<Bill> getAllByUserId(int userId) {
		return billRepository.getAllByUserId(userId);
	}

	public BillCreateDto payBill(BillCreateDto billCreateDto)  {
		
		try {
		BillType billType = billTypeRepository.getBillTypeByType(billCreateDto.getType());
		
		
		Optional<User> user = userRepository.findById(billCreateDto.getUser_id());

		Bill newBill = new Bill();
		System.out.println(billCreateDto.getType()+" "+billCreateDto.getAmount()+" "+billCreateDto.getUser_id()+" "+billCreateDto.getPayment_purpose()+ " "+ billCreateDto.getReceiver());
		newBill.setPayment_purpose(billCreateDto.getPayment_purpose());
		newBill.setReceiver(billCreateDto.getReceiver());
		newBill.setType(billType);
		newBill.setAmount(billCreateDto.getAmount());
		newBill.setSender(user.get());

		billRepository.save(newBill);
		
		return billCreateDto;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return null;
	}
	
	
	
}
