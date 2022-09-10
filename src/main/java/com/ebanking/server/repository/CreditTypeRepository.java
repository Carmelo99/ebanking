package com.ebanking.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebanking.server.model.CreditType;

public interface CreditTypeRepository extends JpaRepository<CreditType, Integer>{

}
