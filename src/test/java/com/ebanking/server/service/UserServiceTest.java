package com.ebanking.server.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebanking.server.dto.UserReadDto;
import com.ebanking.server.model.BankCard;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.UserRepository;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
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
	void testLogin() {
		u = userRepository.login("steph", "test");
		assertEquals(1, u.getId());
		assertEquals("Stephen", u.getFirstname());
		assertEquals("Curry", u.getLastname());
	}

	@Test
	void testGetUserReadDto() {
		u.setId(1);
		u.setFirstname("Stefan");
		u.setLastname("Stefanovic");
		UserReadDto user1 = modelMapper.map(u, UserReadDto.class);
		assertEquals(1, user1.getId());
		assertEquals("Stefan", user1.getFirstname());
		assertEquals("Stefanovic" , user1.getLastname());
	}

	@Test
	void testGetAllUsers() {
		assertEquals(1, userRepository.getAllUsers().size());
	}

	@Test
	void testDelete() {
		u.setId(1);
		assertTrue(!u.equals(null));
	}

	@Test
	void testSwitchIsAdmin() {
		u = userRepository.getUserById(1);
		u.setAdmin(true);
		assertTrue(u.isAdmin());
	}

	@Test
	void testTransferMoney() {
		double amount = 1000;
		u = userRepository.getUserById(1);
		u.setAmount(u.getAmount()-amount);
		User user2 = userRepository.getByName("A", "D");
		user2.setAmount(user2.getAmount()+amount);
		assertEquals(296445, u.getAmount());
		assertEquals(503555, user2.getAmount());
		
	}

}
