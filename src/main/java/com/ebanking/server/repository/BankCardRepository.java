package com.ebanking.server.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.BankCard;

/**
 * Interfejs koji sluzi za izvrsavanje upita nad tabelom BankCard.
 * 
 * @author Antonije
 *
 */
public interface BankCardRepository extends JpaRepository<BankCard, Integer>{

	/**
	 * Vraca sve kartice iz baze sa zadatim id-em korisnika.
	 * 
	 * @param userId id korisnika
	 * @return ArrayList<BankCard> lista kartica
	 */
	@Query("select bc from BankCard as bc JOIN User as u ON (u.id=bc.card_owner) where "
			+ "u.id=:user_id")
	ArrayList<BankCard> getAllByUserId(@Param("user_id") int userId);

	/**
	 * Vraca karticu iz baze sa zadatim brojem kartice.
	 * 
	 * @param cardNumber broj kartice
	 * @return BankCard kartica za banku
	 */
	@Query("select bc from BankCard as bc where bc.card_number=:card")
	BankCard getByCardNumber(@Param("card") int cardNumber);

	/**
	 * Vraca sve kartice iz banke.
	 * 
	 * @return ArrayList<BankCard> lista kartica
	 */
	@Query("select bc from BankCard as bc JOIN User as u ON (u.id=bc.card_owner)")
	ArrayList<BankCard> getAllBankCards();

	/**
	 * Vraca sve kartice iz banke za zadati id kartice.
	 * 
	 * @param id kartica id
	 * @return BankCard kartica za banku
	 */
	@Query("select bc from BankCard as bc where bc.card_number=:id")
	BankCard getBankCardById(int id);

}
