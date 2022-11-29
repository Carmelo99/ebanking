package com.ebanking.server.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CreditTypeTest {

	CreditType ct;
	
	@BeforeEach
	void setUp() throws Exception {
		ct = new CreditType();
	}

	@AfterEach
	void tearDown() throws Exception {
		ct = null;
	}

	@Test
	void testSetId() {
		ct.setId(1);
		assertEquals(1, ct.getId());
	}

	@Test
	void testSetType() {
		ct.setType("10 godina");
		assertEquals("10 godina", ct.getType());
	}

	@ParameterizedTest
	@CsvSource ({
		"1,10_godina,1,10_godina,true",
		"1,10_godina,2,10_godina,false",
		"1,10_godina,1,20_godina,false",
		"1,10_godina,2,20_godina,false",
	})
	void testEqualsObject(int id1, String type1, int id2, String type2, boolean eq) {
		ct.setId(id1);
		ct.setType(type1);
		CreditType ct2 = new CreditType();
		ct2.setId(id2);
		ct.setType(type2);
		assertEquals(eq, ct.equals(ct2));
	}

	@Test
	void testToString() {
		ct.setId(1);
		ct.setType("10 godina");
		String s = ct.toString();
		assertTrue(s.contains("1"));
		assertTrue(s.contains("10 godina"));
	}

}
