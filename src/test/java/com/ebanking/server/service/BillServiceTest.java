package com.ebanking.server.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ebanking.server.model.Bill;
import com.ebanking.server.model.User;

class BillServiceTest {

	ArrayList<Bill> lista;
	
	Bill b;
	
	@BeforeEach
	void setUp() throws Exception {
		lista = new ArrayList<>();
		b = new Bill();
	}

	@AfterEach
	void tearDown() throws Exception {
		lista = null;
		b = null;
	}

	@Test
	void testGetAllByUserId() {
		User u = new User();
		u.setId(1);
		b.setId(1);
		b.setPayment_purpose("racun");
		b.setSender(u);
		lista.add(b);
		assertEquals(1, lista.get(0).getSender().getId());
	}

	@Test
	void testPayBill() {
		User u = new User();
		u.setId(1);
		b.setId(111);
		b.setPayment_purpose("racun");
		lista.add(b);
		b.setSender(u);
		lista.set(0, b);
		assertEquals(1, b.getSender().getId());
	}

}
