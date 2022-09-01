package com.ebanking.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ebanking.server.model.User;
import com.ebanking.server.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;

	public User login(String username, String password) {
		return userRepository.login(username,password);
	}
	
}
