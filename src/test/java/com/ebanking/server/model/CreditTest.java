package com.ebanking.server.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CreditTest {
	
	Credit credit;

	@BeforeEach
	void setUp() throws Exception {
		credit = new Credit();
	}

	@AfterEach
	void tearDown() throws Exception {
		credit = null;
	}

	@Test
	void testSetId() {
		credit.setId(1);
		assertEquals(1, credit.getId());
	}
	
	@Test
	void testSetIdZero() {
		assertThrows(java.lang.RuntimeException.class, ()->credit.setId(0));
	}

	@Test
	void testSetType() {
		CreditType ct = new CreditType();
		ct.setId(1);
		credit.setType(ct);
		assertEquals(1, credit.getType().getId());
	}
	
	@Test
	void testSetTypeNull() {
		assertThrows(java.lang.NullPointerException.class, ()->credit.setType(null));
	}

	@Test
	void testSetAmount() {
		credit.setAmount(25000);
		assertEquals(25000, credit.getAmount());
	}
	
	@Test
	void testSetAmountNegative() {
		assertThrows(java.lang.RuntimeException.class, ()->credit.setAmount(-20000));
	}

	@Test
	void testSetSender() {
		User u = new User();
		u.setId(1);
		credit.setSender(u);
		assertEquals(1, credit.getSender().getId());
	}

	@Test
	void testSetSenderNull() {
		assertThrows(java.lang.NullPointerException.class, ()->credit.setSender(null));
	}
	
	@ParameterizedTest
	@CsvSource ({
		"1,2500,1,2500,true",
		"1,2500,2,2500,false",
		"1,2500,1,300,false",
		"1,2500,2,300,false",
	})
	void testEqualsObject(int id1, double amount1, int id2, double amount2, boolean eq) {
		credit.setId(id1);
		credit.setAmount(amount1);
		Credit credit2 = new Credit();
		credit2.setId(id2);
		credit2.setAmount(amount2);
		assertEquals(eq, credit.equals(credit2));
	}

	@Test
	void testToString() {
		credit.setId(1);
		credit.setAmount(2500);
		String s = credit.toString();
		assertTrue(s.contains("1"));
		assertTrue(s.contains("2500"));
	}

}
