package com.ebanking.server.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

	@Query("select b from Bill as b JOIN BillType as bt ON (b.type=bt.id) JOIN User as u ON "
			+ "(b.sender=u.id) where u.id=:user_id")
	ArrayList<Bill> getAllByUserId(@Param("user_id") int userId);

}
