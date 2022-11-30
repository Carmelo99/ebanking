package com.ebanking.server.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.server.dto.CreditCreateDto;
import com.ebanking.server.model.Bill;
import com.ebanking.server.model.BillType;
import com.ebanking.server.model.Credit;
import com.ebanking.server.model.CreditType;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.CreditRepository;
import com.ebanking.server.repository.CreditTypeRepository;
import com.ebanking.server.repository.UserRepository;

/**
 * Klasa koja predstavlja servis za klasu Credit.
 * Ona obradjuje zahteve prosledjene iz kontrolera Credit.
 * 
 * @author Antonije
 *
 */
@Service
public class CreditService {

	@Autowired
	private CreditRepository creditRepository;
	
	@Autowired
	private CreditTypeRepository creditTypeRepository;
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * Vraca sve kredite iz baze na osnovu id-a korisnika.
	 * 
	 * @param userId id korisnika
	 * @return ArrayList<Credit> lista kredita
	 */
	public ArrayList<Credit> getAllByUserId(int userId) {
		return creditRepository.getAllByUserId(userId);
	}

	/**
	 * Apliciranje za kredit.
	 * Cuva se novi kredit u bazi za koji je korisnik aplicirao.
	 * 
	 * @param creditCreateDto dto za upis kredita u bazu
	 * @return CreditCreateDto dto za upis kredita u bazu
	 */
	public CreditCreateDto applyForCredit(CreditCreateDto creditCreateDto) {
		
		try {
			CreditType creditType = creditTypeRepository.getCreditTypeByType(creditCreateDto.getType());
			
			
			Optional<User> user = userRepository.findById(creditCreateDto.getUser_id());

			Credit newCredit = new Credit();
			System.out.println(creditCreateDto.getType()+" "+creditCreateDto.getAmount()+" "+creditCreateDto.getUser_id());
			newCredit.setType(creditType);
			newCredit.setAmount(creditCreateDto.getAmount());
			newCredit.setSender(user.get());

			creditRepository.save(newCredit);
			
			return creditCreateDto;
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			return null;
	}
	
}
