package com.ebanking.server.service;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebanking.server.dto.BillCreateDto;
import com.ebanking.server.model.Bill;
import com.ebanking.server.model.BillType;
import com.ebanking.server.model.User;
import com.ebanking.server.repository.BillRepository;
import com.ebanking.server.repository.BillTypeRepository;
import com.ebanking.server.repository.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * Klasa koja predstavlja servis za klasu Bill.
 * Ona obradjuje zahteve prosledjene iz kontrolera Bill.
 * 
 * @author Antonije
 *
 */
@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private BillTypeRepository billTypeRepository;
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * Vraca sve racune iz baze na osnovu id-a korisnika.
	 * 
	 * @param userId id korisnika
	 * @return ArrayList<Bill> lista racuna
	 */
	public ArrayList<Bill> getAllByUserId(int userId) {
		return billRepository.getAllByUserId(userId);
	}

	/**
	 * Placanje racuna.
	 * Cuva se novi racun u bazi koji je korisnik platio.
	 * 
	 * @param billCreateDto dto za upis racuna u bazu
	 * @return BillCreateDto dto za upis racuna u bazu
	 */
	public BillCreateDto payBill(BillCreateDto billCreateDto)  {
		
		try {
		BillType billType = billTypeRepository.getBillTypeByType(billCreateDto.getType());
		
		
		Optional<User> user = userRepository.findById(billCreateDto.getUser_id());

		Bill newBill = new Bill();
		System.out.println(billCreateDto.getType()+" "+billCreateDto.getAmount()+" "+billCreateDto.getUser_id()+" "+billCreateDto.getPayment_purpose()+ " "+ billCreateDto.getReceiver());
		newBill.setPayment_purpose(billCreateDto.getPayment_purpose());
		newBill.setReceiver(billCreateDto.getReceiver());
		newBill.setType(billType);
		newBill.setAmount(billCreateDto.getAmount());
		newBill.setSender(user.get());

		billRepository.save(newBill);
		
		JsonObject bill = new JsonObject();
		
		bill.addProperty("payment_purpose", newBill.getPayment_purpose());
		bill.addProperty("receiver", newBill.getReceiver());
		bill.addProperty("type", newBill.getType().getType());
		bill.addProperty("amount", newBill.getAmount());
		bill.addProperty("sender firstname", newBill.getSender().getFirstname());
		bill.addProperty("sender lastname", newBill.getSender().getLastname());
		
		try (FileWriter file = new FileWriter("bills_and_kredits.json",true)) {
			JsonObject obj = new JsonObject();
			
			obj.add("bill", bill);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			gson.toJson(obj, file);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return billCreateDto;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return null;
	}
	
	
	
}
