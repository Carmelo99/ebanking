package com.ebanking.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.BillType;

/**
 * Interfejs koji sluzi za izvrsavanje upita nad tabelom BillType.
 * 
 * @author Antonije
 *
 */
public interface BillTypeRepository extends JpaRepository<BillType, Integer>{

	/**
	 * Vraca sve tipove racuna sa zadatim nazivom tipa racuna.
	 * 
	 * @param type naziv tipa racuna
	 * @return BillType tip racuna
	 */
	 @Query("select bt from BillType as bt where type=:type")
	 BillType getBillTypeByType(@Param("type") String type);

}
