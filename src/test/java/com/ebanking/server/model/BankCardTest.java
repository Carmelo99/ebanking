package com.ebanking.server.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BankCardTest {

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
	void testSetCard_number() {
		bc.setCard_number(255);
		assertEquals(255, bc.getCard_number());
	}

	@Test
	void testSetCard_type() {
		bc.setCard_type("kreditna");
		assertEquals("kreditna", bc.getCard_type());
	}	

	@Test
	void testSetCard_owner() {
		User u = new User();
		u.setId(111);
		bc.setCard_owner(u);
		assertEquals(111, bc.getCard_owner().getId());
	}

	@ParameterizedTest
	@CsvSource ({
		"1,kreditna,1,kreditna,true",
		"1,kreditna,2,kreditna,false",
		"1,kreditna,1,debitna,false",
		"1,kreditna,2,debitna,false",
	})
	void testEqualsObject(int broj1,String tip1, int broj2, String tip2, boolean eq) {
		bc.setCard_number(broj1);
		bc.setCard_type(tip1);
		BankCard bc2 = new BankCard();
		bc2.setCard_number(broj2);
		bc2.setCard_type(tip2);
		assertEquals(eq, bc.equals(bc2));
	}

	@Test
	void testToString() {
		bc.setCard_number(255);
		bc.setCard_type("kreditna");
		String s = bc.toString();
		assertTrue(s.contains("255"));
		assertTrue(s.contains("kreditna"));
	}

}
