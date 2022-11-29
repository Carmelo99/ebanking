package com.ebanking.server.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ebanking.server.model.BankCard;

public interface BankCardRepository extends JpaRepository<BankCard, Integer>{

	@Query("select bc from BankCard as bc JOIN User as u ON (u.id=bc.card_owner) where "
			+ "u.id=:user_id")
	ArrayList<BankCard> getAllByUserId(@Param("user_id") int userId);

	@Query("select bc from BankCard as bc where bc.card_number=:card")
	BankCard getByCardNumber(@Param("card") int cardNumber);

	@Query("select bc from BankCard as bc JOIN User as u ON (u.id=bc.card_owner)")
	ArrayList<BankCard> getAllBankCards();

	@Query("select bc from BankCard as bc where bc.card_number=:id")
	BankCard getBankCardById(int id);

}
