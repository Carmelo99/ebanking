package com.ebanking.server.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ebanking.server.dto.UserReadDto;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
//
//	public List<User> login(User user) {
//		return userRepository.login(user.getUsername(),user.getPassword());
//	}
	
	public User login(String username, String password) {
		return userRepository.login(username,password);
	}

	public UserReadDto getUserReadDto(User user) {
		UserReadDto userReadDto = modelMapper.map(user, UserReadDto.class);
		return userReadDto;
	}

	public ArrayList<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
}
