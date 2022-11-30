package com.ebanking.server.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.server.model.Insurance;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.InsuranceRepository;
import com.ebanking.server.repository.UserRepository;

/**
 * Klasa koja predstavlja servis za klasu Insurance.
 * Ona obradjuje zahteve prosledjene iz kontrolera Insurance.
 * 
 * @author Antonije
 *
 */
@Service
public class InsuranceService {

	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * Poziva metodu InsuranceRepository i vraca sva osiguranja iz baze.
	 * 
	 * @return ArrayList<Insurance> lista osiguranja
	 */
	public ArrayList<Insurance> getAllInsurances() {
		return insuranceRepository.getAllInsurances();
	}
	
	/**
	 * Poziva metodu InsuranceRepository i vraca sva osiguranja iz baze sa zadatim id-em korisnika.
	 * 
	 * @param userId korisnikov id
	 * @return ArrayList<Insurance> lista osiguranja
	 */
	public ArrayList<Insurance> getAllByUserId(int userId) {
		return insuranceRepository.getAllByUserId(userId);
	}

	/**
	 * Dodeljuje korisniku izabrano osiguranje.
	 * Vraca korisnika na osnovu id-a, osiguranje na osnovu sifre i dodeljuje osiguranje tom korisniku.
	 * 
	 * @param id id korisnika
	 * @param code sifra osiguranja
	 */
	public void takeInsurance(int id, int code) {

		User user = userRepository.getUserById(id);
		
		Insurance insurance = insuranceRepository.getByInsuranceCode(code);
		
		user.setInsurance_number(insurance);
		
		userRepository.save(user);
		
	}

	/**
	 * Brise osiguranje korisnika.
	 * Vraca korisnika iz baze i postavlja mu broj osiguranja na null.
	 * 
	 * @param id korisnikov id
	 */
	public void deleteUserInsurance(int id) {
		
		User u = userRepository.getUserById(id);
		
		u.setInsurance_number(null);
		
		userRepository.save(u);
		
	}
	
	

	
}
