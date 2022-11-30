package com.ebanking.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebanking.server.model.User;

/**
 * Interfejs koji sluzi za izvrsavanje upita nad tabelom User.
 * 
 * @author Antonije
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{

	/**
	 * Vraca korisnika na osnovu korisnickog imena i lozinke.
	 * 
	 * @param username korisnicko ime
	 * @param password lozinka
	 * @return User korisnik
	 */
	@Query("SELECT u FROM User as u WHERE (u.username=:username) AND (u.password=:password)")
	User login(String username, String password);

	/**
	 * Vraca sve korisnike iz baze sem prvog korisnika.
	 * 
	 * @return ArrayList<User> lista korisnika
	 */
	@Query("select u from User as u where id<>1")
	ArrayList<User> getAllUsers();

	/**
	 * Brise korisnika u bazi po zadatom id-u.
	 * 
	 * @param id korisnikov id
	 */
	@Query("delete from User as u where id=:id")
	void deleteUserById(int id);

	/**
	 * Vraca korisnika iz baze po zadatom id-u.
	 * 
	 * @param id id korisnika
	 * @return User korisnik
	 */
	@Query("select u from User as u where id=:id")
	User getUserById(int id);

	/**
	 * Vraca korisnika iz baze po imenu i prezimenu.
	 * 
	 * @param firstname ime korisnika
	 * @param lastname prezime korisnika
	 * @return User korisnik
	 */
	@Query("select u from User as u where (u.firstname=:firstname) AND (u.lastname=:lastname)")
	User getByName(String firstname, String lastname);

}
