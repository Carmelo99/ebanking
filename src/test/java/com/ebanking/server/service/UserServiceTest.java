package com.ebanking.server.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ebanking.server.dto.UserReadDto;
import com.ebanking.server.model.BankCard;
import com.ebanking.server.model.User;

class UserServiceTest {

	ArrayList<User> lista;
	
	User u;
	
	@BeforeEach
	void setUp() throws Exception {
		lista = new ArrayList<>();
		u = new User();
	}

	@AfterEach
	void tearDown() throws Exception {
		lista = null;
		u = null;
	}

	@Test
	void testLogin() {
		u.setUsername("admin");
		u.setPassword("test");
		lista.add(u);
		assertEquals("admin", lista.get(0).getUsername());
		assertEquals("test", lista.get(0).getPassword());
	}

	@Test
	void testGetUserReadDto() {
		u.setId(1);
		u.setFirstname("Stefan");
		u.setLastname("Stefanovic");
		UserReadDto user1 = new UserReadDto();
		user1.setId(u.getId());
		user1.setFirstname(u.getFirstname());
		user1.setLastname(u.getLastname());
		assertEquals(1, user1.getId());
		assertEquals("Stefan", user1.getFirstname());
		assertEquals("Stefanovic" , user1.getLastname());
	}

	@Test
	void testGetAllUsers() {
		u.setId(1);
		u.setFirstname("Sreten");
		u.setLastname("Sretenovic");
		User user2 = new User();
		user2.setId(2);
		user2.setFirstname("Nikola");
		user2.setLastname("Nikolic");
		lista.add(u);
		lista.add(user2);
		assertEquals("Sreten", lista.get(0).getFirstname());
		assertEquals("Nikola", lista.get(1).getFirstname());
		assertEquals("Sretenovic", lista.get(0).getLastname());
		assertEquals("Nikolic", lista.get(1).getLastname());
	}

	@Test
	void testDelete() {
		u.setId(1);
		u.setUsername("admin");
		u.setLastname("test");
		lista.add(u);
		lista.remove(0);
		assertEquals(0, lista.size());
	}

	@Test
	void testSwitchIsAdmin() {
		u.setId(1);
		u.setUsername("admin");
		u.setLastname("test");
		lista.add(u);
		u.setAdmin(true);
		lista.set(0, u);
		assertTrue(u.isAdmin());
	}

	@Test
	void testTransferMoney() {
		double amount = 10000;
		u.setId(1);
		u.setFirstname("Sreten");
		u.setLastname("Sretenovic");
		u.setAmount(50000);
		User user2 = new User();
		user2.setId(2);
		user2.setFirstname("Nikola");
		user2.setLastname("Nikolic");
		user2.setAmount(20000);
		lista.add(u);
		lista.add(user2);
		u.setAmount(u.getAmount()+amount);
		user2.setAmount(user2.getAmount()-amount);
		lista.set(0, u);
		lista.set(1, user2);
		assertEquals(60000, lista.get(0).getAmount());
		assertEquals(10000, lista.get(1).getAmount());
		
	}

}
