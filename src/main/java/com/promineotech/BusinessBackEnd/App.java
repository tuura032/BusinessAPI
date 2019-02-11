package com.promineotech.BusinessBackEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.BusinessBackEnd.repository.ClientRepository;

@SpringBootApplication
public class App {

	@Autowired
	static
    ClientRepository repo;
	
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
      
        
    }
}