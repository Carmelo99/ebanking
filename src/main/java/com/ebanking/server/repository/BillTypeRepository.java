package com.ebanking.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.BillType;

public interface BillTypeRepository extends JpaRepository<BillType, Integer>{

	 @Query("select bt from BillType as bt where type=:type")
	 BillType getBillTypeByType(@Param("type") String type);

}
