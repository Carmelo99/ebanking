package com.ebanking.server.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BillTest {
	
	Bill b;

	@BeforeEach
	void setUp() throws Exception {
		b = new Bill();
	}

	@AfterEach
	void tearDown() throws Exception {
		b = null;
	}

	@Test
	void testSetId() {
		b.setId(1);
		assertEquals(1, b.getId());
	}
	
	@Test
	void testSetIdZero () {
		assertThrows(java.lang.RuntimeException.class, ()->b.setId(0));
	}

	@Test
	void testSetPayment_purpose() {
		b.setPayment_purpose("racun");
		assertEquals("racun", b.getPayment_purpose());
	}
	
	@Test
	void testSetIdPayment_purposeNull () {
		assertThrows(java.lang.NullPointerException.class, ()->b.setPayment_purpose(null));
	}

	@Test
	void testSetReceiver() {
		b.setReceiver("FON");
		assertEquals("FON", b.getReceiver());
	}
	
	@Test
	void testSetReceiverNull () {
		assertThrows(java.lang.NullPointerException.class, ()->b.setReceiver(null));
	}

	@Test
	void testSetType() {
		BillType bt = new BillType();
		bt.setId(1);
		b.setType(bt);
		assertEquals(1, b.getType().getId());
	}
	
	@Test
	void testSetTypeNull () {
		assertThrows(java.lang.NullPointerException.class, ()->b.setType(null));
	}

	@Test
	void testSetAmount() {
		b.setAmount(2500);
		assertEquals(2500, b.getAmount());
	}
	
	@Test
	void testSetAmountNegative () {
		assertThrows(java.lang.RuntimeException.class, ()->b.setAmount(-1000));
	}

	@Test
	void testSetSender() {
		User u = new User();
		u.setId(1);
		b.setSender(u);
		assertEquals(1, b.getSender().getId());
	}
	
	@Test
	void testSetSenderNull () {
		assertThrows(java.lang.NullPointerException.class, ()->b.setSender(null));
	}

	@ParameterizedTest
	@CsvSource ({
		"1,2500,1,2500,true",
		"1,2500,2,2500,false",
		"1,2500,1,3500,false",
		"1,2500,2,3500,false",
	})
	void testEqualsObject(int id1, double amount1, int id2, double amount2, boolean eq) {
		b.setId(id1);
		b.setAmount(amount1);
		Bill b2 = new Bill();
		b2.setId(id2);
		b2.setAmount(amount2);
		assertEquals(eq, b.equals(b2));
	}

	@Test
	void testToString() {
		b.setId(1);
		b.setAmount(2500);
		String s = b.toString();
		assertTrue(s.contains("1"));
		assertTrue(s.contains("2500"));
	}

}
