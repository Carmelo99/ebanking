package com.ebanking.server.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.Insurance;

/**
 * Interfejs koji sluzi za izvrsavanje upita nad tabelom Insurance.
 * 
 * @author Antonije
 *
 */
public interface InsuranceRepository extends JpaRepository<Insurance, Integer>{

	/**
	 * Vraca sva osiguranja.
	 * 
	 * @return ArrayList<Insurance> lista osiguranja
	 */
	@Query("select i from Insurance as i "
			+ "JOIN InsuranceCompany as ic "
			+ "ON (i.company=ic.tin)")
	ArrayList<Insurance> getAllInsurances();

	/**
	 * Vraca sva osiguranja sa zadatim id-em korisnika.
	 * 
	 * @param userId id korisnika
	 * @return ArrayList<Insurance> lista osiguranja
	 */
	@Query("select i from Insurance as i JOIN User as u ON (u.insurance_number=i.code) "
			+ "JOIN InsuranceCompany as ic "
			+ "ON (i.company=ic.tin) where u.id=:userId")
	ArrayList<Insurance> getAllByUserId(int userId);

	/**
	 * Vraca osiguranje po sifri osiguranja.
	 * 
	 * @param code sifra osiguranja
	 * @return Insurance osiguranje
	 */
	@Query("select i from Insurance as i where i.code=:code")
	Insurance getByInsuranceCode(@Param("code") int code);

}
