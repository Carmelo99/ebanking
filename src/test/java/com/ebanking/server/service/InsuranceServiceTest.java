package com.ebanking.server.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ebanking.server.model.BankCard;
import com.ebanking.server.model.Insurance;
import com.ebanking.server.model.InsuranceCompany;
import com.ebanking.server.model.User;

class InsuranceServiceTest {

	ArrayList<Insurance> lista;
	
	Insurance i;
	
	@BeforeEach
	void setUp() throws Exception {
		lista = new ArrayList<>();
		i = new Insurance();
	}

	@AfterEach
	void tearDown() throws Exception {
		lista = null;
		i = null;
	}

	@Test
	void testGetAllInsurances() {
		i.setCode(111);
		i.setInsurance_name("osiguranje1");
		Insurance i2 = new Insurance();
		i2.setCode(123);
		i2.setInsurance_name("osiguranje2");
		lista.add(i);
		lista.add(i2);
		assertEquals("osiguranje1", lista.get(0).getInsurance_name());
		assertEquals("osiguranje2", lista.get(1).getInsurance_name());
	}

	@Test
	void testGetAllByUserId() {
		User u = new User();
		u.setId(1);
		i.setCode(123);
		i.setInsurance_name("Putno osiguranje");
		InsuranceCompany ic = new InsuranceCompany();
		ic.setCompany_name("Dunav osiguranje");
		i.setCompany(ic);
		u.setInsurance_number(i);
		lista.add(i);
		assertEquals("Dunav osiguranje", lista.get(0).getCompany().getCompany_name());
		assertEquals("Putno osiguranje", u.getInsurance_number().getInsurance_name());
	}

	@Test
	void testTakeInsurance() {
		User u = new User();
		u.setId(1);
		i.setCode(123);
		i.setInsurance_name("Zivotno osiguranje");
		lista.add(i);
		u.setInsurance_number(lista.get(0));
		assertEquals("Zivotno osiguranje", u.getInsurance_number().getInsurance_name());
	}

	@Test
	void testDeleteUserInsurance() {
		i.setCode(123);
		i.setInsurance_name("Zivotno osiguranje");
		lista.add(i);
		lista.remove(0);
		assertEquals(0, lista.size());
	}

}
