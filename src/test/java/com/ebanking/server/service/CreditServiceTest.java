package com.ebanking.server.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebanking.server.model.Credit;
import com.ebanking.server.model.CreditType;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.CreditRepository;
import com.ebanking.server.repository.CreditTypeRepository;
import com.ebanking.server.repository.UserRepository;

@SpringBootTest
class CreditServiceTest {

	@Autowired
	private CreditRepository creditRepository;
	
	@Autowired
	private CreditTypeRepository creditTypeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	Credit c;
	
	@BeforeEach
	void setUp() throws Exception {
		c = new Credit();
	}

	@AfterEach
	void tearDown() throws Exception {
		c = null;
	}

	@Test
	void testGetAllByUserId() {
		User u = new User();
		u.setId(1);
		assertEquals(6, creditRepository.getAllByUserId(u.getId()).size());
	}

	@Test
	void testApplyForCredit() {
		User u = userRepository.getUserById(1);
		CreditType ct = creditTypeRepository.getCreditTypeByType("na 20 godina");
		c.setType(ct);
		c.setSender(u);
		assertEquals(1, c.getSender().getId());
		assertEquals(2, c.getType().getId());
	}

}
