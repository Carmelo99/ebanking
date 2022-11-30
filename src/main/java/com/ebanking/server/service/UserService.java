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

/**
 * Klasa koja predstavlja servis za klasu User.
 * Ona obradjuje zahteve prosledjene iz kontrolera User.
 * 
 * @author Antonije
 *
 */
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
	
	/**
	 * Poziva metodu iz UserRepository i vraca korisnika na osnovu korisnickog imena i lozinka.
	 * 
	 * @param username korisnicko ime
	 * @param password lozinka
	 * @return User
	 */
	public User login(String username, String password) {
		return userRepository.login(username,password);
	}

	/**
	 * Mepira User u UserReadDto klasu radi transfera ka korisniku.
	 * 
	 * @param user korisnik
	 * @return UserReadDto dto korisnika prilikom citanja iz baze
	 */
	public UserReadDto getUserReadDto(User user) {
		UserReadDto userReadDto = modelMapper.map(user, UserReadDto.class);
		return userReadDto;
	}

	/**
	 * Poziva metodu UserRepository i vraca sve korisnike.
	 * 
	 * @return ArrayList<User> lista korisnika
	 */
	public ArrayList<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	/**
	 * Poziva metodu iz UserRepository i brise korisnika po id-u.
	 * 
	 * @param id id korisnika
	 */
	public void delete(int id) {
		System.out.println("Obrisano");
		userRepository.deleteUserById(id);	
	}

	/**
	 * Postavlja korisniku koji je vracen na osnovu id-a admin ulogu ili je oduzima.
	 * 
	 * @param id id korisnika
	 * @param isAdmin da li je korisnik admin
	 */
	public void switchIsAdmin(int id, boolean isAdmin) {
		
		User user = userRepository.getUserById(id);
		
		user.setAdmin(isAdmin);
		
		userRepository.save(user);
		
		
		
	}

	/**
	 * Smanjuje novac sa racuna korisnika ciji je id prosledjen i prebacuje korisniku koji je pronadjen po imenu i prezimenu.
	 * 
	 * @param firstname ime korisnika
	 * @param lastname prezime korisnika
	 * @param amount iznos za transfer
	 * @param id korisnika koji salje novac
	 */
	public void transferMoney(String firstname, String lastname, double amount, int id) {
		
		User u = userRepository.getUserById(id);
		
		u.setAmount(u.getAmount()-amount);
		
		userRepository.save(u);
		
		User user = userRepository.getByName(firstname,lastname);
		
		user.setAmount(user.getAmount()+amount);
		
		userRepository.save(user);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
