package com.ebanking.server.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ebanking.server.model.BankCard;
import com.ebanking.server.model.User;


class BankCardServiceTest {
	

	
	ArrayList<BankCard> lista;
	
	BankCard bc;

	@BeforeEach
	void setUp() throws Exception {
		lista = new ArrayList<>();
		bc = new BankCard();
	}

	@AfterEach
	void tearDown() throws Exception {
		lista = null;
		bc = null;
	}

	@Test
	void testGetAllByUserId() {
		User u = new User();
		u.setId(1);
		bc.setCard_number(1);
		bc.setCard_owner(u);
		lista.add(bc);
		assertEquals(1, lista.get(0).getCard_owner().getId());
	}

	@Test
	void testTakeBankCard() {
		User u = new User();
		u.setId(1);
		bc.setCard_number(123);
		bc.setCard_type("tip1");
		lista.add(bc);
		bc.setCard_owner(u);
		lista.set(0, bc);
		assertEquals(1, bc.getCard_owner().getId());
	}

	@Test
	void testGetAllBankCards() {
		bc.setCard_number(1);
		bc.setCard_type("tip1");
		BankCard bc2 = new BankCard();
		bc2.setCard_number(2);
		bc2.setCard_type("tip2");
		lista.add(bc);
		lista.add(bc2);
		assertEquals("tip1", lista.get(0).getCard_type());
		assertEquals("tip2", lista.get(1).getCard_type());
	}

	@Test
	void testDeleteBankCard() {
		bc.setCard_number(1);
		bc.setCard_type("tip1");
		lista.add(bc);
		lista.remove(0);
		assertEquals(0, lista.size());
	}

}
