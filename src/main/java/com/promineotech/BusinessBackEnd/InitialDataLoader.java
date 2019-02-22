package com.promineotech.BusinessBackEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.BusinessBackEnd.entity.Client;
import com.promineotech.BusinessBackEnd.repository.ClientRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ClientRepository clientRepository;
	
	boolean alreadySetup = false;
	
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		if (alreadySetup) {
			return;
		}
		Client client = new Client();
		client.setUsername("admin");
		client.setHash((BCrypt.hashpw("admin", BCrypt.gensalt())));
		client.setEmail("admin@training.com");
		client.setFirstName("Paul");
		client.setLastName("Tuura");
		client.setRole("ROLE_ADMIN");
		client.setPhone("123456789");
		clientRepository.save(client);
		
		alreadySetup = true;
	}

}
