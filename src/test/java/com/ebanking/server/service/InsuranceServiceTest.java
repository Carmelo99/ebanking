package com.ebanking.server.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebanking.server.model.BankCard;
import com.ebanking.server.model.Insurance;
import com.ebanking.server.model.InsuranceCompany;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.InsuranceRepository;
import com.ebanking.server.repository.UserRepository;

@SpringBootTest
class InsuranceServiceTest {

	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
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
	void testGetAllInsurances() {
		assertEquals(3, insuranceRepository.getAllInsurances().size());
	}

	@Test
	void testGetAllByUserId() {
		User u = new User();
		u.setId(1);
		assertEquals(1, insuranceRepository.getAllByUserId(u.getId()).size());
	}

	@Test
	void testTakeInsurance() {
		User u = userRepository.getUserById(1);
		i = insuranceRepository.getByInsuranceCode(3);
		u.setInsurance_number(i);
		assertEquals(3, u.getInsurance_number().getCode());
	}

	@Test
	void testDeleteUserInsurance() {
		User u = userRepository.getUserById(1);
		assertEquals(3, u.getInsurance_number().getCode());
	}

}
