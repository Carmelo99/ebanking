package com.ebanking.server.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InsuranceCompanyTest {

	InsuranceCompany ic;
	
	@BeforeEach
	void setUp() throws Exception {
		ic = new InsuranceCompany();
	}

	@AfterEach
	void tearDown() throws Exception {
		ic = null;
	}


	@Test
	void testSetTin() {
		ic.setTin(1233);
		assertEquals(1233, ic.getTin());
	}

	@Test
	void testSetCompany_name() {
		ic.setCompany_name("Kompanija 1");
		assertEquals("Kompanija 1", ic.getCompany_name());
	}

	@ParameterizedTest
	@CsvSource ({
		"123,kompanija,123,kompanija,true",
		"123,kompanija,1233,kompanija,false",
		"123,kompanija,123,kompanija1,false",
		"123,kompanija,1233,kompanija1,false",
	})
	void testEqualsObject(int tin1, String name1, int tin2, String name2,boolean eq) {
		ic.setTin(tin1);
		ic.setCompany_name(name1);
		InsuranceCompany ic2 = new InsuranceCompany();
		ic2.setTin(tin2);
		ic2.setCompany_name(name2);
		
		assertEquals(eq, ic.equals(ic2));
		
	}


	@Test
	void testToString() {
		ic.setTin(123);
		ic.setCompany_name("Kompanija 1");
		String s = ic.toString();
		assertTrue(s.contains("123"));
		assertTrue(s.contains("Kompanija 1"));
	}


}
