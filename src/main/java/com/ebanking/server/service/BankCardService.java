package com.ebanking.server.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.server.dto.BankCardCreateDto;
import com.ebanking.server.model.BankCard;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.BankCardRepository;
import com.ebanking.server.repository.UserRepository;

@Service
public class BankCardService {

	@Autowired
	private BankCardRepository bankCardRepository;

	@Autowired
	private UserRepository userRepository;
	
	public ArrayList<BankCard> getAllByUserId(int userId) {
		return bankCardRepository.getAllByUserId(userId);
	}

	public void takeBankCard(int userId, int cardNumber) {
		
		User user  = userRepository.getUserById(userId);
		
		
		BankCard bankCard = bankCardRepository.getByCardNumber(cardNumber);
		
		bankCard.setCard_owner(user);
		
		bankCardRepository.save(bankCard);
		
	}

	public ArrayList<BankCard> getAllBankCards() {
		
		return bankCardRepository.getAllBankCards();
		
	}

	public void deleteBankCard(int id) {
		
		BankCard bk = bankCardRepository.getBankCardById(id);
		
		
		bankCardRepository.delete(bk);
		
	}
	
	
	
	
}
