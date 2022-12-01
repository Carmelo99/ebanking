package com.ebanking.server.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BillTypeTest {

	BillType bt;
	
	@BeforeEach
	void setUp() throws Exception {
		bt = new BillType();
	}

	@AfterEach
	void tearDown() throws Exception {
		bt = null;
	}

	@Test
	void testSetId() {
		bt.setId(1);
		assertEquals(1, bt.getId());
	}
	
	@Test
	void testSetIdZero() {
		assertThrows(java.lang.RuntimeException.class, ()->bt.setId(0));
	}

	@Test
	void testSetType() {
		bt.setType("prvitip");
		assertEquals("prvitip", bt.getType());
	}
	
	@Test
	void testSetTypeNull() {
		assertThrows(java.lang.NullPointerException.class, ()->bt.setType(null));
	}

	@ParameterizedTest
	@CsvSource ({
		"1,prvitip,1,prvitip,true",
		"1,prvitip,2,prvitip,false",
		"1,prvitip,1,drugitip,false",
		"1,prvitip,2,drugitip,false",
	})
	void testEqualsObject(int id1, String tip1, int id2, String tip2, boolean eq) {
		bt.setId(id1);
		bt.setType(tip1);
		BillType bt2 = new BillType();
		bt2.setId(id2);
		bt2.setType(tip2);
		assertEquals(eq, bt.equals(bt2));
	}

	@Test
	void testToString() {
		bt.setId(1);
		bt.setType("prvitip");
		String s = bt.toString();
		assertTrue(s.contains("1"));
		assertTrue(s.contains("prvitip"));
	}


}
