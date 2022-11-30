package com.ebanking.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebanking.server.model.InsuranceCompany;

/**
 * Interfejs koji sluzi za izvrsavanje upita nad tabelom InsuranceCompany.
 * 
 * @author Antonije
 *
 */
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Integer>{

}
