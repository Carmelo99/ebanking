package com.ebanking.server.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.Bill;

/**
 * Interfejs koji sluzi za izvrsavanje upita nad tabelom Bill.
 * 
 * @author Antonije
 *
 */
public interface BillRepository extends JpaRepository<Bill, Integer>{

	/**
	 * Vraca sve racune sa zadatim id-em usera.
	 * 
	 * @param userId id korisnika
	 * @return ArrayList<Bill> lista racuna
	 */
	@Query("select b from Bill as b JOIN BillType as bt ON (b.type=bt.id) JOIN User as u ON "
			+ "(b.sender=u.id) where u.id=:user_id")
	ArrayList<Bill> getAllByUserId(@Param("user_id") int userId);

}
