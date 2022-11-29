package com.ebanking.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebanking.server.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM User as u WHERE (u.username=:username) AND (u.password=:password)")
	User login(String username, String password);

	@Query("select u from User as u where id<>1")
	ArrayList<User> getAllUsers();

	@Query("delete from User as u where id=:id")
	void deleteUserById(int id);

	@Query("select u from User as u where id=:id")
	User getUserById(int id);

	@Query("select u from User as u where (u.firstname=:firstname) AND (u.lastname=:lastname)")
	User getByName(String firstname, String lastname);

}
