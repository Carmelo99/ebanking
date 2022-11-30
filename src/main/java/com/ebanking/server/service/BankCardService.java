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

/**
 * Klasa koja predstavlja servis za klasu BankCard.
 * Ona obradjuje zahteve prosledjene iz kontrolera BankCard.
 * 
 * @author Antonije
 *
 */
@Service
public class BankCardService {

	@Autowired
	private BankCardRepository bankCardRepository;

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Poziva metodu BankCardRepository i vraca listu kartica po zadatom id-u korisnika.
	 * 
	 * @param userId id korisnika
	 * @return ArrayList<BankCard> lista kartica
	 */
	public ArrayList<BankCard> getAllByUserId(int userId) {
		return bankCardRepository.getAllByUserId(userId);
	}

	/**
	 * Dodeljuje karticu korisniku u bazi na osnovu id korisnika i broja kartice
	 * 
	 * @param userId id korisnika
	 * @param cardNumber broj kartice
	 */
	public void takeBankCard(int userId, int cardNumber) {
		
		User user  = userRepository.getUserById(userId);
		
		
		BankCard bankCard = bankCardRepository.getByCardNumber(cardNumber);
		
		bankCard.setCard_owner(user);
		
		bankCardRepository.save(bankCard);
		
	}

	/**
	 * Poziva metodu BankCardRepository i vraca listu svih kartica.
	 * 
	 * @return ArrayList<BankCard> lista kartica
	 */
	public ArrayList<BankCard> getAllBankCards() {
		
		return bankCardRepository.getAllBankCards();
		
	}

	/**
	 * Brise karticu iz baze po id-u kartice.
	 * 
	 * @param id id kartice
	 */
	public void deleteBankCard(int id) {
		
		BankCard bk = bankCardRepository.getBankCardById(id);
		
		
		bankCardRepository.delete(bk);
		
	}
	
	
	
	
}
