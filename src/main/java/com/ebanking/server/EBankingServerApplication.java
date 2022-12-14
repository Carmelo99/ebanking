package com.ebanking.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Main klasa iz koje se pokrece serverski deo aplikacije.
 * 
 * @author Antonije
 *
 */
@ServletComponentScan
@SpringBootApplication
public class EBankingServerApplication {

	/**
	 * Main metoda klase EBankingServerApplication.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		SpringApplication.run(EBankingServerApplication.class, args);
		

	}



}
