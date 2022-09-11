package com.ebanking.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebanking.server.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM User as u WHERE (u.username=:username) AND (u.password=:password)")
	User login(String username, String password);

	@Query("select u from User as u")
	ArrayList<User> getAllUsers();

}
