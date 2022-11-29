package com.ebanking.server.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ebanking.server.model.Credit;
import com.ebanking.server.model.User;

class CreditServiceTest {

	ArrayList<Credit> lista;
	
	Credit c;
	
	@BeforeEach
	void setUp() throws Exception {
		lista = new ArrayList<>();
		c = new Credit();
	}

	@AfterEach
	void tearDown() throws Exception {
		lista = null;
		c = null;
	}

	@Test
	void testGetAllByUserId() {
		User u = new User();
		u.setId(1);
		c.setId(11);
		c.setSender(u);
		lista.add(c);
		assertEquals(1, lista.get(0).getSender().getId());
	}

	@Test
	void testApplyForCredit() {
		User u = new User();
		u.setId(1);
		c.setId(11);
		c.setAmount(25000);
		lista.add(c);
		c.setSender(u);
		lista.set(0, c);
		assertEquals(1, c.getSender().getId());
	}

}
