package com.ebanking.server.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserTest {

	User u;
	
	@BeforeEach
	void setUp() throws Exception {
		u = new User();
	}

	@AfterEach
	void tearDown() throws Exception {
		u = null;
	}


	@Test
	void testSetId() {
		u.setId(123);
		assertEquals(123, u.getId());
	}
	
	@Test
	void testSetIdZero() {
		assertThrows(java.lang.RuntimeException.class, ()->u.setId(0));
	}

	@Test
	void testSetFirstname() {
		u.setFirstname("Lazar");
		assertEquals("Lazar", u.getFirstname());
	}
	
	@Test
	void testSetFirstnameNull() {
		assertThrows(java.lang.NullPointerException.class, ()->u.setFirstname(null));
	}

	@Test
	void testSetLastname() {
		u.setLastname("Radosavljevic");
		assertEquals("Radosavljevic", u.getLastname());
	}
	
	@Test
	void testSetLastnameNull() {
		assertThrows(java.lang.NullPointerException.class, ()->u.setLastname(null));
	}

	@Test
	void testSetUsername() {
		u.setUsername("admin");
		assertEquals("admin", u.getUsername());
	}
	
	@Test
	void testSetUsernameNull() {
		assertThrows(java.lang.NullPointerException.class, ()->u.setUsername(null));
	}

	@Test
	void testSetPassword() {
		u.setPassword("admin");
		assertEquals("admin", u.getPassword());
	}
	
	@Test
	void testSetPasswordNull() {
		assertThrows(java.lang.NullPointerException.class, ()->u.setPassword(null));
	}

	@Test
	void testSetAge() {
		u.setAge(25);
		assertEquals(25, u.getAge());
	}
	
	@Test
	void testSetAgeNegative() {
		assertThrows(java.lang.RuntimeException.class, ()->u.setAge(-29));
	}

	@Test
	void testSetMarital_status() {
		u.setMarital_status("single");
		assertEquals("single", u.getMarital_status());
	}
	
	@Test
	void testSetMarital_statusNull() {
		assertThrows(java.lang.NullPointerException.class, ()->u.setMarital_status(null));
	}

	@Test
	void testSetEmployed() {
		u.setEmployed(false);
		assertEquals(false, u.isEmployed());
	}

	@Test
	void testSetMonthly_income() {
		u.setMonthly_income(2500);
		assertEquals(2500, u.getMonthly_income());
	}
	
	@Test
	void testSetMonthly_incomeNegative() {
		assertThrows(java.lang.RuntimeException.class, ()->u.setMonthly_income(-20000));
	}

	@Test
	void testSetAdmin() {
		u.setAdmin(false);
		assertEquals(false, u.isAdmin());
	}

	@Test
	void testSetAmountNegative() {
		assertThrows(java.lang.RuntimeException.class, ()->u.setAmount(-1000000));
	}
	
	@Test
	void testSetAmount() {
		u.setAmount(233.33);
		assertEquals(233.33, u.getAmount());
	}

	@Test
	void testSetInsurance_numberNull() {
		assertThrows(java.lang.NullPointerException.class, ()->u.setInsurance_number(null));
	}
	
	@Test
	void testSetInsurance_number() {
		Insurance i = new Insurance();
		i.setCode(123);
		u.setInsurance_number(i);
		assertEquals(123, u.getInsurance_number().getCode());
	}

	@ParameterizedTest
	@CsvSource ({
		"Steph, Curry, Steph, Curry, true",
		"Steph, Curry, Stephen, Curry, false",
		"Steph, Curry, Steph, James, false",
		"Steph, Curry, LeBron, James, false",
	})
	void testEqualsObject(String firstname1, String lastname1, String firstname2, String lastname2, boolean eq) {
		u.setFirstname(firstname1);
		u.setLastname(lastname1);
		User user = new User();
		user.setFirstname(firstname2);
		user.setLastname(lastname2);
		
		assertEquals(eq,u.equals(user));
	}


	@Test
	void testToString() {
		u.setUsername("admin");
		u.setPassword("admin123");
		String s = u.toString();
		assertTrue(s.contains("admin"));
		assertTrue(s.contains("admin123"));
	}

}
