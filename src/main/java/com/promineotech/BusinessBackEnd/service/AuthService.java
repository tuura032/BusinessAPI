package com.promineotech.BusinessBackEnd.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.promineotech.BusinessBackEnd.entity.Client;
import com.promineotech.BusinessBackEnd.entity.LoginCredentials;
import com.promineotech.BusinessBackEnd.entity.RegisterUser;
import com.promineotech.BusinessBackEnd.repository.ClientRepository;

@Service
public class AuthService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client register(RegisterUser newUser) throws AuthenticationException {
		Client client = new Client();
		client.setUsername(newUser.getUsername());
		client.setHash((BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt())));
		client.setEmail(newUser.getEmail());
		client.setFirstName(newUser.getFirstName());
		client.setLastName(newUser.getLastName());
		client.setPhone(newUser.getPhone());
		client.setDob(newUser.getDob());
		
		try {
			clientRepository.save(client);
			return client;
		} catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("Username not available.");
		}
	}
	
	public Client login(LoginCredentials cred) throws AuthenticationException {
		Client foundClient = clientRepository.findByUsername(cred.getUsername());
		if (foundClient != null && BCrypt.checkpw(cred.getPassword(), foundClient.getHash())) {
			return foundClient;
		}
		throw new AuthenticationException("Incorrect username or password.");
	}
}

// add methods to do jwt checking
