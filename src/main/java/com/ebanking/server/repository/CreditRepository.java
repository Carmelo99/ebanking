package com.ebanking.server.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.Credit;

/**
 * Interfejs koji sluzi za izvrsavanje upita nad tabelom Credit.
 * 
 * @author Antonije
 *
 */
public interface CreditRepository extends JpaRepository<Credit, Integer>{

	/**
	 * Vraca sve kredite sa zadatim id-em usera.
	 * 
	 * @param userId id korisnika
	 * @return ArrayList<Credit> lista kredita
	 */
	@Query("select c from Credit as c JOIN CreditType as ct ON (c.type=ct.id) JOIN User as u ON "
	+ "(c.sender=u.id) where u.id=:user_id")
	ArrayList<Credit> getAllByUserId(@Param("user_id") int userId);

}
