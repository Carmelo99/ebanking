package com.ebanking.server.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InsuranceTest {
	
	Insurance i;

	@BeforeEach
	void setUp() throws Exception {
		i = new Insurance();
	}

	@AfterEach
	void tearDown() throws Exception {
		i = null;
	}

	@Test
	void testSetCode() {
		i.setCode(1);
		assertEquals(1, i.getCode());
	}

	@Test
	void testSetInsurance_name() {
		i.setInsurance_name("DDOR");
		assertEquals("DDOR", i.getInsurance_name());
	}

	@Test
	void testSetInsurance_type() {
		i.setInsurance_type("Putno osiguranje");
		assertEquals("Putno osiguranje", i.getInsurance_type());
	}

	@Test
	void testSetCompany() {
		InsuranceCompany company = new InsuranceCompany();
		company.setCompany_name("Dunav osiguranje");
		i.setCompany(company);
		assertEquals("Dunav osiguranje", i.getCompany().getCompany_name());
	}

	@ParameterizedTest
	@CsvSource ({
		"123,ime1,123,ime1,true",
		"123,ime1,1233,ime1,false",
		"123,ime1,123,ime11,false",
		"123,ime1,1233,ime11,false",
	})
	void testEqualsObject(int code1, String name1, int code2, String name2, boolean eq) {
		i.setCode(code1);
		i.setInsurance_name(name1);
		Insurance insurance = new Insurance();
		insurance.setCode(code2);
		insurance.setInsurance_name(name2);
		assertEquals(eq, i.equals(insurance));
	}

	@Test
	void testToString() {
		i.setCode(1);
		i.setInsurance_name("DDOR");
		String s = i.toString();
		assertTrue(s.contains("1"));
		assertTrue(s.contains("DDOR"));
	}


}
