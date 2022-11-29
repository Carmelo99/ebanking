package com.ebanking.server.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer>{

	@Query("select i from Insurance as i "
			+ "JOIN InsuranceCompany as ic "
			+ "ON (i.company=ic.tin)")
	ArrayList<Insurance> getAllInsurances();

	@Query("select i from Insurance as i JOIN User as u ON (u.insurance_number=i.code) "
			+ "JOIN InsuranceCompany as ic "
			+ "ON (i.company=ic.tin) where u.id=:userId")
	ArrayList<Insurance> getAllByUserId(int userId);

	@Query("select i from Insurance as i where i.code=:code")
	Insurance getByInsuranceCode(@Param("code") int code);

}
