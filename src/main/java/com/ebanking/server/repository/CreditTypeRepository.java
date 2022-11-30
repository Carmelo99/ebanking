package com.ebanking.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.CreditType;

/**
 * Interfejs koji sluzi za izvrsavanje upita nad tabelom CreditType.
 * 
 * @author Antonije
 *
 */
public interface CreditTypeRepository extends JpaRepository<CreditType, Integer>{

	/**
	 * Vraca sve tipove kredita sa zadatim nazivom tipa kredita.
	 * 
	 * @param type naziv tipa kredita
	 * @return CreditType tip kredita
	 */
	@Query("select ct from CreditType as ct where type=:type")
	CreditType getCreditTypeByType(@Param("type") String type);

}
