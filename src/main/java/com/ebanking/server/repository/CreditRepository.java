package com.ebanking.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebanking.server.model.Credit;

public interface CreditRepository extends JpaRepository<Credit, Integer>{

}
