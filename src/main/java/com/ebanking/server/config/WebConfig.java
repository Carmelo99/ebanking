package com.ebanking.server.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Konfiguraciona klasa koja omogucava mapiranja i GET, POST, PATCH, DELETE i OPTIONS zahteve.
 * 
 * @author Antonije
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * Metoda koja omogucava da server prima zahteve i sa drugih domena i portova sem svog sopstvenog.
	 */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	 registry.addMapping("/**")
         .allowedOrigins("*")
         .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
         .allowedHeaders("authorization", "content-type", "x-auth-token")
         .exposedHeaders("x-auth-token");
    }
    
    /**
     * Metoda koja omogucava mapiranje jedne klase u drugu.
     * 
     * @return modelMapper instancu klase ModelMapper.
     */
    @Bean
    public ModelMapper modelMapper() {
       ModelMapper modelMapper = new ModelMapper();
       return modelMapper;
    }
}
