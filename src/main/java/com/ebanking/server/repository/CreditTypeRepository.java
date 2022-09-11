package com.ebanking.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.CreditType;

public interface CreditTypeRepository extends JpaRepository<CreditType, Integer>{

	@Query("select ct from CreditType as ct where type=:type")
	CreditType getCreditTypeByType(@Param("type") String type);

}
