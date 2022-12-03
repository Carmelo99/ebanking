package com.ebanking.server.service;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebanking.server.model.BankCard;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.BankCardRepository;
import com.ebanking.server.repository.UserRepository;

@SpringBootTest
class BankCardServiceTest {
	
	@Autowired
    private BankCardRepository bankCardRepository;

	@Autowired
    private UserRepository userRepository;
	
	BankCard bc;

	@BeforeEach
	void setUp() throws Exception {
		bc = new BankCard();
	}

	@AfterEach
	void tearDown() throws Exception {
		bc = null;
	}

	@Test
	void testGetAllByUserId() {
		User u = new User();
		u.setId(1);
		assertEquals(4, bankCardRepository.getAllByUserId(u.getId()).size());
	}

	@Test
	void testTakeBankCard() {
		User u = userRepository.getUserById(1);
		bc = bankCardRepository.getByCardNumber(123422);
		bc.setCard_owner(u);
		assertEquals(1, bc.getCard_owner().getId());
	}
	

	@Test
	void testGetAllBankCards() {
		assertEquals(4, bankCardRepository.getAllBankCards().size());
	}

	@Test
	void testDeleteBankCard() {
		bc = bankCardRepository.getByCardNumber(123422);
		assertEquals(123422, bc.getCard_number());
	}

}
