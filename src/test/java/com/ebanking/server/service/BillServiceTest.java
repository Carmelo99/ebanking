package com.ebanking.server.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebanking.server.model.Bill;
import com.ebanking.server.model.BillType;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.BillRepository;
import com.ebanking.server.repository.BillTypeRepository;
import com.ebanking.server.repository.UserRepository;

@SpringBootTest
class BillServiceTest {

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private BillTypeRepository billTypeRepository;
	
	@Autowired
	private UserRepository userRepository;

	
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
	void testGetAllByUserId() {
		User u = new User();
		u.setId(1);
		assertEquals(5, billRepository.getAllByUserId(u.getId()).size());
	}

	@Test
	void testPayBill() {
		BillType billType = billTypeRepository.getBillTypeByType("Racun preduzeca");
		User u = userRepository.getUserById(1);
		b.setType(billType);
		b.setSender(u);
		assertEquals(1, b.getSender().getId());
		assertEquals(1, b.getType().getId());
	}

}
