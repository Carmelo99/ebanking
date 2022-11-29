package com.ebanking.server.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.server.model.Insurance;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.InsuranceRepository;
import com.ebanking.server.repository.UserRepository;

@Service
public class InsuranceService {

	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	private UserRepository userRepository;

	public ArrayList<Insurance> getAllInsurances() {
		return insuranceRepository.getAllInsurances();
	}
	
	public ArrayList<Insurance> getAllByUserId(int userId) {
		return insuranceRepository.getAllByUserId(userId);
	}

	public void takeInsurance(int id, int code) {

		User user = userRepository.getUserById(id);
		
		Insurance insurance = insuranceRepository.getByInsuranceCode(code);
		
		user.setInsurance_number(insurance);
		
		userRepository.save(user);
		
	}

	public void deleteUserInsurance(int id) {
		
		User u = userRepository.getUserById(id);
		
		u.setInsurance_number(null);
		
		userRepository.save(u);
		
	}
	
	

	
}
